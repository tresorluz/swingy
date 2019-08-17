package utils;

public class Global 
{
	public static boolean isNumber( String line )
    {
        for ( char c : line.toCharArray() )
        {
            if ( Character.isDigit( c ) != true)
                return ( false );
        }
        return ( true );
    }
}