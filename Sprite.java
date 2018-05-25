import java.awt.Color;
import java.awt.Image;
import java.awt.Point;


/**
 * The Sprite abstract class represents a simple displayable rectangle object
 * with supporting methods to get information about the object
 *
 * @author Roshan Sevalia
 * @version May 16, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: Charlie Huang, Gaurav Vipat
 */
public abstract class Sprite implements Comparable<Sprite>
{
    /**
     * The X position of the Sprite's top left corner
     */
    private int xPos;

    /**
     * The Y position of the Sprite's top left corner
     */
    private int yPos;

    /**
     * The Sprite's width
     */
    private int width;

    /**
     * The Sprite's height
     */
    private int height;

    /**
     * The Sprite's fill color
     */
    private Color color;

    /**
     * Name of the Sprite
     */
    private String name;

    /**
     * Defines the rendering priority
     */
    public int compareValue = 0;

    private Image image;

    public static final int TEXTURE_SIZE = 20;


    /**
     * Constructor
     * 
     * @param x
     *            the x position of the new sprite
     * @param y
     *            the y position of the new sprite
     * @param width
     *            the width of the new sprite
     * @param height
     *            the height of the new sprite
     * @param color
     *            the color of the new sprite
     * @param named
     *            the name of the sprite
     */
    public Sprite( int x, int y, int width, int height, Color color, String named, Image img )
    {
        xPos = x;
        yPos = y;
        this.width = width;
        this.height = height;
        this.color = color;
        name = named;
        image = img;
    }


    /**
     * Returns the x position
     * 
     * @return x position
     */
    public int getX()
    {
        return xPos;
    }


    /**
     * Returns the y position
     * 
     * @return y position
     */
    public int getY()
    {
        return yPos;
    }


    /**
     * Sets a x position
     * 
     * @param newX
     *            the new x position
     */
    public void setX( float newX )
    {
        xPos = (int)Math.round( newX );
    }


    /**
     * Sets a new y position
     * 
     * @param newY
     *            the new y position
     */
    public void setY( float newY )
    {
        yPos = (int)Math.round( newY );
    }


    /**
     * Returns the width of the sprite
     * 
     * @return the width of the sprite
     */
    public int getWidth()
    {
        return width;
    }


    /**
     * Returns the height of the sprite
     * 
     * @return the height of the sprite
     */
    public int getHeight()
    {
        return height;
    }


    /**
     * Returns the color of the sprite
     * 
     * @return the color of the sprite
     */
    public Color getColor()
    {
        return color;
    }


    public String getName()
    {
        return name;
    }


    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo( Sprite other )
    {
        return compareValue - other.compareValue;
    }


    /**
     * Returns the coordinates of the top left corner of the sprite
     * 
     * @return the coordinates of the top left corner of the sprite
     */
    public Point getTopLeftCorner()
    {
        return new Point( getX(), getY() );
    }


    /**
     * Returns the coordinates of the top right corner of the sprite
     * 
     * @return the coordinates of the top right corner of the sprite
     */
    public Point getTopRightCorner()
    {
        return new Point( getX() + getWidth() - 1, getY() );
    }


    /**
     * Returns the coordinates of the bottom left corner of the sprite
     * 
     * @return the coordinates of the bottom left corner of the sprite
     */
    public Point getBotLeftCorner()
    {
        return new Point( getX(), getY() + getHeight() - 1 );
    }


    /**
     * Returns the coordinates of the bottom right corner of the sprite
     * 
     * @return the coordinates of the bottom right corner of the sprite
     */
    public Point getBotRightCorner()
    {
        return new Point( getX() + getWidth() - 1, getY() + getHeight() - 1 );
    }


    /**
     * Returns a copy of the sprite with the same coordinates and color
     * 
     * @return a copy of the sprite
     */
    public abstract Sprite copy();

    public Image getImage()
    {
        return image;
    }

}
