package game;

import fixtures.Room;
import fixtures.Item;

public class RoomManager {
	Room startingRoom;
	Room[][] rooms = new Room[4][4];
	Player player;
	
	
	public RoomManager(Player player)
	{
		this.player = player;
		player.setRoomManager(this);
	}
   

	// creates rooms and items at the start of the program
   public void init()
   {
	   Item knife = new Item("knife", "This knife can be used to cut all kinds of things.");
	   
	   Room room1 = new Room(
                           "Bedroom", 
                           "A simple, small bedroom", 
                           "A square room with nothing but a plain bed in one corner and a wooden desk on the opposite wall." + "\n"
                              + "There is a door that's ajar to the east..." + "\n", 
                            null,
                            knife);
	   rooms[0][1] = room1;
	   startingRoom = room1;
      
      
	   Room room2 = new Room(
			              "Hallway", 
			              "An L-shaped hallway", 
			              "A narrow hallway with gaudy paintings and designs along the white walls." + "\n"
			                 + "After the bend, to the south, is an open doorway." + "\n",
			              knife, 
			              null);
	   	rooms[1][1] = room2;	
	   	
	   	Room room3 = new Room(
		              "The second room", 
		              "a small foyer", 
		              "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
		                 + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
		                 + "To the north is a small room, where you can see a piano.", 
		              null, 
		              null);
	   	rooms[1][3] = room3;
	   	
	   	Room room4 = new Room(
		              "The second room", 
		              "a small foyer", 
		              "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
		                 + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
		                 + "To the north is a small room, where you can see a piano.", 
		              null, 
		              null);
	   	rooms[2][3] = room4;
   }
   
   
   /* If I had more time I could setup an option to create the map randomly each time the application runs
//   private void setupExits()
//   {
//	   if (randomExits)
//	   {
//		   
//	   }
//	   else
//	   {
//		   
//	   }
//   }
*/  
   
   public int[] getRoomCoordinates(Room room)
   {
	   for (int row = 0; row < 5; row++)
	   {
		   for (int column = 0; column < 5; column++)
		   {
			   if (rooms[row][column] == room) return new int[] {row, column};
		   }
	   }
	   return null;
   }
   
   // returns if a room exists in a given location
   public boolean doesRoomExist(int[] roomLocation)
   {
	   return !(rooms[roomLocation[0]][roomLocation[1]] == null);
   }
   
   
}
