package game;

import java.util.Scanner;

public class Main {
	static final int[] startingCoordinates = {1, 0};
	static final String[][] commands = {
			{"go", "{direction}", "Go into the room in the specified direction, if such room exists."},
			{"inventory", "Show all items in the player's inventory."},
			{"help", "Show all commands and their effect."},
			{"take", "Takes the item in the current room, if one exists."},
			{"place", "{item name}", "If the specified item is in player's inventory, places that item in the current room."}};
	
	static Player player = new Player(startingCoordinates);
	static RoomManager roomManager = new RoomManager(player);
	static Scanner scan = new Scanner(System.in);
	
	private static boolean wasActionPerformed = true;
	
   public static void main(String[] args) throws InterruptedException 
   {
	   printWelcomeText();
	   roomManager.init();
	   Thread.sleep(500);
	   
	   while(true)
	   {
		   if (wasActionPerformed) printCurrentRoom(); // if player moved last loop, print room description
		   
		   parse(collectInput()); // get command input from user
		   
	   }
   }
   
   private static void printWelcomeText()
   {
	   System.out.println("You wake up with a start. You are somewhere you don't recognize. \nWhere are you? You have a throbbing headache, as if someone hit you on the head with a bat. ");
   }

   private static void printCurrentRoom()
   {
	   roomManager.rooms[player.posX][player.posY].describe();
   }

   private static String[] collectInput() 
   {
	   System.out.println("Enter an action:");
	   String input = scan.nextLine().toLowerCase();
	   return input.split(" ", 2); // Separate the input into two commands, the action and the modifier. If there are more than two words they are ignored.
   }

   private static void parse(String[] command)
   {
	   switch (command[0])
	   {
	   default:
		   System.out.println("Invalid command entered. Please try again or type 'help' to see a list of commands.");
		   wasActionPerformed = false;
		   break;
	   case "go":
		   wasActionPerformed = player.moveRooms(command[1]);
		   break;
	   case "inventory":
		   player.printInventory();
		   wasActionPerformed = false;
		   break;
	   case "place":
		   player.placeItem(command[1]);
		   wasActionPerformed = false;
		   break;
	   case "take":
		   player.takeItem();
		   wasActionPerformed = false;
		   break;
	   case "help":
		   printHelpMenu();
		   wasActionPerformed = false;
	   }
   }
   
   private static void printHelpMenu()
   {
	   System.out.println("\n");
	   for (String[] command : commands)
	   {
		   for (String word : command)
		   {
			   System.out.print(word + "\t\t\t");
		   }
		   System.out.println("");
	   }
	   System.out.println("\n");
   }
}
