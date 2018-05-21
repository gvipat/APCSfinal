import java.awt.Color;
//name is only for default color sprite
public class GroundSprite extends Sprite
{
    
    
    
    public GroundSprite(int x, int y, int width, int height, String named)
    {
        super(x, y, width, height, Color.GREEN, named);
    }

    public GroundSprite(int x, int y, int width, int height)
    {
        super(x, y, width, height, Color.GREEN, "");
    }

    public GroundSprite(int x, int y, int width, int height, Color color, String named)
    {
        super(x, y, width, height, color, named);
    }

    public GroundSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color, "");
    }

    public Sprite copy()
    {
        return new GroundSprite(getX(), getY(), getWidth(), getHeight(), getColor(), getName());
    }
    
    
}