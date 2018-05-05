import java.awt.Color;
import java.awt.Point;

public abstract class Sprite implements Comparable<Sprite>
{
    private int xPos;
    
    private int yPos;
    
    private int width;
    
    private int height;
    
    private Color color;

    public int compareValue = 0;
    
    public int getX() {return xPos;}
    
    public int getY() {return yPos;}

    public void setX(float newX) {xPos = (int)Math.round(newX);}
    
    public void setY(float newY) {yPos = (int)Math.round(newY);}
    
    public int getWidth() {return width;}
    
    public int getHeight() {return height;}
    
    public Color getColor() {return color;}
    
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

    public Point getGetTopLeftCorner()
    {
        return new Point(getX() , getY());
    }

    public Point getGetTopRightCorner()
    {
        return new Point(getX() + getWidth() - 1, getY());
    }

    public Point getGetBotLeftCorner()
    {
        return new Point( getX() , getY() + getHeight() - 1 );
    }

    public Point getGetBotRightCorner()
    {
        return new Point( getX() + getWidth() - 1 , getY() + getHeight() - 1 );
    }
}
