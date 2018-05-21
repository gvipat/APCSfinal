import java.awt.Color;
import java.util.LinkedList;
public class EnemySprite extends Moveable
{
    protected int originalX;
    protected int originalY;
    protected int direction = -1;
    public EnemySprite(int x, int y, int width, int height, Color color, String named)
    {
        super(x, y, width, height, color, named);
        originalX = x;
        originalY = y;
        setHVelocity((float)-0.5);
        this.compareValue = 1;
    }

    public EnemySprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color, "");
        originalX = x;
        originalY = y;
        setHVelocity((float)(1 * direction));
        this.compareValue = 1;
    }

    public boolean move()
    {
        //Only begin rendering once off screen
        if (getX() <= Engine.camera + Engine.WINDOW_WIDTH)
        {
            LinkedList<CollisionType> collideTypes = checkCollision();
            //System.out.println("Enemy: " + collideTypes.toString() + "\n\n");
            if (collideTypes.contains(CollisionType.VERTICAL_GROUND_OVER))
            {
                super.applyGravity = false;
                setVVelocity(0);
            }
            else if (collideTypes.contains(CollisionType.NO_COLLISION))
            {
                super.applyGravity = true;
            }
            if (collideTypes.contains(CollisionType.CONTACT))
            {
                super.applyGravity = false;
                setVVelocity(0);
            }
            if (collideTypes.contains(CollisionType.HORIZONTAL_GROUND_FROM_LEFT)
            || collideTypes.contains(CollisionType.HORIZONTAL_GROUND_FROM_RIGHT))
            {
                direction *= -1;
                setX(getX() + direction);
            }
            setHVelocity(1 * direction);
            super.addGravity();
            setX(getX() + getHVelocity());
            setY(getY() + getVVelocity());
        }
        //If off screen and away from spawn point, reset position
        else if (getX() != originalX || getY() != originalY)
        {
            reset();
        }
        if (getY() > Engine.WINDOW_HEIGHT)
        {
            isDead = true;
        }
        return false;
    }

    public Sprite copy()
    {
        return new EnemySprite(getX(), getY(), getWidth(), getHeight(), getColor(), getName());
    }

    public boolean reset()
    {
        setX(originalX);
        setY(originalY);
        direction = -1;
        if (getX() <= Engine.camera + Engine.WINDOW_WIDTH)
        {
            return false;
        }
        isDead = false;
        return true;
    }
}