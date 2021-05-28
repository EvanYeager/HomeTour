package fixtures;

import game.Player;

public class Room extends Fixture{
   String longDescription;
   public Item currentItem;
   public Item correspondingItem;

   public Room(String name, String shortDescription, String longDescription, Item currentItem, Item correspondingItem)
   {
      super(name, shortDescription);
      this.longDescription = longDescription;
      this.currentItem = currentItem;
      this.correspondingItem = correspondingItem;
   }

   // room-specific implementation of the abstract describe() method in Fixture class
   @Override
   public void describe()
   {
	   System.out.println("||     " + name + "     ||\n");
	   System.out.println(shortDescription + "\n");
	   System.out.println(longDescription + "\n");
	   if (currentItem != null)
	   {
		   System.out.println("There is a " + currentItem.name + " in this room.\n");
	   }
   }
   
   public void takeItem(Item item, Player player)
   {
	   currentItem = item;
	   System.out.println("-- You placed your " + item.name + " in the room. --\n");
	   if (currentItem == correspondingItem)
	   {
		   cueRoomEffect(player);
	   }
   }
   
   
   private void cueRoomEffect(Player player)
   {
	   if (this.name.equals("Bedroom"))
	   {
		   System.out.println("You cut into the mattress with your knife. You open it up to reveal a key! You put it in your pocket.");
		   Item key = new Item("key", "A key that unlocks a locked door.");
		   player.inventory.add(key);
	   }
	   else if (this.name.equals("Exit Room"))
	   {
		   System.out.println("You insert the key into the locked door. With a twist of the doorknob, the door swings open.");
		   System.out.println("Congratulations! You made it out of the house! Exiting the game...");
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		   System.exit(0);
	   }
   }
}
