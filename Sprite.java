import java.awt.Color;
import java.awt.Point;

public abstract class Sprite implements Comparable<Sprite>
{
    private int xPos;
    
    private int yPos;
    
    private int width;
    
    private int height;
    
    private Color color;

    private boolean death; 
    
    private enum ContactType { PLAYER_GROUND, PLAYER_ENEMY, ENEMY_GROUND }; // not sure if we need ENEMY_GROUND because they only move in 2D
    
    private ContactType contact;
    
    public int compareValue = 0;
    
    public int getX() {return xPos;}
    
    public int getY() {return yPos;}

    public void setX(float newX) {xPos = (int)Math.round(newX);}
    
    public void setY(float newY) {yPos = (int)Math.round(newY);}
    
    public int getWidth() {return width;}
    
    public int getHeight() {return height;}
    
    public Color getColor() {return color;}
    
    public void setDeath(boolean die) {death = die;}
    
    public boolean getDeath() {return death;}
    
    public void setContact(String con) 
    {
        if (con.equals( "PLAYER_GROUND" ))
        {
            contact = ContactType.PLAYER_GROUND;
        }
        else if (con.equals( "PLAYER_ENEMY" ))
        {
            contact = ContactType.PLAYER_ENEMY;
        }
        else if (con.equals( "PLAYER_GROUND" ))
        {
            contact = ContactType.PLAYER_GROUND;
        }   
    }
    
    public ContactType getContact() {return contact;}
    
    public Sprite(int x, int y, int width, int height, Color color)
    {
        xPos = x;
        yPos = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int compareTo(Sprite other)
    {
        return compareValue - other.compareValue;
    }

    public Point getTopLeftCorner()
    {
        return new Point(getX() , getY());
    }

    public Point getTopRightCorner()
    {
        return new Point(getX() + getWidth() - 1, getY());
    }

    public Point getBotLeftCorner()
    {
        return new Point( getX() , getY() + getHeight() - 1 );
    }

    public Point getBotRightCorner()
    {
        return new Point( getX() + getWidth() - 1 , getY() + getHeight() - 1 );
    }

}
