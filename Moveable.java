import java.awt.Color;

public abstract class Moveable extends Sprite
{
    private float horizontalVelocity;

    private float verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    private boolean applyGravity = true;

    private enum CollisionType {NO_COLLISION, HORIZONTAL_COLLISION, VERTICAL_COLLISION};

    public abstract boolean move();

    public Moveable(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
        this.compareValue++;
    }

    public float getHVelocity()
    {
        return horizontalVelocity;
    }

    public float getVVelocity()
    {
        return verticalVelocity;
    }
    public void setHVelocity(float newVelocity)
    {
        horizontalVelocity = newVelocity;
    }

    public void setVVelocity(float newVelocity)
    {
        verticalVelocity = newVelocity;
    }

    public void addGravity()
    {
        if (verticalVelocity < MAX_V_VELOCITY )
        {
            verticalVelocity += 0.05;
            if (DecimalRounder.roundToHundreths(verticalVelocity) == 0.0)
            {
                verticalVelocity += 0.05;
            }
            verticalVelocity = DecimalRounder.roundToHundreths(verticalVelocity);
        }
    }

    private CollisionType checkCollision()
    {
        for (Sprite s : Engine.sprites)
        {
            //collide here
        }
        return CollisionType.NO_COLLISION;
    }
}
