import java.awt.Color;
import java.util.LinkedList;

public class PlayerSprite extends Moveable
{
    private boolean inJump = false;

    public PlayerSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
        this.compareValue++;
    }

    public boolean move()
    {
        checkJump();
        LinkedList<CollisionType> collideTypes = super.checkCollision();
        System.out.println(collideTypes.toString());
        if (collideTypes.contains(CollisionType.VERTICAL_GROUND))
        {
            super.applyGravity = false;
            setVVelocity(0);
        }
        if (collideTypes.contains(CollisionType.NO_COLLISION))
        {
            super.applyGravity = true;
        }
        if (collideTypes.contains(CollisionType.HORIZONTAL_GROUND))
        {
            setHVelocity(0);
        }
        if (collideTypes.contains(CollisionType.HORIZONTAL_ENEMY))
        {
            kms();
        }
        if (collideTypes.contains(CollisionType.UNDER_ENEMY))
        {
            kms();
        }
        if (collideTypes.contains(CollisionType.OVER_ENEMY))
        {
            //killed in collision
        }
        super.addGravity();
        setX(getX() + getHVelocity());
        setY(getY() + getVVelocity());
        return false;
    }

    private void kms()
    {
        Engine.restart();
    }

    private void checkJump()
    {
        if (inJump == true && DecimalRounder.roundToHundreths(getVVelocity()) == 0.0)
        {
            setVVelocity(-Moveable.MAX_V_VELOCITY);
            inJump = false;
        }
    }

    public void rightKeyPressed()
    {
        if (getHVelocity() < Moveable.MAX_H_VELOCITY)
        {
            setHVelocity(getHVelocity() + 1);
        }
    }

    public void leftKeyPressed()
    {
        if (getHVelocity() > -Moveable.MAX_H_VELOCITY)
        {
            setHVelocity(getHVelocity() - 1);
        }
    }

    public void upKeyPressed()
    {
        inJump = true;
    }

    public void rightKeyReleased()
    {
        setHVelocity(0);
    }

    public void leftKeyReleased()
    {
        setHVelocity(0);
    }

    public void upKeyReleased()
    {
        if (inJump == true && !(DecimalRounder.roundToHundreths(getVVelocity()) == 0.0))
        {
            inJump = false;
        }
    }
}