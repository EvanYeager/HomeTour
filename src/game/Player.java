package game;
import fixtures.Item;
import fixtures.Room;
import java.util.ArrayList;

public class Player {
   public int posX = 0;
   public int posY = 0;
   private RoomManager roomManager;
   public ArrayList<Item> inventory = new ArrayList<Item>();
   

   public Player(int[] startingCoordinates)
   {
	   this.posX = startingCoordinates[0];
	   this.posY = startingCoordinates[1];   
	   
   }
   
   public RoomManager getRoomManager() 
   {
	return roomManager;
   }

	public void setRoomManager(RoomManager roomManager) 
	{
		this.roomManager = roomManager;
	}

   // decide if it is possible to move in the specified direction, and if it is, moves the player and returns true
   public boolean moveRooms(String direction)
   {
	   int newPosX = posX;
	   int newPosY = posY;
	   
	   switch (direction)
	   {
	   case "north":
		   newPosY--;
		   break;
	   case "east":
		   newPosX++;
		   break;
	   case "south":
		   newPosY++;
		   break;
	   case "west":
		   newPosX--;
		   break;
	   default:
		   System.out.println("Invalid direction entered.");
		   return false;
	   }
	   
	   if(!roomManager.doesRoomExist(new int[] {newPosX, newPosY}))
	   {
		   System.out.println("\n\nYou cannot move in that direction.\n");
		   return false;
	   }
	   
	   walk(new int[] {newPosX, newPosY});
	   
	   System.out.println("You walk into the room in the " + direction + ".");
	   return true;
   }
   
   private void walk(int[] targetCoordinates)
   {
	   posX = targetCoordinates[0];
	   posY = targetCoordinates[1];
	   for (int i = 0; i < 3; i++)
	   {
		   System.out.println(".");
		   try {
			Thread.sleep(500);
		   } catch (InterruptedException e) {
			e.printStackTrace();
			}
	   }
   }
   
   public void printInventory()
   {
	   if (inventory.size() == 0)
	   {
		   System.out.println("You don't have any items with you.\n");
		   return;
	   }
	   
	   System.out.println("\n");
	   for (Item item : inventory)
	   {
		   item.describe();
	   }
   }
   
   public void placeItem(String itemName)
   {
	   Item item = getItemFromName(itemName);
	   if (item == null)
	   {
		   System.out.println("You don't have an item with that name.");
		   return;
	   }
	   Room currentRoom = roomManager.rooms[posX][posY];
	   if (canPlaceItem(item, currentRoom))
	   {
		   currentRoom.takeItem(item, this);
		   inventory.remove(item);
	   }
	   else
	   {
		   System.out.println("You cannot place an item in a room that already has an item. \nFirst, please take the item in the room.");
		   return;
	   }
   }
   
   public Item getItemFromName(String name)
   {
	   for (Item item : inventory)
	   {
		   if (item.name.equals(name)) return item;
	   }
	   return null;
   }
   
   // returns true if the room doesn't have an item
   private boolean canPlaceItem(Item item, Room currentRoom)
   {
	   return currentRoom.currentItem == null;
   }
   
   public void takeItem()
   {
	   Room currentRoom = roomManager.rooms[posX][posY];
	   if (currentRoom.currentItem == null)
	   {
		   System.out.println("This room does not contain an item.");
		   return;
	   }
	   inventory.add(currentRoom.currentItem);
	   System.out.println("You picked up the " + currentRoom.currentItem.name + ".");
	   currentRoom.currentItem = null;
   }
   
}
