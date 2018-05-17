import java.awt.Color;
import java.util.LinkedList;

public class PlayerSprite extends Moveable
{
    private boolean jumpKeyPressed = false;

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



        if (collideTypes.contains(CollisionType.CONTACT))
        {
            if(this.getHVelocity() ==0 && jumpKeyPressed)
            {
                addJump();
                System.out.println("forced jump");

            }
            else if (jumpKeyPressed)
            {
                addJump();
                System.out.println("addjump    1");
                //return false;
            }
            else if (this.getVVelocity() > 0)
            {
                this.setVVelocity(0);
                applyGravity = false;
//                return false;
                //System.out.println("contact grav change");

            }

//            if (jumpKeyPressed)
//            {
//
//                addJump();
//                applyGravity = true;
//                System.out.println("addjump 2");
//            }


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

    private void addJump()
    {
        System.out.println("adding jump");setVVelocity(-5);
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
        jumpKeyPressed = true;
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
        if (jumpKeyPressed == true && !(DecimalRounder.roundToHundreths(getVVelocity()) == 0.0))
        {
            jumpKeyPressed = false;
        }
    }

    public Sprite copy()
    {
        return new PlayerSprite(getX(), getY(), getWidth(), getHeight(), getColor());
    }
}