package game;

import java.util.ArrayList;

import fixtures.Room;

public class RoomManager {
   Room startingRoom;
   ArrayList<Room> rooms = new ArrayList<Room>();

   public void init()
   {
      Room foyer = new Room(
                           "The Foyer", 
                           "a small foyer", 
                           "The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
                              + "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
                              + "To the north is a small room, where you can see a piano.");
      rooms.add(foyer);
      this.startingRoom = foyer;
     
      
   }
}
