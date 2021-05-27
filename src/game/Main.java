package game;

import java.util.Scanner;

public class Main {
	static final int[] startingCoordinates = {0, 1};
	static final String[][] commands = {
			{"go", "{direction}", "Go into the room in the specified direction, if such room exists."},
			{"inventory", "Show all items in the player's inventory."},
			{"help", "Show all commands and their effect."},
			{"take", "Takes the item in the current room, if one exists."},
			{"place", "item name", "Places"}};
	
	static Player player = new Player(startingCoordinates);
	static RoomManager roomManager = new RoomManager(player);
	static Scanner scan = new Scanner(System.in);
	
	private static boolean wasActionPerformed = true;
	
   public static void main(String[] args) 
   {
	   printWelcomeText();
	   roomManager.init();
	   
	   while(true)
	   {
		   if (wasActionPerformed)
		   {
			   printCurrentRoom();			   
		   }
		   
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
	   System.out.println("Enter an action");
	   String input = scan.nextLine().toLowerCase();
	   return input.split(" ", 2); // Separate the input into two commands, the action and the modifier. If there are more than two words they are ignored.
   }

   private static void parse(String[] command)
   {
	   switch (command[0])
	   {
	   case "go":
		   wasActionPerformed = player.moveRooms(command[1]);
		   break;
	   case "inventory":
		   player.printInventory();
		   wasActionPerformed = true;
		   break;
	   }
   }
}
