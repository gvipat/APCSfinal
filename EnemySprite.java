import java.awt.Color;
import java.util.LinkedList;
public class EnemySprite extends Moveable
{
    private int originalX;
    private int originalY;
    public EnemySprite(int x, int y, int width, int height, Color color, String named)
    {
        super(x, y, width, height, color, named);
        originalX = x;
        originalY = y;
        setHVelocity((float)-0.5);
        this.compareValue = 1;
    }

    public boolean move()
    {
        //Only begin rendering once off screen
        if (getX() <= Engine.camera + Engine.WINDOW_WIDTH)
        {
            LinkedList<CollisionType> collideTypes = checkCollision();
            System.out.println("Enemy: " + collideTypes.toString() + "\n\n");
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
            setHVelocity(-1);
            super.addGravity();
            setX(getX() + getHVelocity());
            setY(getY() + getVVelocity());
        }
        //If off screen and away from spawn point, reset position
        else if (getX() != originalX || getY() != originalY)
        {
            setX(originalX);
            setY(originalY);
        }
        if (getY() > Engine.WINDOW_HEIGHT)
        {
            removeMe();
        }
        return false;
    }

    private void removeMe()
    {
        isDead = true;
    }

    public Sprite copy()
    {
        return new EnemySprite(getX(), getY(), getWidth(), getHeight(), getColor(), getName());
    }
}