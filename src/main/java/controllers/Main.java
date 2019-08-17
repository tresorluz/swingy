package controllers;

import java.util.*;

import views.*;
import models.filewriter.*;

public class Main 
{
	public static void main ( String[] args )
	{
		String line = null;
		int gameMode = 0;

		try
		{
			LogFile.createFile();

			if(args[0].equals("console"))
			{
				gameMode = DisplayMenu.optionMenu( args[0]);
				
				if ( gameMode == 1 )
					ConsoleView.startGame();
					
				else if ( gameMode == 2 )
				{
					UserInterface guiView = new UserInterface();
					guiView.welcomeFrame();
				}
			}	
             
			else if(args[0].equals("gui"))
			{
				UserInterface guiView = new UserInterface();
				guiView.modeFrame();	
			}

			else
				System.out.println( "Invalid mode argument. Try again." );
                
		}
		catch ( Exception e )
		{
			System.out.println( "Game mode selection error: " + e );
		}
		finally
		{
			LogFile.closeFile();

		}
	}
}