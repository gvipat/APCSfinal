import java.awt.*;
import java.util.LinkedList;

public class PacingEnemySprite extends EnemySprite {

   private int paceDistance;

   public PacingEnemySprite(int x, int y, int width, int height, Color color, int dist)
   {
       super(x, y, width, height, color, "");
       paceDistance = dist;
   }

   public PacingEnemySprite(int x, int y, int width, int height, Color color, String name, int dist)
   {
       super(x, y, width, height, color, name);
       paceDistance = dist;
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
            || collideTypes.contains(CollisionType.HORIZONTAL_GROUND_FROM_RIGHT)
            || Math.abs(originalX - getX()) >= paceDistance)
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

}
