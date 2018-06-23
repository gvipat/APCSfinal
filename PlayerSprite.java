import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;


/**
 * A controllable sprite that serves as the player in the game.
 *
 * @author Roshan Sevalia
 * @version May 22, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: none
 */
public class PlayerSprite extends Moveable
{
    /**
     * A flag that represents if the jump key was pressed
     */
    private boolean jumpKeyPressed = false;

    /**
     * A flag that represents if the right arrow key was pressed
     */
    private boolean rightKeyPressed = false;

    /**
     * A flag that represents if the left arrow key was pressed
     */
    private boolean leftKeyPressed = false;

    private final int JUMP_SPEED = -8;


    /**
     * Constructor
     * 
     * @param x
     *            the initial x position
     * @param y
     *            the initial y position
     * @param width
     *            the width of the sprite
     * @param height
     *            the height of the sprite
     * @param color
     *            the color of the sprite
     * @param named
     *            the name of the sprite
     */
    public PlayerSprite( int x, int y, int width, int height, String named, Image img )
    {
        super( x, y, width, height, Color.BLUE, named, img );
        this.compareValue = 2;
    }


    /**
     * Constructor
     * 
     * @param x
     *            the initial x position
     * @param y
     *            the initial y position
     * @param width
     *            the width of the sprite
     * @param height
     *            the height of the sprite
     * @param color
     *            the color of the sprite
     */
    public PlayerSprite( int x, int y, int width, int height, Image img )
    {
        super( x, y, width, height, Color.BLUE, "", img );
        this.compareValue = 2;
    }


    /**
     * Moves the sprite
     * 
     * @return true if the game has been completed
     * @see Moveable#move()
     */
    public boolean move()
    {
        LinkedList<CollisionType> collideTypes = super.checkCollision();
        //System.out.println("Player: " + collideTypes.toString());
        if ( collideTypes.contains( CollisionType.VERTICAL_GROUND_OVER ) )
        {
            // System.out.println("inside player's move et vvelociy 0");
            super.applyGravity = false;
            setVVelocity( 0 );
        }
        else if ( collideTypes.contains( CollisionType.NO_COLLISION ) )
        {
            super.applyGravity = true;
        }
        if ( collideTypes.contains( CollisionType.VERTICAL_GROUND_UNDER ) )
        {
            setVVelocity( 1 );
            super.applyGravity = true;
        }
        if ( collideTypes.contains( CollisionType.HORIZONTAL_ENEMY ) )
        {
            kms();
        }
        if ( collideTypes.contains( CollisionType.UNDER_ENEMY ) )
        {
            kms();
        }
        if ( collideTypes.contains( CollisionType.CONTACT ) )
        {
            if ( jumpKeyPressed )
            {
                addJump();
            }
            else if ( this.getVVelocity() > 0 )
            {
                this.setVVelocity( 0 );
                applyGravity = false;
                jumpKeyPressed = false;
            }
            else if ( this.getVVelocity() < 0 )
            {
                setVVelocity( 0 );
                applyGravity = true;
                jumpKeyPressed = false;
            }
        }

        if ( collideTypes.contains( CollisionType.HORIZONTAL_GROUND_FROM_LEFT ) )
        {
            setHVelocity( 0 );
            rightKeyPressed = false;
            addLeft();
        }
        else if ( collideTypes.contains( CollisionType.HORIZONTAL_GROUND_FROM_RIGHT ) )
        {
            setHVelocity( 0 );
            addRight();
        }
        else
        {
            addLeft();
            addRight();
        }
        super.addGravity();
        setX( getX() + getHVelocity() );
        setY( getY() + getVVelocity() );
        if ( getY() > Engine.WINDOW_HEIGHT )
        {
            kms();
        }


        // System.out.println("X: " + getX() + "HVelocity " + getHVelocity());
        if ( Level.getLevelEndZone() > 0 && getX() > Level.getLevelEndZone() )
        {
            return true;
        }
        return false;
    }

    /**
     * Kills this sprite
     */
    private void kms()
    {
        isDead = true;
    }


    /**
     * Adds positive horizontal velocity
     */
    private void addRight()
    {
        if ( rightKeyPressed && getHVelocity() < Moveable.MAX_H_VELOCITY )
        {
            setHVelocity( getHVelocity() + 1 );
        }
    }


    /**
     * Adds negative horizontal velocity
     */
    private void addLeft()
    {
        if ( leftKeyPressed && getHVelocity() > -Moveable.MAX_H_VELOCITY )
        {
            // System.out.println("i work
            // ***************************************************************");
            setHVelocity( getHVelocity() - 1 );
        }
    }


    /**
     * Adds vertical velocity and enables gravity
     */
    private void addJump()
    {
        // System.out.println("adding jump");
        setVVelocity( JUMP_SPEED );
        applyGravity = true;
    }


    /**
     * Changes the right key flag to true
     */
    public void rightKeyPressed()
    {
        rightKeyPressed = true;
    }


    /**
     * Changes the left key flag to true
     */
    public void leftKeyPressed()
    {
        leftKeyPressed = true;
    }


    /**
     * Changes the up key flag to true
     */
    public void upKeyPressed()
    {
        jumpKeyPressed = true;
    }


    /**
     * Stops the sprite from moving right
     */
    public void rightKeyReleased()
    {
        rightKeyPressed = false;
        setHVelocity( 0 );
    }


    /**
     * Stops the sprite from moving left
     */
    public void leftKeyReleased()
    {
        leftKeyPressed = false;
        setHVelocity( 0 );
    }


    /**
     * Tells the sprite not to jump
     */
    public void upKeyReleased()
    {
        if ( jumpKeyPressed == true && !( GameMath.roundToHundredths( getVVelocity() ) == 0.0 ) )
        {
            jumpKeyPressed = false;
        }
    }


    /**
     * Returns a copy of this sprite
     * 
     * @return a copy of this sprite
     * @see Sprite#copy()
     */
    public Sprite copy()
    {
        return new PlayerSprite( getX(), getY(), getWidth(), getHeight(), getName(), getImage() );
    }


    /**
     * Returns the right key pressed flag
     * 
     * @return the right key pressed flag
     */
    public boolean getRightKeyPressed()
    {
        return rightKeyPressed;
    }


    /**
     * Returns the left key pressed flag
     * 
     * @return the left key pressed flag
     */
    public boolean getLeftKeyPressed()
    {
        return leftKeyPressed;
    }


    /**
     * Returns the up key pressed flag
     * 
     * @return the up key pressed flag
     */
    public boolean getUpKeyPressed()
    {
        return jumpKeyPressed;
    }
}