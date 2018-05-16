import java.awt.Color;
import java.util.LinkedList;
public class EnemySprite extends Moveable
{
    private int originalX;
    private int originalY;
    public EnemySprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
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
            super.addGravity();
            LinkedList<CollisionType> collideTypes = checkCollision();
            if (collideTypes.contains(CollisionType.VERTICAL_GROUND))
            {
                super.applyGravity = false;
                setVVelocity(0);
            }
            if (collideTypes.contains(CollisionType.NO_COLLISION))
            {
                super.applyGravity = true;
            }
            setX(getX() + getHVelocity());
            setY(getY() + getVVelocity());
        }
        //If off screen and away from spawn point, reset position
        else if (getX() != originalX || getY() != originalY)
        {
            setX(originalX);
            setY(originalY);
        }
        return false;
    }

    private void removeMe()
    {
        isDead = true;
    }

    public Sprite copy()
    {
        return new EnemySprite(getX(), getY(), getWidth(), getHeight(), getColor());
    }
}