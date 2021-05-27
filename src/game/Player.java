package game;

public class Player {
   public int posX = 0;
   public int posY = 0;
   private RoomManager roomManager;
   

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

   
   public void moveRooms(String direction)
   {
	   direction = direction.toLowerCase();
	   switch (direction)
	   {
	   case "north":
		   if (!roomManager.doesRoomExist(new int[] {posX, posY - 1})) // if cannot move in that direction, print to user and return from method
		   {
			   	cannotMove();
		   		return;
		   }
		   posY--;
		   break;
	   case "east":
		   if (!roomManager.doesRoomExist(new int[] {posX + 1, posY}))
		   {
			   	cannotMove();
		   		return;
		   }
		   posX++;
		   break;
	   case "south":
		   if (!roomManager.doesRoomExist(new int[] {posX, posY + 1}))
		   {
			   	cannotMove();
		   		return;
		   }
		   posY++;
		   break;
	   case "west":
		   if (!roomManager.doesRoomExist(new int[] {posX - 1, posY}))
		   {
			   	cannotMove();
		   		return;
		   }
		   posX--;
		   break;
	   default:
		   System.out.println("Invalid direction entered.");
		   return;
	   }
	   System.out.println("You walk into the room in the " + direction + ".");
	   
   }
   
   private void cannotMove()
   {
	   System.out.println("\n\nYou cannot move that direction.\n");
   }
   
   
}
