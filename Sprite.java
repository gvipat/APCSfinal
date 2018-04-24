import java.awt.Color;

public abstract class Sprite
{
    private int xPos;
    
    private int yPos;
    
    private int width;
    
    private int height;
    
    private Color color;
    
    public int getX() {return xPos;}
    
    public int getY() {return yPos;}
    
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
}
