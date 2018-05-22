import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;


// Description of what print statements active
// **** signifies going into (non-corner based) v collision stuff
// followed by cornertype print statement
/**
 *  The Moveable abstract class is the base class for all sprites that can move on screen.
 *  It provides the ability to hold velocities, an abstract move method, and the ability to be killed.
 *
 *  @author  Charles Huang, Gaurav Vipat
 *  @version May 21, 2018
 *  @author  Period: 4
 *  @author  Assignment: APCSfinal
 *
 *  @author  Sources: Roshan Sevalia
 */
public abstract class Moveable extends Sprite
{
    /**
     * Holds the amount of pixels to be moved in the x direction every time the move method is called
     */
    private float horizontalVelocity;

    /**
     * Holds the amount of pixels to be moved in the y direction every time the move method is called
     */
    private float verticalVelocity;

    /**
     * Defines the max speed a sprite can move in the y direction
     */
    public static final int MAX_V_VELOCITY = 5;

    /**
     * Defines the max speed a sprite can move in the x direction
     */
    public static final int MAX_H_VELOCITY = 2;

    /**
     * Represents if gravity should be applied or not.
     */
    public boolean applyGravity = true;

    /**
     * Represents if this sprite is dead
     */
    public boolean isDead = false;


    /**
     *  Defines constants for the possible types of collisions that can occur
     */
    public enum CollisionType {
        NO_COLLISION,
        VERTICAL_GROUND_OVER,
        VERTICAL_GROUND_UNDER,
        HORIZONTAL_ENEMY,
        UNDER_ENEMY,
        OVER_ENEMY,
        CONTACT,
        HORIZONTAL_GROUND_FROM_LEFT,
        HORIZONTAL_GROUND_FROM_RIGHT,
    };


    /**
     *  Defines constants for the types of corners that need to be compared when checking collisions.
     *  TR means top right, TL means top left, BL means bottom left, BR means bottom right.
     *  The first corner is this sprite's corner, and the second corner is the other sprite being compared's corner.
     */
    private enum CornerType {
        TR_BL, TR_BR, TL_BR, TL_BL, BL_TR, BR_TR, BR_TL, BL_TL, PERF_CNTCT
    };


    /**
     * Abstract move method that returns true if the level has been completed.
     * @return true if the level is complete.
     */
    public abstract boolean move();


    /**
     * Constructor
     * @param x the initial x position
     * @param y the initial y position
     * @param width the width of the sprite
     * @param height the height of the sprite
     * @param color the color of the sprite
     * @param named the name of the sprite
     */
    public Moveable( int x, int y, int width, int height, Color color, String named )
    {
        super( x, y, width, height, color, named );
        this.compareValue++;
    }


    /**
     * Returns the horizontal velocity of this sprite
     * @return the horizontal velocity
     */
    public float getHVelocity()
    {
        return horizontalVelocity;
    }


    /**
     * Returns the vertical velocity of this sprite
     * @return the vertical velocity
     */
    public float getVVelocity()
    {
        return verticalVelocity;
    }


    /**
     * Sets the horizontal velocity
     * @param newVelocity the new horizontal velocity
     */
    public void setHVelocity( float newVelocity )
    {
        horizontalVelocity = newVelocity;
    }


    /**
     * Sets the vertical velocity;
     * @param newVelocity the new vertical velocity
     */
    public void setVVelocity( float newVelocity )
    {
        verticalVelocity = newVelocity;
    }


    /**
     * Increments the vertical velocity if gravity is enabled.
     */
    public void addGravity()
    {
        if ( applyGravity && verticalVelocity < MAX_V_VELOCITY )
        {
            verticalVelocity += 0.05;
            if ( GameMath.roundToHundredths( verticalVelocity ) == 0.0 )
            {
                verticalVelocity += 0.05;
            }
            verticalVelocity = GameMath.roundToHundredths( verticalVelocity );
        }
    }


    // NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY,
    // UNDER_ENEMY, OVER_ENEMY
    /**
     * Returns a linkedlist of all the collisions this sprite is experiencing
     * @return all the collisions this sprite is experiencing.
     */
    public LinkedList<CollisionType> checkCollision()
    {
        LinkedList<CollisionType> list = new LinkedList<CollisionType>();

        Iterator<Sprite> iter = Engine.sprites.iterator();
        while ( iter.hasNext() )
        {
            Sprite s = iter.next();
            if ( s != this )
            {
                // if (Math.abs(this.getX() - s.getX()) < 4 * MAX_H_VELOCITY + 1
                // || Math.abs(this.getY() - s.getY()) < 2 * MAX_V_VELOCITY + 1)
                // {

                // boolean bothMoveable = false;

                if ( s instanceof Moveable && this instanceof Moveable )
                {

                    if ( s instanceof EnemySprite && this instanceof EnemySprite )
                    {
                        // do nothing
                    }
                    // bothMoveable = true;

                    else if ( s instanceof EnemySprite && this instanceof PlayerSprite )
                    {
                        list.add(
                            checkCollision_BothMoveable( (PlayerSprite)this, (EnemySprite)s ) );
                    }

                    else
                    {
                        list.add(
                            checkCollision_BothMoveable( (PlayerSprite)s, (EnemySprite)this ) );
                    }

                }

                else
                {
                    list.add( checkCollision_OneMoveable( this, (GroundSprite)s ) );
                }
            }

        }

        // }
        return list;

    }


    // NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY,
    // UNDER_ENEMY, OVER_ENEMY
    /**
     * Helper method that gets the collision type between a player an enemy
     * @param player the player being compared for collision
     * @param enemy the enemy being compared for collision
     * @return the type of collision occurring between the two sprites
     */
    private CollisionType checkCollision_BothMoveable( PlayerSprite player, EnemySprite enemy ) ///////// ACTUALLY
                                                                                                ///////// I
                                                                                                ///////// DON'T
                                                                                                ///////// NEED
                                                                                                ///////// TO
                                                                                                ///////// GET
                                                                                                ///////// RID
                                                                                                ///////// OF
                                                                                                ///////// TEMP
                                                                                                ///////// BECAUSE
                                                                                                ///////// TEMP
                                                                                                ///////// IS
                                                                                                ///////// NEVER
                                                                                                ///////// ADDED
                                                                                                ///////// TO
                                                                                                ///////// PRIORITY
                                                                                                ///////// QUEUE
                                                                                                ///////// AND
                                                                                                ///////// RENDERED
    {
        Object[] temp = checkCorners( player, enemy );
        Sprite tempSprite = new GroundSprite( Math.round( enemy.getX() + enemy.getHVelocity() ),
            Math.round( enemy.getY() + enemy.getVVelocity() ),
            enemy.getWidth(),
            enemy.getHeight(),
            "tempSprite" );
        CollisionType playerTempCollision = checkCollision_OneMoveable( player, tempSprite );
        if ( playerTempCollision == CollisionType.HORIZONTAL_GROUND_FROM_LEFT
            || playerTempCollision == CollisionType.HORIZONTAL_GROUND_FROM_RIGHT )
        {
            return CollisionType.HORIZONTAL_ENEMY;
        }
        else if ( playerTempCollision == CollisionType.VERTICAL_GROUND_OVER )
        {
            if ( player.getVVelocity() < 0
                || ( GameMath.roundToHundredths( player.getVVelocity() ) == 0
                    && enemy.getVVelocity() > 0 ) )
            {
                return CollisionType.UNDER_ENEMY;
            }
            if ( player.getVVelocity() > 0 )
            {
                enemy.isDead = true;
                return CollisionType.OVER_ENEMY;
            }
        }

        return CollisionType.NO_COLLISION;
    }


    // NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY,
    /**
     * Helper method that gets the collision type between a moveable and a ground object.
     * @param mover the moveable sprite being compared
     * @param ground the ground sprite being compared
     * @return the type of collision occurring between the two sprites
     */
    private CollisionType checkCollision_OneMoveable( Moveable mover, Sprite ground )
    {
        Object[] temp = checkCorners( mover, ground );

        // System.commented.out.println("//////////////////////////////////////////////////");
        // System.out.print("v = " + mover.getVVelocity() + "dc = " +
        // GameMath.roundToHundreths(mover.getVVelocity()));
        // System.out.print("h = " + mover.getHVelocity() + "dist = " +
        // (Float)temp[1]);

        if ( ground.getName().equals( "hanging 1" ) )
        {
            // System.out.println( "groundName : " + ground.getName() + "; V
            // velocity = "
            // + mover.getVVelocity() + " y distance = " + temp[2] + "Y__" +
            // mover.getY() + " groundY+height" + (ground.getY() +
            // ground.getHeight()));
        }

        if ( /* GameMath.roundToHundreths( mover.getHVelocity() ) == 0 && */
        ( mover.getY() >= ground.getY() && -mover.getVVelocity() >= (Float)temp[2] )
            || ( mover.getY() >= ( ground.getY() + ground.getHeight() )
                && -mover.getVVelocity() >= (Float)temp[2] ) )
        {

            if ( !( ( mover.getX() - ground.getX() ) < ground.getWidth()
                && ( mover.getX() - ground.getX() ) > -mover.getWidth() ) )
            {
                return CollisionType.NO_COLLISION;
            }
            if ( mover.getY() >= ( ground.getY() + ground.getHeight() - 1 ) )
            {
                // System.out.println( "\t\t\t\t\t\tinside STRAIGHT VERTICAL
                // GROUND UNDER!" );
                mover.setVVelocity( (Float)temp[2] * GameMath.getSign( mover.getVVelocity() ) );
                mover.setY( mover.getY() + mover.getVVelocity() );
                // System.commented.out.println( "STRAIGHT VERTICAL" + "unabs y
                // distance " + temp[3] );
                return CollisionType.VERTICAL_GROUND_UNDER;
            }
        }

        // System.out.println( "a = " + temp[1] + "** b =" + temp[2] +
        // "*************" );
        if ( /* GameMath.roundToHundreths( mover.getHVelocity() ) == 0 && */
        ( mover.getY() < ground.getY() && mover.getVVelocity() > (Float)temp[2] )
            || ( mover.getY() >= ( ground.getY() + ground.getHeight() )
                && -mover.getVVelocity() > (Float)temp[2] ) )
        {

            // System.out.println(" ********************************** + " +
            // ground.getName());
            if ( !( ( mover.getX() - ground.getX() ) < ground.getWidth()
                && ( mover.getX() - ground.getX() ) > -mover.getWidth() ) )
            {
                return CollisionType.NO_COLLISION;
            } // Roshan explains
            if ( mover.getY() < ground.getY() )
            {
                applyGravity = false;
                mover.setVVelocity( (Float)temp[2] * GameMath.getSign( mover.getVVelocity() ) );
                mover.setY( mover.getY() + mover.getVVelocity() );
                // System.commented.out.println( "STRAIGHT VERTICAL" + "unabs y
                // distance " + temp[3] );
                return CollisionType.VERTICAL_GROUND_OVER;
            }
            if ( mover.getY() >= ( ground.getY() + ground.getHeight() ) )
            {
                // System.out.println( "\t\t\t\t\t\tinside STRAIGHT VERTICAL
                // GROUND UNDER!" );
                mover.setVVelocity( (Float)temp[2] * GameMath.getSign( mover.getVVelocity() ) );
                mover.setY( mover.getY() + mover.getVVelocity() );
                // System.commented.out.println( "STRAIGHT VERTICAL" + "unabs y
                // distance " + temp[3] );
                return CollisionType.VERTICAL_GROUND_UNDER;
            }

        }

        if ( Math.abs( mover.getHVelocity() ) >= (Float)temp[1]
            && ( mover.getBotLeftCorner().y <= ground.getBotLeftCorner().y + mover.getHeight()
                && mover.getY() >= ground.getY() - mover.getHeight()
                && mover.getY() - ground.getY() < ground.getHeight()
                && mover.getY() - ground.getY() > -mover.getY() ) )
        {
            // System.commented.out.println("\t\t\t straight horizontal");
            // mover.setHVelocity(0);
            mover.setHVelocity( (Float)temp[1] * GameMath.getSign( mover.getHVelocity() ) );
            // System.out.println(mover.getHVelocity() +
            // "***************************");
            mover.setX( mover.getX() + mover.getHVelocity() );
            if ( mover.getX() < ground.getX() )
            {
                return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
            }
            else if ( mover.getX() > ground.getX() )
            {
                return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
            }
        }

        int hSign;
        int vSign;

        // System.out.println( "spriteName = " + ground.getName() + " corner
        // type" + (CornerType)temp[0] );
        switch ( (CornerType)temp[0] )
        {
            case PERF_CNTCT:
                // System.commented.out.println( "\t\t\t\tb" );
                return CollisionType.CONTACT;

            case BL_TL:
                // System.out.println("TLBL************");
                hSign = GameMath.getSign( mover.getHVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getHVelocity()
                                                                 // ) /
                                                                 // mover.getHVelocity()
                                                                 // );
                vSign = GameMath.getSign( mover.getVVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getVVelocity()
                                                                 // ) /
                                                                 // mover.getVVelocity()
                                                                 // );

                // if ( vSign > 0 && mover.getHVelocity() - mover.getWidth() >
                // (Float)temp[1] )
                // { /////// maybe minus 1
                // mover.setHVelocity( (Float)temp[1] + mover.getWidth() );
                // float slope = Math.abs( mover.getVVelocity() /
                // mover.getHVelocity() );
                // mover.setVVelocity( hSign * (Float)( slope *
                // mover.getHVelocity() ) );
                // if (mover.getX() < ground.getX())
                // {
                // return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }TR
                if ( mover.getHVelocity() != 0 && mover.getVVelocity() > (Float)temp[2] )// weird
                {

                    applyGravity = false;
                    mover.setVVelocity( vSign * (Float)temp[2] );
                    mover.setY( mover.getY() + mover.getVVelocity() );// TODO
                                                                      // check
                                                                      // for
                                                                      // others
                    double slope_inverted = Math.abs( mover.getHVelocity() / mover.getVVelocity() );
                    // mover.setHVelocity((float)(slope_inverted*getHVelocity()));
                    mover.setHVelocity( 0 );

                    return CollisionType.VERTICAL_GROUND_OVER;
                }
                break;
            case BR_TR:
                // System.out.println("TLBL************");
                hSign = GameMath.getSign( mover.getHVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getHVelocity()
                                                                 // ) /
                                                                 // mover.getHVelocity()
                                                                 // );
                vSign = GameMath.getSign( mover.getVVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getVVelocity()
                                                                 // ) /
                                                                 // mover.getVVelocity()
                                                                 // );

                // if ( vSign > 0 && mover.getHVelocity() - mover.getWidth() >
                // (Float)temp[1] )
                // { /////// maybe minus 1
                // mover.setHVelocity( (Float)temp[1] + mover.getWidth() );
                // float slope = Math.abs( mover.getVVelocity() /
                // mover.getHVelocity() );
                // mover.setVVelocity( hSign * (Float)( slope *
                // mover.getHVelocity() ) );
                // if (mover.getX() < ground.getX())
                // {
                // // return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }
                if ( mover.getHVelocity() != 0 && mover.getVVelocity() > (Float)temp[2] )// weird
                // hsign
                {

                    applyGravity = false;
                    mover.setVVelocity( vSign * (Float)temp[2] );
                    double slope_inverted = Math.abs( mover.getHVelocity() / mover.getVVelocity() );
                    // mover.setHVelocity((float)(slope_inverted*getHVelocity()));
                    mover.setHVelocity( 0 );

                    return CollisionType.VERTICAL_GROUND_OVER;
                }
                break;
            // case TL_BL:
            // //System.commented.out.println("TLBL************");
            // hSign = (int) (Math.abs(mover.getHVelocity()) /
            // mover.getHVelocity());
            // vSign = (int) (Math.abs(mover.getVVelocity()) /
            // mover.getVVelocity());
            //
            // if(vSign > 0 && mover.getHVelocity() - mover.getWidth() >
            // (Float)temp[1]){ ///////maybe minus 1
            // mover.setHVelocity((Float)temp[1] + mover.getWidth());
            // float slope = Math.abs(mover.getVVelocity() /
            // mover.getHVelocity());
            // mover.setVVelocity(hSign*(Float)(slope*mover.getHVelocity()));
            // return CollisionType.HORIZONTAL_GROUND;
            // }
            // if(hSign != 0 && mover.getVVelocity() > (Float)temp[2])// weird
            // now because can't have an if statement on hsign
            // {
            // //applyGravity = false; ///POSSIBLE ERROR HERE!
            // mover.setVVelocity(vSign*(Float)temp[2]);
            // double slope_inverted = Math.abs(mover.getHVelocity() /
            // mover.getVVelocity());
            // //mover.setHVelocity((float)(slope_inverted*getHVelocity()));
            // return CollisionType.VERTICAL_GROUND;
            // }
            // break;

            case TR_BL: // doned
                // System.commented.out.println( "\t\t\t\tc" );
                hSign = GameMath.getSign( mover.getHVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getHVelocity()
                                                                 // ) /
                                                                 // mover.getHVelocity()
                                                                 // );
                vSign = GameMath.getSign( mover.getVVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getVVelocity()
                                                                 // ) /
                                                                 // mover.getVVelocity()
                                                                 // );

                if ( !( ( mover.getX() - ground.getX() ) < ground.getWidth()
                    && ( mover.getX() - ground.getX() ) > -mover.getWidth() ) )
                {
                    return CollisionType.NO_COLLISION;
                }
                // if ( vSign < 0 && mover.getHVelocity() >= (Float)temp[1] )
                // { /////// maybe minus 1
                // //float slope = Math.abs( mover.getVVelocity() /
                // mover.getHVelocity() );
                // mover.setHVelocity( hSign * (Float)temp[1]);
                // mover.setVVelocity( 0 );
                // mover.setX(mover.getX() + mover.getHVelocity());
                // if (mover.getX() < ground.getX())
                // {
                // // return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }
                if ( hSign > 0 && mover.getVVelocity() > (Float)temp[2] )
                {
                    mover.setVVelocity( vSign * (Float)temp[2] );
                    double slopeInverted = Math.abs( mover.getHVelocity() / mover.getVVelocity() );
                    mover.setHVelocity( (float)( slopeInverted * getHVelocity() ) );
                    return CollisionType.VERTICAL_GROUND_OVER;
                }
                break;

            case TL_BR:

                // System.commented.out.println( "\t\t\t\td" );
                hSign = GameMath.getSign( mover.getHVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getHVelocity()
                                                                 // ) /
                                                                 // mover.getHVelocity()
                                                                 // );
                vSign = GameMath.getSign( mover.getVVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getVVelocity()
                                                                 // ) /
                                                                 // mover.getVVelocity()
                                                                 // );

                // if ( vSign < 0
                // && Math.abs( mover.getHVelocity() ) >= (Float)temp[1] )
                // { /////// maybe minus 1
                // mover.setHVelocity( hSign * ( (Float)temp[1] ) );
                // //double slope = Math.abs(
                // GameMath.roundToHundreths(mover.getVVelocity()) /
                // GameMath.roundToHundreths(mover.getHVelocity() ));
                // //mover.setVVelocity( vSign * (float)( slope *
                // mover.getHVelocity() ) );
                // mover.setVVelocity(0);
                // if (mover.getX() < ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }
                if ( hSign < 0 && Math.abs( mover.getVVelocity() ) > (Float)temp[2] )
                {
                    if ( ( mover.getX() - ground.getX() ) < ground.getWidth()
                        && ( mover.getX() - ground.getX() ) > -mover.getWidth() )
                    {
                        mover.setVVelocity( vSign * (Float)temp[2] );
                        double slopeInverted = Math
                            .abs( GameMath.roundToHundredths( mover.getHVelocity() )
                                / GameMath.roundToHundredths( mover.getVVelocity() ) );
                        mover.setHVelocity( hSign * (float)( slopeInverted * getHVelocity() ) );
                        return CollisionType.VERTICAL_GROUND_OVER;
                    }
                }
                break;

            case BL_TR://///////////////////////////////////////////////////////////////////////////////////////////////// PROBLEM
                       /////////////////////////////////////////////////////////////////////////////////////////////////// HERE!!!!!!!!!!!!!!!!!!!!!!!!

                // System.commented.out.println( "\t\t\t\te" );
                hSign = GameMath.getSign( GameMath.roundToTenths( mover.getHVelocity() ) );// (int)(
                                                                                           // Math.abs(
                                                                                           // mover.getHVelocity()
                                                                                           // )
                                                                                           // /
                                                                                           // mover.getHVelocity()
                                                                                           // );
                vSign = GameMath.getSign( GameMath.roundToTenths( mover.getVVelocity() ) );// (int)(
                                                                                           // Math.abs(
                                                                                           // mover.getVVelocity()
                                                                                           // )
                                                                                           // /
                                                                                           // mover.getVVelocity()
                                                                                           // );

                // if ( vSign > 0
                // && Math.abs( mover.getHVelocity() ) >= (Float)temp[1] )
                // { /////// maybe minus 1
                // mover.setHVelocity( hSign * ( (Float)temp[1] +
                // mover.getWidth() ) );
                // //double slope = Math.abs(
                // GameMath.roundToHundreths(mover.getVVelocity()) /
                // GameMath.roundToHundreths(mover.getHVelocity() ) );
                // //mover.setVVelocity(
                // // vSign * (float)( slope * Math.abs( mover.getHVelocity() )
                // ) );
                // mover.setVVelocity(0);
                // //System.commented.out.println( "BL_TR horiz ground
                // ***********" );
                // if (mover.getX() < ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }
                if ( hSign < 0 && Math.abs( mover.getVVelocity() ) > (Float)temp[2] )
                {
                    if ( ( mover.getX() - ground.getX() ) < ground.getWidth()
                        && ( mover.getX() - ground.getX() ) > -mover.getWidth() )
                    {
                        mover.setVVelocity( vSign * (Float)temp[2] );
                        double slopeInverted = GameMath.roundToHundredths( mover.getHVelocity() )
                            / GameMath.roundToHundredths( mover.getVVelocity() );
                        mover.setHVelocity(
                            hSign * (float)( slopeInverted * Math.abs( getHVelocity() ) ) );
                        // System.commented.out.println(mover.getVVelocity() + "
                        // " + GameMath.roundToHundreths(mover.getVVelocity()
                        // ));
                        // System.commented.out.println( "BL_TR vertical ground
                        // **********" );
                        return CollisionType.VERTICAL_GROUND_OVER;
                    }
                }

                break;

            case BR_TL:

                // System.commented.out.println( "\t\t\t\tf" );
                hSign = GameMath.getSign( mover.getHVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getHVelocity()
                                                                 // ) /
                                                                 // mover.getHVelocity()
                                                                 // );
                vSign = GameMath.getSign( mover.getVVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getVVelocity()
                                                                 // ) /
                                                                 // mover.getVVelocity()
                                                                 // );

                // System.out.println("hVelocity : " + mover.getHVelocity() + "
                // x distance: "+ temp[1]);
                // if ( vSign > 0
                // && Math.abs( mover.getHVelocity() ) >= (Float)temp[1] )
                // { /////// maybe minus 1
                // double slope = Math.abs( mover.getVVelocity() /
                // mover.getHVelocity() );
                // mover.setHVelocity( hSign * ( (Float)temp[1] ) );
                // //mover.setVVelocity(
                // // vSign * (float)( slope * Math.abs( mover.getHVelocity() )
                // ) );
                // mover.setVVelocity(0);
                // mover.setX(mover.getX() + mover.getHVelocity());
                // if (mover.getX() < ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // // //return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }
                if ( mover.getX() > ground.getX() - MAX_H_VELOCITY
                    && mover.getX() < ground.getX() + MAX_H_VELOCITY )
                {
                    if ( hSign > 0 && Math.abs( mover.getVVelocity() ) > (Float)temp[2] )
                    {
                        mover.setVVelocity( vSign * (Float)temp[2] );
                        double slope_inverted = Math
                            .abs( mover.getHVelocity() / mover.getVVelocity() );
                        mover.setHVelocity(
                            hSign * (float)( slope_inverted * Math.abs( getHVelocity() ) ) );
                        return CollisionType.VERTICAL_GROUND_OVER;
                    }
                }

                break;

            case TL_BL:
                // System.commented.out.println( "\t\t\t\tq" );
                hSign = GameMath.getSign( mover.getHVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getHVelocity()
                                                                 // ) /
                                                                 // mover.getHVelocity()
                                                                 // );
                vSign = GameMath.getSign( mover.getVVelocity() );// (int)(
                                                                 // Math.abs(
                                                                 // mover.getVVelocity()
                                                                 // ) /
                                                                 // mover.getVVelocity()
                                                                 // );

                // if ( vSign > 0
                // && Math.abs( mover.getHVelocity() ) >= (Float)temp[1] )
                // { /////// maybe minus 1
                // mover.setHVelocity( hSign * ( (Float)temp[1] +
                // mover.getWidth() ) );
                // //double slope = Math.abs( mover.getVVelocity() /
                // mover.getHVelocity() );
                // mover.setVVelocity(0);//mover.setVVelocity(
                // // vSign * (float)( slope * Math.abs( mover.getHVelocity() )
                // ) );

                // if (mover.getX() < ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_LEFT;
                // }
                // else if (mover.getX() > ground.getX())
                // {
                // //return CollisionType.HORIZONTAL_GROUND_FROM_RIGHT;
                // }
                // }
                if ( mover.getX() > ground.getX() - MAX_H_VELOCITY
                    && mover.getX() < ground.getX() + MAX_H_VELOCITY )
                {
                    if ( hSign > 0 && Math.abs( mover.getVVelocity() ) > (Float)temp[2] )
                    {
                        mover.setVVelocity( vSign * (Float)temp[2] );
                        double slope_inverted = Math
                            .abs( mover.getHVelocity() / mover.getVVelocity() );
                        mover.setHVelocity(
                            hSign * (float)( slope_inverted * Math.abs( getHVelocity() ) ) );
                        return CollisionType.VERTICAL_GROUND_OVER;
                    }
                }
                break;

        }

        // System.commented.out.println( "\t\t\t\tg" );
        return CollisionType.NO_COLLISION;

    }


    /**
     * Returns an array of length 4 containing data about the two points.
     * Index 0 is the distance between Point a and Point b.
     * Index 1 is the x distance between the two points (absolute value).
     * Index 2 is the y distance between the two points (absolute value).
     * Index 3 is the non-absolute valued y distance between the two points
     * @param a One point to get the data on.
     * @param b The other point to get the data on.
     * @return an array of the data.
     */
    private double[] getDiag( Point a, Point b )
    {
        double[] temp = new double[4];
        double x = ( a.getX() - b.getX() ) * ( a.getX() - b.getX() );
        double y = ( a.getY() - b.getY() ) * ( a.getY() - b.getY() );
        temp[0] = Math.sqrt( x + y );
        temp[1] = Math.sqrt( x );
        temp[2] = Math.sqrt( y );
        temp[3] = a.getY() - b.getY(); // NON ABS VALUE!!!
        return temp;
    }


    // enums: {TR_BL/, TR_BR/, TL_BR/, TL_BL/, BL_TR/, BR_TR/, BR_TL/, BL_TL/}
    // Object array contains 3 vals, type of collision, minimum x, and minimum y
    /**
     * Helper method that gets the corners to be compared between the two
     * sprites for collision checking and supplemental data. In the returned
     * array, index 0 is the corner type to be used. Index 1 is the x-distance
     * between the corners. Index 2 is the y distance between the corners. Index
     * 3 is the non-absolute valued y distance between the two points
     * 
     * @param og
     *            The first sprite in the collision type returned.
     * @param other
     *            The second sprite in the collision type returned.
     * @return An array of the values
     */
    private Object[] checkCorners( Sprite og, Sprite other )
    {
        CornerType cornerTemp = CornerType.TR_BL;
        double[] mindistance = getDiag( og.getTopRightCorner(), other.getBotLeftCorner() );

        double[] temp = getDiag( og.getTopRightCorner(), other.getBotRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TR_BR;
        }

        temp = getDiag( og.getTopLeftCorner(), other.getBotRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TL_BR;
        }

        temp = getDiag( og.getTopLeftCorner(), other.getBotLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TL_BL;
        }

        temp = getDiag( og.getBotLeftCorner(), other.getTopRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BL_TR;
        }

        temp = getDiag( og.getBotRightCorner(), other.getTopRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BR_TR;
        }

        temp = getDiag( og.getBotRightCorner(), other.getTopLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BR_TL;
        }

        temp = getDiag( og.getBotLeftCorner(), other.getTopLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BL_TL;
        }

        temp = getDiag( og.getTopLeftCorner(), other.getBotLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TL_BL;
        }
        double a = mindistance[1];
        double b = mindistance[2];
        CornerType c = cornerTemp;

        // if(DecimalRounder.roundToTenths((float)a) == 1 ||
        // DecimalRounder.roundToTenths((float)b)==1){
        // //System.commented.out.println( "perfect contacting" );

        // c = CornerType.PERF_CNTCT;

        // //System.commented.out.println( "check corners: perf_cnct" );

        // // if (a > b)
        // // {
        // // applyGravity = true;
        // // }
        // }

        // System.out.println(DecimalRounder.roundToTenths((float)b));
        // ((DecimalRounder.roundToTenths((float)b)==0 ||
        // DecimalRounder.roundToTenths((float)b)==1 && (og.getX() -
        // other.getX()) < other.getWidth() && (og.getX() - other.getX()) >
        // -og.getWidth()) )
        if ( (int)b == 0 && ( og.getX() - other.getX() ) < other.getWidth()
            && ( og.getX() - other.getX() ) > -og.getWidth() && og.getY() < other.getY() )
        {
            c = CornerType.PERF_CNTCT;
        }
        // System.commented.out.println( "THIS IS B: " + b );

        Object[] thing = new Object[4];
        thing[0] = c;
        thing[1] = (float)Math.abs( a );
        thing[2] = (float)Math.abs( b );
        thing[3] = (float)mindistance[3];

        return thing; /////////////////////////////////////////////////////////////////////////////////////// POSSIBLE
                      /////////////////////////////////////////////////////////////////////////////////////// ERROR
                      /////////////////////////////////////////////////////////////////////////////////////// CHECK
                      /////////////////////////////////////////////////////////////////////////////////////// HERE

    }

}
