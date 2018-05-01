import java.awt.Color;

public abstract class Moveable extends Sprite
{
    private int horizontalVelocity;

    private int verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    public abstract boolean move();

    public Moveable(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    private int getHVelocity()
    {
        return horizontalVelocity;
    }

    public int getVVelocity()
    {
        return verticalVelocity;
    }
    public void setHVelocity(int newVelocity)
    {
        horizontalVelocity = newVelocity;
    }

    public void setVVelocity(int newVelocity)
    {
        verticalVelocity = newVelocity;
    }

    public void addGravity()
    {
        if (verticalVelocity < MAX_V_VELOCITY)
        {
            verticalVelocity++;
        }
    }
}
