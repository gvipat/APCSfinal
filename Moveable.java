import java.awt.Color;

public abstract class Moveable extends Sprite
{
    private double horizontalVelocity;

    private double verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    public abstract boolean move();

    public Moveable(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    public double getHVelocity()
    {
        return horizontalVelocity;
    }

    public double getVVelocity()
    {
        return verticalVelocity;
    }
    public void setHVelocity(double newVelocity)
    {
        horizontalVelocity = newVelocity;
    }

    public void setVVelocity(double newVelocity)
    {
        verticalVelocity = newVelocity;
    }

    public void addGravity()
    {
        if (verticalVelocity < MAX_V_VELOCITY )
        {
            verticalVelocity++;
            System.out.println(verticalVelocity);
        }
    }
}
