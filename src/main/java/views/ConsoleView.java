package views;

import java.util.*;

import utils.*;
import models.heroes.*;
import models.filewriter.*;
import controllers.GameController;

public class ConsoleView 
{

	public static void startGame() 
	{
		String player;
		int type, createHero, option = 0, play;
		Hero hero = new Hero();
		
		try
		{
			createHero = DisplayMenu.heroMenu();
			if ( createHero == 1 )
			{
				player = DisplayMenu.welcomeMessage();
				type = DisplayMenu.heroTypeMenu();
				hero = GameView.createHero( player, type );
				play = HeroDetails.printDetails( type, player, hero );
				if ( play == 1 )
					GameController.run( hero );
				else
				{
					System.out.println( "\t**  Game Over ): **\n");
					System.exit( 0 );
				}
			}
			else if ( createHero == 2 )
			{
				ReadFile.createdHeroes();
				Scanner scanner = new Scanner( System.in );
				while ( scanner.hasNextLine() )
				{
					String line = scanner.nextLine();
					int linesCount = ReadFile.countFileLine();
					if ( Global.isNumber( line ) == true )
					{
						try
						{
							int index = Integer.parseInt( line );
							if ( index > 0 && index <= linesCount )
							{
								option = index;
								break;
							}
						}
						catch( Exception e )
						{
							System.out.println( "Input incorrect. Please Try again." );
						}
					}
					else
						System.out.println( "Input incorrect. Please Try again." );
				}
				hero = GameView.DBHero( ReadFile.getHero( option ) );
				GameController.run( hero );
			}
		}
		catch ( Exception e )
		{
			System.out.println( e.getMessage() );
		}
	}
}