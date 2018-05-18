import java.awt.Color;
import java.util.LinkedList;

import javax.lang.model.util.ElementScanner6;

public class PlayerSprite extends Moveable
{
    private boolean jumpKeyPressed = false;

    private boolean rightKeyPressed = false;

    private boolean leftKeyPressed = false;

    public PlayerSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
        this.compareValue++;
    }

    public boolean move()
    {
        LinkedList<CollisionType> collideTypes = super.checkCollision();
        System.out.println(collideTypes.toString());
        if (collideTypes.contains(CollisionType.VERTICAL_GROUND))
        {
            System.out.println("inside player's move et vvelociy 0");
            super.applyGravity = false;
            setVVelocity(0);
        }
        else if (collideTypes.contains(CollisionType.NO_COLLISION))
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
        if (collideTypes.contains(CollisionType.CONTACT))
        {
            if (jumpKeyPressed)
            {
                addJump();
            }
            else if (this.getVVelocity() > 0)
            {
                this.setVVelocity(0);
                applyGravity = false;
                jumpKeyPressed = false;
            }
            else if (this.getVVelocity() < 0)
            {
                setVVelocity(0);
                applyGravity = true;
                jumpKeyPressed = false;
            }
        }

        if(collideTypes.contains(CollisionType.STRAIGHT_HORIZONTAL_GROUND_FROM_LEFT))
        {
            setHVelocity(0);
            addLeft();
        }
        else if (collideTypes.contains(CollisionType.STRAIGHT_HORIZONTAL_GROUND_FROM_RIGHT))
        {
            setHVelocity(0);
            addRight();
        }
        else
        {
            addLeft();
            addRight();
        }
        super.addGravity();
        setX(getX() + getHVelocity());
        setY(getY() + getVVelocity());
        if (getY() > Engine.WINDOW_HEIGHT)
        {
            kms();
        }
        return false;
    }

    private void kms()
    {
        isDead = true;
    }

    private void addRight()
    {
        if ( rightKeyPressed && getHVelocity() < Moveable.MAX_H_VELOCITY)
        {
            setHVelocity(getHVelocity() + 1);
        }
    }

    private void addLeft()
    {
        if (leftKeyPressed && getHVelocity() > -Moveable.MAX_H_VELOCITY)
        {
            System.out.println("i work ***************************************************************");
            setHVelocity(getHVelocity() - 1);
        }
    }

    private void addJump()
    {
        System.out.println("adding jump");
        setVVelocity(-5);
        applyGravity = true;
    }

    public void rightKeyPressed()
    {
        rightKeyPressed = true;
    }

    public void leftKeyPressed()
    {
        leftKeyPressed = true;
    }

    public void upKeyPressed()
    {
        jumpKeyPressed = true;
    }

    public void rightKeyReleased()
    {
        rightKeyPressed = false;
        setHVelocity(0);
    }

    public void leftKeyReleased()
    {
        leftKeyPressed = false;
        setHVelocity(0);
    }

    public void upKeyReleased()
    {
        if (jumpKeyPressed == true && !(GameMath.roundToHundreths(getVVelocity()) == 0.0))
        {
            jumpKeyPressed = false;
        }
    }

    public Sprite copy()
    {
        return new PlayerSprite(getX(), getY(), getWidth(), getHeight(), getColor());
    }
}