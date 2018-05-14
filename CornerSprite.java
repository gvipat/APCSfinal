import java.awt.Color;

public class CornerSprite extends GroundSprite
{
    private boolean right = false;
    
    public CornerSprite(int x, int y, int width, int height, boolean rightSide)
    {
        super(x, y, width, height, Color.GREEN);
        right = rightSide;
    }

    public CornerSprite(int x, int y, int width, int height, Color color, boolean rightSide)
    {
        super(x, y, width, height, color);
        right = rightSide;
    }

    public boolean isRightSide()
    {
        return right;
    }
}