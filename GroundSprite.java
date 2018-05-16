import java.awt.Color;

public class GroundSprite extends Sprite
{
    public GroundSprite(int x, int y, int width, int height)
    {
        super(x, y, width, height, Color.GREEN);
    }

    public GroundSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    public Sprite copy()
    {
        return new GroundSprite(getX(), getY(), getWidth(), getHeight(), getColor());
    }
}