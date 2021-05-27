package game;

import java.util.Scanner;

public class Main {
	static final int[] startingCoordinates = {0, 1};
	
	static Player player = new Player(startingCoordinates, );
	static RoomManager roomManager = new RoomManager(player);
	static Scanner scan = new Scanner(System.in);
	
   public static void main(String[] args) 
   {
	   printWelcomeText();
	   roomManager.init();
	   
	   while(true)
	   {
		   printCurrentRoom();
		   
		   parse(collectInput());
		   
	   }
   }
   
   private static void printWelcomeText()
   {
	   System.out.println("placeholder");
   }

   private static void printCurrentRoom()
   {
	   roomManager.rooms[player.posX][player.posY].describeRoom();
   }

   private static String[] collectInput() 
   {
	   System.out.println("Enter a command");
	   String input = scan.nextLine();
	   return input.split(" ", 2); // Separate the input into two commands, the action and the modifier. If there are more than two words they are ignored.
   }

   private static void parse(String[] command)
   {
	   switch (command[0])
	   {
	   case "go":
		   player.moveRooms(command[1]);
	   }
   }
}
