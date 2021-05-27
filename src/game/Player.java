package game;

public class Player {
   public int posX = 0;
   public int posY = 0;
   private RoomManager roomManager;
   public String[] inventory = new String[] {};
   

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

   // decided if it is possible to move in the specified direction, and if it is, moves the player and returns true
   public boolean moveRooms(String direction)
   {
	   boolean moved = false;
	   switch (direction)
	   {
	   case "north":
		   if (!roomManager.doesRoomExist(new int[] {posX, posY - 1})) // if cannot move in that direction, print to user and return from method
		   {
			   	cannotMove();
			   	break;
		   }
		   posY--;
		   moved = true;
		   break;
	   case "east":
		   if (!roomManager.doesRoomExist(new int[] {posX + 1, posY}))
		   {
			   	cannotMove();
			   	break;
		   }
		   posX++;
		   moved = true;
		   break;
	   case "south":
		   if (!roomManager.doesRoomExist(new int[] {posX, posY + 1}))
		   {
			   	cannotMove();
		   		break;
		   }
		   posY++;
		   moved = true;
		   break;
	   case "west":
		   if (!roomManager.doesRoomExist(new int[] {posX - 1, posY}))
		   {
			   	cannotMove();
			   	break;
		   }
		   posX--;
		   moved = true;
		   break;
	   default:
		   System.out.println("Invalid direction entered.");
		   return moved;
	   }
	   
	   if (moved)
	   {
		   System.out.println("You walk into the room in the " + direction + ".");		   
	   }
	   return moved; // by default, flow breaks out of switch statement and returns false, but if the player can move in the specified direction, the player moves and this function returns true
	   
   }
   
   private void cannotMove()
   {
	   System.out.println("\n\nYou cannot move in that direction.\n");
   }
   
   public void printInventory()
   {
	   System.out.println("\n");
	   int i = 1;
	   for (String item : inventory)
	   {
		   System.out.println(i + ": " + item);
		   i++;
	   }
   }
   
   
}
