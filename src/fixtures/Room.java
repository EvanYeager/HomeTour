package fixtures;


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
   
   public void takeItem(Item item)
   {
	   currentItem = item;
	   System.out.println("-- You placed your " + item.name + " in the room. --\n");
	   if (currentItem == correspondingItem)
	   {
		   cueRoomEffect();
	   }
   }
   
   // If I had more time, I could make this function perform some action to advance the game
   private void cueRoomEffect()
   {
	   System.out.println("This item has a special effect in this room!");
   }
}
