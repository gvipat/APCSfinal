import java.awt.Color;
import java.util.LinkedList;


/**
 * A Moveable sprite that represents an enemy. Touching a player will kill the
 * player. Movement is a simple side to side movement across a platform
 *
 * @author Roshan Sevalia
 * @version May 22, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: none
 */
public class EnemySprite extends Moveable
{
    /**
     * Holds the original X position the sprite had when it was initialized.
     */
    protected int originalX;

    /**
     * Holds the original Y position the sprite had when it was initialized.
     */
    protected int originalY;

    /**
     * Represents the direction of movement.
     */
    protected int direction = -1;


    /**
     * Constructor
     * @param x the initial x position of the sprite
     * @param y the initial y position of the sprite
     * @param width the width of the sprite
     * @param height the height of the sprite
     * @param color the color of the sprite
     * @param named the name of the sprite
     */
    public EnemySprite( int x, int y, int width, int height, Color color, String named )
    {
        super( x, y, width, height, color, named );
        originalX = x;
        originalY = y;
        setHVelocity( (float)-0.5 );
        this.compareValue = 1;
    }


    /**
     * Constructor
     * @param x the initial x position of the sprite
     * @param y the initial y position of the sprite
     * @param width the width of the sprite
     * @param height the height of the sprite
     * @param color the color of the sprite
     */
    public EnemySprite( int x, int y, int width, int height, Color color )
    {
        super( x, y, width, height, color, "" );
        originalX = x;
        originalY = y;
        setHVelocity( (float)( 1 * direction ) );
        this.compareValue = 1;
    }


    /**
     * Moves the sprite
     * @see Moveable#move()
     */
    public boolean move()
    {
        // Only begin rendering once off screen
        if ( getX() <= Engine.camera + Engine.WINDOW_WIDTH )
        {
            LinkedList<CollisionType> collideTypes = checkCollision();
            // System.out.println("Enemy: " + collideTypes.toString() + "\n\n");
            if ( collideTypes.contains( CollisionType.VERTICAL_GROUND_OVER ) )
            {
                super.applyGravity = false;
                setVVelocity( 0 );
            }
            else if ( collideTypes.contains( CollisionType.NO_COLLISION ) )
            {
                super.applyGravity = true;
            }
            if ( collideTypes.contains( CollisionType.CONTACT ) )
            {
                super.applyGravity = false;
                setVVelocity( 0 );
            }
            if ( collideTypes.contains( CollisionType.HORIZONTAL_GROUND_FROM_LEFT )
                || collideTypes.contains( CollisionType.HORIZONTAL_GROUND_FROM_RIGHT ) )
            {
                direction *= -1;
                setX( getX() + 2 * direction );
            }
            setHVelocity( 1 * direction );
            super.addGravity();
            setX( getX() + getHVelocity() );
            setY( getY() + getVVelocity() );
        }
        // If off screen and away from spawn point, reset position
        else if ( getX() != originalX || getY() != originalY )
        {
            reset();
        }
        if ( getY() > Engine.WINDOW_HEIGHT )
        {
            isDead = true;
        }
        return false;
    }


    /**
     * Returns a copy of the sprite
     * @see Sprite#copy()
     */
    public Sprite copy()
    {
        return new EnemySprite( getX(), getY(), getWidth(), getHeight(), getColor(), getName() );
    }


    /**
     * Resets the position of the sprite.
     * @return true if the sprite is ready to be rendered again.
     */
    public boolean reset()
    {
        setX( originalX );
        setY( originalY );
        direction = -1;
        if ( getX() <= Engine.camera + Engine.WINDOW_WIDTH && originalX > Engine.camera
            && originalX < Engine.camera + Engine.WINDOW_WIDTH )
        {
            return false;
        }
        isDead = false;
        return true;
    }
}