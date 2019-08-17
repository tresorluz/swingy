package views;

import java.util.Scanner;

import utils.Global;

public class DisplayMenu extends HeroDetails
{

	public static int optionMenu( String mode ) 
	{
		System.out.println("\t*********************\n" +
						   "\t* Welcome to Swingy *\n" +
				           "\t*********************\n" +
		"Your are in "+ mode.toUpperCase() + " mode\n"+
			"1. Please press 1 to continue in console mode\n" +
			"2. Please press 2 to switch to GUI mode" );

		int gameMode = 0;
		Scanner scanner = new Scanner( System.in );
		while ( scanner.hasNextLine() )
		{
			String	line = scanner.nextLine();

			if ( line.matches( "\\s*[1-2]\\s*" ) )
			{
				gameMode = Integer.parseInt( line );
				break;
			}
			else
				System.out.println( "Game mode selection incorrect. Try again." );
		}
		
		return gameMode;
	}

	public static int heroMenu() 
	{
		System.out.println( "\t*******************\n" +
							"\t*     Hero Menu   *\n" +
							"\t*******************\n" +
			"1. Please press 1 to create a new hero\n" +
			"2. Please Press 2 to select an existing hero\n" );

		int option = 0;
		Scanner scanner = new Scanner( System.in );
		while ( scanner.hasNextLine() )
		{
			String line = scanner.nextLine();

			if ( line.matches( "\\s*[1-2]\\s*" ) )
			{
				option = Integer.parseInt( line );
				break;	
			}
			else
				System.out.println( "Invalid option selected. Please Try again." );
		}
		
		return option;
	}

	public static String welcomeMessage()
	{
		System.out.println( "\t*******************************\n" +
							"\t*     Welcome To Swingy       *\n" +
							"\t*******************************\n\n" +
							"\tPlease Enter your name to continue\n" );

		String playerName = null;
		Scanner scanner = new Scanner( System.in );
		while ( scanner.hasNextLine() )
		{
			playerName = scanner.nextLine();
			playerName = playerName.trim();
			
			if ( playerName.length() > 0 )
			{
				//String[] check = playerName.split( "\\s" );
				//String check = playerName;
				if ( playerName != null )
					playerName = String.join( "_", playerName );
				break;
			}
			else
				System.out.println( "You must enter a name to continue..." );
		}
		
		return playerName;
	}
	
	

	public static int heroTypeMenu()
	{
		//Global.clearScreen();
		System.out.println( "\t***********************\n" +
							"\t*     Type Of Hero    *\n" +
							"\t***********************\n" +
			"1. Press 1 for a Warrior\n" +
			"2. Press 2 for a Protector\n" +
			"3. Press 3 for a Master\n" );

		int option = 0;
		Scanner scanner = new Scanner( System.in );
		while ( scanner.hasNextLine() )
		{
			String line = scanner.nextLine();

			if ( line.matches( "\\s*[1-3]\\s*" ) )
			{
				option = Integer.parseInt( line );
				break;	
			}
			else
				System.out.println("Invalid option selected. Please Try again.");
		}
		
		return option;
	}

	public static void showDirections()
	{
		System.out.println( "\t*****************************\n" +
							"\t*     Select Direction      *\n" +
							"\t*****************************\n" +
			"\t\t1. North\n" +
			"\t2. West" + "\t\t3. East\n" +
			"\t\t4. South\n");
	}

	public static void fightMenu()
	{
		//Global.clearScreen();
		System.out.println( "\t**************************\n" +
							"\t*     Fight Option       *\n" +
							"\t**************************\n" +
			"1. Press 1 to Fight the enemy\n" +
			"2. Press 2 to Run away from the enemy\n" );

	}
	
}