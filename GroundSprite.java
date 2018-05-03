import java.awt.Color;

public class GroundSprite extends Sprite
{
    private static final Color groundColor = Color.GREEN;

    public GroundSprite(int x, int y, int width, int height)
    {
        super(x, y, width, height, GroundSprite.groundColor);
    }

    public GroundSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }
}