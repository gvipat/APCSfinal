import java.awt.Color;

public abstract class Moveable extends Sprite
{
    private int horizontalVelocity;

    private int verticalVelocity;

    public abstract void move();

    public Moveable(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }
}
