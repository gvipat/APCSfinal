import java.awt.Color;
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

    private String name;
    
    
    /**
     * 
     */
    private boolean death;


    /**
     *  
     */
    private enum ContactType {
        PLAYER_GROUND, PLAYER_ENEMY, ENEMY_GROUND
    }; // not sure if we need ENEMY_GROUND because they only move in 2D

    /**
     * 
     */
    private ContactType contact;

    /**
     * Defines the rendering priority
     */
    public int compareValue = 0;


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
     * TODO Write your method description here.
     * 
     * @param die
     */
    public void setDeath( boolean die )
    {
        death = die;
    }

    

    /**
     * TODO Write your method description here.
     * 
     * @return
     */
    public boolean getDeath()
    {
        return death;
    }


    /**
     * TODO Write your method description here.
     * 
     * @param con
     */
    public void setContact( String con )
    {
        if ( con.equals( "PLAYER_GROUND" ) )
        {
            contact = ContactType.PLAYER_GROUND;
        }
        else if ( con.equals( "PLAYER_ENEMY" ) )
        {
            contact = ContactType.PLAYER_ENEMY;
        }
        else if ( con.equals( "PLAYER_GROUND" ) )
        {
            contact = ContactType.PLAYER_GROUND;
        }
    }


    /**
     * TODO Write your method description here.
     * 
     * @return
     */
    public ContactType getContact()
    {
        return contact;
    }


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
     */
    public Sprite( int x, int y, int width, int height, Color color, String named )
    {
        xPos = x;
        yPos = y;
        this.width = width;
        this.height = height;
        this.color = color;
        name = named;
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

}
