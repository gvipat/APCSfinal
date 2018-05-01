import java.awt.Color;

public class PlayerSprite extends Moveable
{
    public PlayerSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    public boolean move()
    {
        addGravity();
        return false;
    }
}