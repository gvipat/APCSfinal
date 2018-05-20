import java.awt.Color;

public class CornerSprite extends GroundSprite
{
    private boolean right = false;
    
    public CornerSprite(int x, int y, int width, int height, boolean rightSide, String named)
    {
        super(x, y, width, height, Color.GREEN, named);
        right = rightSide;
    }

    public CornerSprite(int x, int y, int width, int height, Color color, boolean rightSide, String named)
    {
        super(x, y, width, height, color, named);
        right = rightSide;
    }

    public boolean isRightSide()
    {
        return right;
    }
}