package fixtures;

import java.util.Map;

public class Room extends Fixture{
   Map<Direction, Room> exits;
   boolean randomExits;

   public Room(String name, String shortDescription, String longDescription)
   {
      super(name, shortDescription, longDescription);
   }
   
   // TODO complete this function where it generates a random map if randomExits == true, or uses the roomManager's map if false
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

   // public Room[] getExits()
   // {

   // }

   // public Room getExit(String direction)
   // {

   // }
}
