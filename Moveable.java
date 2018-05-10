import java.awt.Color;
import java.awt.Point;


public abstract class Moveable extends Sprite
{
    private float horizontalVelocity;

    private float verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    private boolean applyGravity = true;


    private enum CollisionType {
        NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY, UNDER_ENEMY, OVER_ENEMY
    };


    private enum CornerType {
        TR_BL, TR_BR, TL_BR, TL_BL, BL_TR, BR_TR, BR_TL, BL_TL, PERF_CNTCT
    };


    public abstract boolean move();


    public Moveable( int x, int y, int width, int height, Color color )
    {
        super( x, y, width, height, color );
        this.compareValue++;
    }


    public float getHVelocity()
    {
        return horizontalVelocity;
    }


    public float getVVelocity()
    {
        return verticalVelocity;
    }


    public void setHVelocity( float newVelocity )
    {
        horizontalVelocity = newVelocity;
    }


    public void setVVelocity( float newVelocity )
    {
        verticalVelocity = newVelocity;
    }


    public void addGravity()
    {
        if ( verticalVelocity < MAX_V_VELOCITY )
        {
            verticalVelocity += 0.05;
            if ( DecimalRounder.roundToHundreths( verticalVelocity ) == 0.0 )
            {
                verticalVelocity += 0.05;
            }
            verticalVelocity = DecimalRounder.roundToHundreths( verticalVelocity );
        }
    }


    // NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY,
    // UNDER_ENEMY, OVER_ENEMY
    private CollisionType checkCollision() ////////////////////////////////////////////////////////////////////// ADD
                                           ////////////////////////////////////////////////////////////////////// LATER,
                                           ////////////////////////////////////////////////////////////////////// collision
                                           ////////////////////////////////////////////////////////////////////// flag
                                           ////////////////////////////////////////////////////////////////////// for
                                           ////////////////////////////////////////////////////////////////////// sprite
    {
        for ( Sprite s : Engine.sprites )
        {
            if ( s != this )
            {

                // boolean bothMoveable = false;

                if ( s instanceof Moveable && this instanceof Moveable )
                {

                    if ( s instanceof EnemySprite && this instanceof EnemySprite )
                    {
                        return CollisionType.NO_COLLISION;
                    }
                    // bothMoveable = true;

                    if ( s instanceof EnemySprite && this instanceof PlayerSprite )
                    {
                        return checkCollision_BothMoveable( (PlayerSprite)this, (EnemySprite)s );
                    }

                    return checkCollision_BothMoveable( (PlayerSprite)s, (EnemySprite)this );

                }
                return checkCollision_OneMoveable( this, (GroundSprite)s );
            }
        }
        return CollisionType.NO_COLLISION;
    }


    private CollisionType checkCollision_BothMoveable( PlayerSprite player, EnemySprite enemy )
    {
        Object[] temp = checkCorners( player, enemy );
        boolean HCollision;
        if ( Math.abs( player.getHVelocity() ) + Math.abs( enemy.getHVelocity() ) >= (Double)temp[1] )
        {
            HCollision = true;
        }
        else
        {
            HCollision = false;
        }

        switch ( (CornerType)temp[0] )
        {
            case TR_BL:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case TR_BR:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case TL_BR:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case TL_BL:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case BL_TR:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case BR_TR:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case BR_TL:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case BL_TL:
                if ( HCollision )
                {

                }
                else
                {

                }
                break;

            case DONT:
                break;
        }

        return CollisionType.NO_COLLISION;
    }

    // NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY,
    private CollisionType checkCollision_OneMoveable( Moveable mover, Sprite ground )
    {
        Object[] temp = checkCorners( mover, ground );

        if (mover.getVVelocity() == 0)
        {
            mover.setHVelocity( (Float)temp[1] * (mover.getHVelocity() / Math.abs(mover.getHVelocity())));
            return CollisionType.HORIZONTAL_GROUND;
        }
        
        if (mover.getHVelocity() == 0)
        {   
            applyGravity = false;
            mover.setVVelocity( (Float)temp[2] * (mover.getVVelocity() / Math.abs(mover.getVVelocity())));
            return CollisionType.VERTICAL_GROUND;
        }

        switch ( (CornerType)temp[0] )
        {
            case TR_BL: //doned
            int hSign = Math.abs(mover.getHVelocity()) / mover.getHVelocity();
            int vSign = Math.abs(mover.getVVelocity()) / mover.getVVelocity();

                    if(mover.getHVelocity() - mover.getWidth() > (double)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity((float)temp[1] + mover.getWidth());
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(hSign*(float)(slope*mover.getHVelocity()));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(mover.getVVelocity() > (double)temp[2]){
                        mover.setVVelocity(vSign*(float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity((float)(slope_inverted*getHVelocity()));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

            case TL_BR:
            int hSign = Math.abs(mover.getHVelocity()) / mover.getHVelocity();
            int vSign = Math.abs(mover.getVVelocity()) / mover.getVVelocity();

                if(Math.abs(mover.getHVelocity()) - mover.getWidth() > (double)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity(hSign*((float)temp[1] + mover.getWidth()));
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(vSign*(float)(slope*mover.getHVelocity()));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(Math.abs(mover.getVVelocity()) > (double)temp[2]){
                        mover.setVVelocity(vSign*(float)temp[2]);
                        double slope_inverted = Math.abs(.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity(hSign*(float)(slope_inverted*getHVelocity()));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

            case BL_TR:
            int hSign = Math.abs(mover.getHVelocity()) / mover.getHVelocity();
            int vSign = Math.abs(mover.getVVelocity()) / mover.getVVelocity();

                if(Math.abs(mover.getHVelocity()) - mover.getWidth() > (double)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity(hSign*((float)temp[1] + mover.getWidth()));
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(vSign*(float)(slope*Math.abs(mover.getHVelocity()));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(Math.abs(mover.getVVelocity()) > (double)temp[2]){
                        mover.setVVelocity(vSign*(float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity(hSign*(float)(slope_inverted*Math.abs(getHVelocity())));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

            case BR_TL:
            int hSign = Math.abs(mover.getHVelocity()) / mover.getHVelocity();
            int vSign = Math.abs(mover.getVVelocity()) / mover.getVVelocity();

                if(Math.abs(mover.getHVelocity()) - mover.getWidth() > (double)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity(hSign*((float)temp[1] + mover.getWidth()));
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(vSign*(float)(slope*Math.abs(mover.getHVelocity()));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(Math.abs(mover.getVVelocity()) > (double)temp[2]){
                        mover.setVVelocity(vSign*(float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity(hSign*(float)(slope_inverted*Math.abs(getHVelocity())));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

                case PERF_CNTCT:
                break;
        }

        return CollisionType.NO_COLLISION;
    }


    private double[] getDiag( Point a, Point b )
    {
        double[] temp = new double[3];
        double x = ( a.getX() - b.getX() ) * ( a.getX() - b.getX() );
        double y = ( a.getY() - b.getY() ) * ( a.getY() - b.getY() );
        temp[0] = Math.sqrt( x + y );
        temp[1] = Math.sqrt( x );
        temp[2] = Math.sqrt( x );
        return temp;
    }


    // enums: {TR_BL/, TR_BR/, TL_BR/, TL_BL/, BL_TR/, BR_TR/, BR_TL/, BL_TL/}
    // Object array contains 3 vals, type of collision, minimum x, and minimum y
    private Object[] checkCorners( Sprite og, Sprite other )
    {
        CornerType cornerTemp = CornerType.TR_BL;
        double[] mindistance = getDiag( og.getGetTopRightCorner(), other.getGetBotLeftCorner() );

        double[] temp = getDiag( og.getGetTopRightCorner(), other.getGetBotRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TR_BR;

        }

        temp = getDiag( og.getGetTopLeftCorner(), other.getGetBotRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TL_BR;
        }

        temp = getDiag( og.getGetTopLeftCorner(), other.getGetBotLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.TL_BL;
        }

        temp = getDiag( og.getGetBotLeftCorner(), other.getGetTopRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BL_TR;
        }

        temp = getDiag( og.getGetBotRightCorner(), other.getGetTopRightCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BR_TR;
        }

        temp = getDiag( og.getGetBotRightCorner(), other.getGetTopLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BR_TL;
        }

        temp = getDiag( og.getGetBotLeftCorner(), other.getGetTopLeftCorner() );
        if ( temp[0] < mindistance[0] )
        {
            mindistance = temp;
            cornerTemp = CornerType.BL_TL;
        }
        double a = mindistance[1];
        double b = mindistance[2];
        CornerType c = cornerTemp;

        if(a == 0 || b==0){
            c = CornerType.PERF_CNTCT;
        }

        Object[] thing = new Object[3];
        thing[0] = c;
        thing[1] = Math.abs(a);
        thing[2] = Math.abs(b);

        return thing; /////////////////////////////////////////////////////////////////////////////////////// POSSIBLE
                      /////////////////////////////////////////////////////////////////////////////////////// ERROR
                      /////////////////////////////////////////////////////////////////////////////////////// CHECK
                      /////////////////////////////////////////////////////////////////////////////////////// HERE

    }

}
