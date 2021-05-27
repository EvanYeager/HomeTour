package game;

import fixtures.Room;

public class RoomManager {
	// TODO make a predefined map
	Room startingRoom;
	Room[][] rooms = new Room[4][4];
	Player player;
	
	
	public RoomManager(Player player)
	{
		this.player = player;
	}
   

   public void init()
   {
      Room room1 = new Room(
                           "The Foyer", 
                           "A small foyer", 
                           "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
                              + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
                              + "To the north is a small room, where you can see a piano.");
      rooms[0][1] = room1;
      startingRoom = room1;
      
      
      Room room2 = new Room(
			              "The second room", 
			              "a small foyer", 
			              "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
			                 + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
			                 + "To the north is a small room, where you can see a piano.");
	   rooms[1][1] = room2;	
   }
   
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
