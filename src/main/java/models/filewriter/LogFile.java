package models.filewriter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LogFile {
    public static File file = null;
    private static FileWriter fWriter;

    public LogFile() {}

    public static void createFile()
    {
        try
        {
            if ( file == null )
            {
                file = new File( "swingy.txt" );
                file.createNewFile();
            }
            fWriter = new FileWriter( file, true );
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        } 
    }

    public static void fileLogger( String message )
    {
        try
        {
            file = new File( "swingy.txt" );
            fWriter = new FileWriter( file, true );
            
            fWriter.append( message);
            fWriter.append( '\n' );
            fWriter.close();
        }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        } 
    }

    public static void closeFile()
    {
       try
        {
            if ( fWriter != null )
                fWriter.close();
            else
                return;
       }
        catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
    }
}


