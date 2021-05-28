package game;

import fixtures.Room;
import fixtures.Item;

public class RoomManager {
	Room startingRoom;
	Room[][] rooms = new Room[4][4];
	Player player;
	Item knife = new Item("knife", "This knife can be used to cut all kinds of things.");
	Item key = new Item("key", "A key that unlocks a locked door.");
	
	
	public RoomManager(Player player)
	{
		this.player = player;
		player.setRoomManager(this);
	}
   

	// creates rooms
   public void init()
   {
	   
	   Room room1 = new Room(
                           "Bedroom", 
                           "A simple, small bedroom", 
                           "A square room with nothing but a plain bed in one corner and a wooden desk on the opposite wall." + "\n"
                              + "There is a door that's ajar to the east..." + "\n", 
                            null,
                            knife);
	   rooms[1][0] = room1;
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
		              "Third room", 
		              "short description", 
		              "long description\n" + 
		              "There is a room to the east", 
		              null, 
		              null);
	   	rooms[2][1] = room3;
	   	
	   	Room room4 = new Room(
		              "Exit Room", 
		              "The room at the end", 
		              "This room has a locked door at the far end the leads to outside. A key should be able to open it.", 
		              null, 
		              key);
	   	rooms[2][2] = room4;
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

   // returns if a room exists in a given location
   public boolean doesRoomExist(int[] roomLocation)
   {
	   return !(rooms[roomLocation[0]][roomLocation[1]] == null);
   }
   
   
}
