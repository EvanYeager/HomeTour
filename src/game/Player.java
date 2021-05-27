package game;

import fixtures.Room;

public class Player {
   public int posX = 0;
   public int posY = 0;
   public Main main;
   

   public Player(int[] startingCoordinates, Main main)
   {
      this.posX = startingCoordinates[0];
      this.posY = startingCoordinates[1];
      this.main = main;
   }
   
   public void moveRooms(String direction)
   {
	   direction = direction.toLowerCase();
	   switch (direction)
	   {
	   case "north":
		   if (!main.roomManager.doesRoomExist(new int[] {posX, posY - 1})) // if cannot move in that direction, print to user and return from method
		   {
			   	cannotMove();
		   		return;
		   }
		   posY--;
		   break;
	   case "east":
		   if (!main.roomManager.doesRoomExist(new int[] {posX + 1, posY}))
		   {
			   	cannotMove();
		   		return;
		   }
		   posX++;
		   break;
	   case "south":
		   if (!main.roomManager.doesRoomExist(new int[] {posX, posY + 1}))
		   {
			   	cannotMove();
		   		return;
		   }
		   posY++;
		   break;
	   case "west":
		   if (!main.roomManager.doesRoomExist(new int[] {posX - 1, posY}))
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
	   System.out.println("You cannot move that direction.");
   }
   
   
}
