import java.awt.Color;
import java.awt.Point;

public abstract class Moveable extends Sprite
{
    private float horizontalVelocity;

    private float verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    private boolean applyGravity = true;

    private enum CollisionType {NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND,
                                HORIZONTAL_ENEMY, UNDER_ENEMY, OVER_ENEMY};

    private enum CornerType {TR_BL, TR_BR, TL_BR, TL_BL, BL_TR, BR_TR, BR_TL, BL_TL, DONT};

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
            if (s != this)
            {
                switch (checkCorners(this, s))
                {
                    case TR_BL:

                        break;
                    case TR_BR:

                        break;
                    case TL_BR:

                        break;
                    case TL_BL:

                        break;
                    case BL_TR:

                        break;
                    case BR_TR:

                        break;
                    case BR_TL:

                        break;
                    case BL_TL:

                        break;
                    case DONT:
                        break;
                }
            }
        }
        return CollisionType.NO_COLLISION;
    }

    //enums: {TR_BL, TR_BR, TL_BR, TL_BL, BL_TR, BR_TR, BR_TL, BL_TL}
    private CornerType checkCorners(Sprite og, Sprite other)
    {
        Point[] corners = new Point[8];
        for (Point p : corners)
        {
            
        }
    }
}
