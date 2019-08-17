package controllers;

import java.util.Random;
import java.io.Console;

import utils.Global;
import models.heroes.*;
import models.enemies.*;
import views.DisplayMenu;
import models.filewriter.*;

public class GameController 
{
    private static GameMap printMap = null;
    private static Hero hero = new Hero();
    
    public GameController( Hero h )
    {
        hero = h;
    }

    public static void run( Hero hero )
    {
        System.out.println( "\t**************************\n" +
                            "\t*    Currently Playing   *\n" +
                            "\t**************************");

        printMap = new GameMap( hero );

        printMap.printMap();
        DisplayMenu.showDirections();

        Console console = System.console();
        while ( true )
        {
            String line = console.readLine();

            if ( line.matches( "\\s*[1-4]\\s*" ) )
            {
                int direction = Integer.parseInt( line );

                if ( direction == 1 )
                {
                    printMap.updateHeroLoc( 0, -1 );
                    System.out.println( "\t**************************\n" +
                                        "\t*    Currently Playing   *\n" +
                                        "\t**************************" );
                    printMap.printMap();
                    DisplayMenu.showDirections();
                }
                else if ( direction == 2 )
                {
                   printMap.updateHeroLoc( -1, 0 );
                    System.out.println( "\t**************************\n" +
                                        "\t*    Currently Playing   *\n" +
                                        "\t**************************" );
                    printMap.printMap();
                    DisplayMenu.showDirections();
                }
                else if ( direction == 3 )
                {
                    printMap.updateHeroLoc( 1, 0 );
                    System.out.println( "\t**************************\n" +
                                        "\t*    Currently Playing   *\n" +
                                        "\t**************************" );
                    printMap.printMap();
                    DisplayMenu.showDirections();
                }
                else if ( direction == 4 )
                {
                    printMap.updateHeroLoc( 0, 1 );
                    System.out.println( "\t**************************\n" +
                                        "\t*    Currently Playing   *\n" +
                                        "\t**************************" );
                    printMap.printMap();
                    DisplayMenu.showDirections();
                }
            }
            else
                System.out.println( "Input Incorrect. Please Try again." );
        }
    }

    public static boolean inLuck()
    {
        Random random = new Random();
        int luck = random.nextInt( 2 ) + 1;
        
        if ( luck == 1 )
            return true;
        return false;
    }
    
    public static int fight( Hero hero, Enemy enemy )
    {
        int fight = 0, won = 0, hit = 0;
        Random random = new Random(); 

        if ( inLuck() == true || hero.getHeroStats().getPower() > enemy.getPower() )
        {
            fight = 1;
        }            
        
        if ( hero.getHeroStats().getHitPoints() > 0 )
        {
            while ( hero.getHeroStats().getHitPoints() > 0 && enemy.getHitPoints() > 0 )
            {
                System.out.println( "Hero hp: " + hero.getHeroStats().getHitPoints() );
                System.out.println( "Enemy hp: " + enemy.getHitPoints() );
                if ( fight == 0 )
                {
                    hit = random.nextInt( 30 ) + 1; 
                    if ( enemy.getHitPoints() > 0 )
                    {
                        hero.getHeroStats().setHitPoints( -hit );
                        ReadFile.updateFile( hero );
                        System.out.println( "Enemy attack! You lost -" + hit + " hitpoints." );

                        if ( hero.getHeroStats().getHitPoints() <= 0 )
                        {
                            won = 0;
                            break;
                        }
                        fight = 1;
                    }
                }
                else if ( fight == 1 )
                {
                    hit = random.nextInt( 50 ) + 1; 
                    if ( hero.getHeroStats().getHitPoints() > 0 )
                    {
                        enemy.setHitPoints( -hit );
                        System.out.println( "You attacked! Enemy lost -" + hit + " hitpoints." );
                        if ( enemy.getHitPoints() <= 0 )
                        {
                            won = 1;
                            break;
                        }                   
                        fight = 0;
                    }
                }  
            }
        }
        else
            System.out.println( "You don't have any points to fight!" );
    return won;
    }
}
