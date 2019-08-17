package models.filewriter;

import java.io.*;

import models.heroes.Hero;

public class ReadFile 
{
	public static int countFileLine()
	{
		try
		{
			File file = new File( "swingy.txt" );
			FileReader fReader = new FileReader( file );
			LineNumberReader lReader = new LineNumberReader( fReader );
			lReader.skip( Long.MAX_VALUE );
			int count = lReader.getLineNumber();
			lReader.close();
			return ( count );
		}
		catch ( IOException ioe )
		{
			ioe.getMessage();
		}
		return ( -1 );
	}
	public static String[] ReadLine()
	{
		try
		{
			File file = new File( "swingy.txt" );
			FileReader fReader = new FileReader( file );
			BufferedReader bReader = new BufferedReader( fReader );
			String line = null;
			String items[] = new String[countFileLine()];
			int index = 0;

			while ( ( line = bReader.readLine() ) != null )
			{
				items[index] = line;
				index++;
			}
			bReader.close();
			return ( items );
		}
		catch ( IOException ioe )
		{
			ioe.getMessage();
		}
		return ( null );
	}

	public static void createdHeroes()
	{
		String items[] = new String[countFileLine()];
		int index = 0;
		int counter = 1;
		items = ReadLine();

		System.out.println( "** Please Select Your Favorite Hero **\n" );

		while ( index < countFileLine() )
		{
			System.out.println( counter++ + ". " + items[index++] );
		}
	}

	public static String getHero( long hero )
	{
		String items[] = new String[countFileLine()];
		items = ReadLine();
		return items[( int )hero - 1];
	}

	public static void updateFile( Hero hero )
	{
		try
		{	
			String[] items = ReadLine();
			String deleteLine = null;
			String newLine = null;
			File file = new File( "swingy.txt" );
			FileWriter fWriter = new FileWriter( file );

			for ( String line : items )
			{
				if ( line.contains( hero.getPlayer() ) && line.contains( hero.getHeroStats().getHeroType() ) )
					deleteLine = line;
			}

			newLine = 	( hero.getHeroStats().getHeroType() + " " + hero.getPlayer() + " " + 
						Integer.toString( hero.getHeroStats().getLevel() ) + " " + 
						Integer.toString( hero.getHeroStats().getAttack() ) + " " + 
						Integer.toString( hero.getHeroStats().getDefense() ) + " " + 
						Integer.toString( hero.getHeroStats().getHitPoints() ) + " " +
						Integer.toString( hero.getHeroStats().getXPoints() ) + " " + 
						hero.getArtifact().getType().toUpperCase() );

			if ( newLine != null )
			{
				for ( String line : items )
				{
					if ( line.equals( deleteLine ) )
						fWriter.write( newLine + "\n" );
					else
						fWriter.write( line + "\n" );
				}				
			}
			fWriter.close();
		}
		catch ( IOException ioe )
		{
			System.out.println( "Error updating hero stats in file: " + ioe );
		}
	}
}