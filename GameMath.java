/**
 * Helper static methods that provide useful math functions for the game.
 *
 * @author Roshan Sevalia
 * @version May 21, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: Charles Huang, Gaurav Vipat
 */
public class GameMath
{
    /**
     * Rounds the float to the nearest hundredth.
     * 
     * @param number
     *            number to be rounded
     * @return the rounded number
     */
    public static float roundToHundredths( float number )
    {
        return (float)( Math.round( number * 100 ) / 100.0 );
    }


    /**
     * Rounds the float to the nearest tenth
     * 
     * @param number
     *            the number to be rounded
     * @return the rounded number
     */
    public static float roundToTenths( float number )
    {
        return (float)( Math.round( number * 10 ) / 10.0 );
    }


    /**
     * Returns 1 if the number is positive or 0, or -1 if it is negative.
     * 
     * @param number
     *            the number to get the sign of
     * @return 1 if the input was positive or 0, or -1 if it was negative
     */
    public static int getSign( float number )
    {
        if ( number < 0 )
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}