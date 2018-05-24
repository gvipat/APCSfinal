import java.awt.Color;


/**
 * A ground sprite is a simple sprite that does nothing.
 *
 * @author Charles Huang
 * @version May 22, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: Roshan Sevalia, Gaurav Vipat
 */
public class GroundSprite extends Sprite
{

    /**
     * Constructor
     * 
     * @param x
     *            the initial x position
     * @param y
     *            the initial y position
     * @param width
     *            the width of the sprite
     * @param height
     *            the height of the sprite
     * @param named
     *            the name of the sprite
     */
    public GroundSprite( int x, int y, int width, int height, String named )
    {
        super( x, y, width, height, Color.GREEN, named );
    }


    /**
     * Constructor
     * 
     * @param x
     *            the initial x position
     * @param y
     *            the initial y position
     * @param width
     *            the width of the sprite
     * @param height
     *            the height of the sprite
     */
    public GroundSprite( int x, int y, int width, int height )
    {
        super( x, y, width, height, Color.GREEN, "" );
    }


    /**
     * Constructor
     * 
     * @param x
     *            the initial x position
     * @param y
     *            the initial y position
     * @param width
     *            the width of the sprite
     * @param height
     *            the height of the sprite
     * @param color
     *            the color of the sprite
     * @param named
     *            the name of the sprite
     */
    public GroundSprite( int x, int y, int width, int height, Color color, String named )
    {
        super( x, y, width, height, color, named );
    }


    /**
     * Constructor
     * 
     * @param x
     *            the initial x position
     * @param y
     *            the initial y position
     * @param width
     *            the width of the sprite
     * @param height
     *            the height of the sprite
     * @param color
     *            the color of the sprite
     */
    public GroundSprite( int x, int y, int width, int height, Color color )
    {
        super( x, y, width, height, color, "" );
    }


    /**
     * Returns a copy of this sprite
     * 
     * @return a copy of this sprite
     * 
     * @see Sprite#copy()
     */
    public Sprite copy()
    {
        return new GroundSprite( getX(), getY(), getWidth(), getHeight(), getColor(), getName() );
    }

}