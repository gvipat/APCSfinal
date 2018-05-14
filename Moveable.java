import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;


public abstract class Moveable extends Sprite
{
    private float horizontalVelocity;

    private float verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    public boolean applyGravity = true;

    public Sprite enemyToKill = null;


    public enum CollisionType {
        NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY, UNDER_ENEMY, OVER_ENEMY, CONTACT
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
        if ( applyGravity && verticalVelocity < MAX_V_VELOCITY )
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
    public LinkedList<CollisionType> checkCollision() ////////////////////////////////////////////////////////////////////// ADD
                                           ////////////////////////////////////////////////////////////////////// LATER,
                                           ////////////////////////////////////////////////////////////////////// collision
                                           ////////////////////////////////////////////////////////////////////// flag
                                           ////////////////////////////////////////////////////////////////////// for
                                           ////////////////////////////////////////////////////////////////////// sprite
    {
        LinkedList<CollisionType> list = new LinkedList<CollisionType>();

        for ( Sprite s : Engine.sprites )
        {
            if ( s != this )
            {

                // boolean bothMoveable = false;

                if ( s instanceof Moveable && this instanceof Moveable )
                {

                    if ( s instanceof EnemySprite && this instanceof EnemySprite )
                    {
                       //do nothing
                    }
                    // bothMoveable = true;

                    if ( s instanceof EnemySprite && this instanceof PlayerSprite )
                    {
                        this.setContact( "PLAYER_ENEMY" );
                        list.add( checkCollision_BothMoveable( (PlayerSprite)this, (EnemySprite)s ));
                    }
                    
                    s.setContact( "PLAYER_ENEMY" );
                    list.add( checkCollision_BothMoveable( (PlayerSprite)s, (EnemySprite)this ));

                }
                
                this.setContact( "PLAYER_GROUND" );
                list.add( checkCollision_OneMoveable( this, (GroundSprite)s ) ); 
                
            }
        }
        return list;
    }

    //NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY, UNDER_ENEMY, OVER_ENEMY
    private CollisionType checkCollision_BothMoveable( PlayerSprite player, EnemySprite enemy ) /////////ACTUALLY I DON'T NEED TO GET RID OF TEMP BECAUSE TEMP IS NEVER ADDED TO PRIORITY QUEUE AND RENDERED
    {
        Object[] temp = checkCorners( player, enemy );
        Sprite tempSprite = new GroundSprite( Math.round( enemy.getX() + enemy.getHVelocity() ),
            Math.round( enemy.getY() + enemy.getVVelocity() ), enemy.getWidth(), enemy.getHeight() );
        CollisionType playerTempCollision = checkCollision_OneMoveable(player, tempSprite);
        if (playerTempCollision == CollisionType.HORIZONTAL_GROUND )
        {
            return CollisionType.HORIZONTAL_ENEMY;
        }
        else if (playerTempCollision == CollisionType.VERTICAL_GROUND)
        {
            if (player.getVVelocity() > 0)
            {
                return CollisionType.UNDER_ENEMY;
            }
            if (player.getVVelocity() < 0)
            {
                Engine.sprites.remove(enemy);
                return CollisionType.OVER_ENEMY;
            }
        }

        return CollisionType.NO_COLLISION;
    }

    // NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND, HORIZONTAL_ENEMY,
    private CollisionType checkCollision_OneMoveable( Moveable mover, Sprite ground )
    {
        Object[] temp = checkCorners( mover, ground );

        if (DecimalRounder.roundToHundreths(mover.getHVelocity()) == 0 && Math.abs(mover.getHVelocity()) > (Float)temp[1])
        {
            mover.setHVelocity( (Float)temp[1] * (mover.getHVelocity() / Math.abs(mover.getHVelocity())));
            return CollisionType.HORIZONTAL_GROUND;
        }
        
        //System.out.println( "a = " + temp[1] + "** b =" + temp[2] + "*************" );
        if (DecimalRounder.roundToHundreths( mover.getHVelocity() ) == 0 && Math.abs( mover.getVVelocity() ) > (Float)temp[2])
        {   
            
            applyGravity = false;
            mover.setVVelocity( (Float)temp[2] * (mover.getVVelocity() / Math.abs(mover.getVVelocity())));
            return CollisionType.VERTICAL_GROUND;
        }

        int hSign;
        int vSign;
        
        
        System.out.println( (CornerType) temp[0] + "contact type" );
        switch ( (CornerType)temp[0] ) 
        {
            case PERF_CNTCT:
                
                return CollisionType.CONTACT;
            
            case TR_BL: //doned
                hSign = (int) (Math.abs(mover.getHVelocity()) / mover.getHVelocity());
                vSign = (int) (Math.abs(mover.getVVelocity()) / mover.getVVelocity());

                    if(mover.getHVelocity() - mover.getWidth() > (Float)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity((Float)temp[1] + mover.getWidth());
                        float slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(hSign*(Float)(slope*mover.getHVelocity()));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(mover.getVVelocity() > (Float)temp[2]){
                        mover.setVVelocity(vSign*(Float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity((float)(slope_inverted*getHVelocity()));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

            case TL_BR:
                hSign = (int) (Math.abs(mover.getHVelocity()) / mover.getHVelocity());
                vSign =  (int) (Math.abs(mover.getVVelocity()) / mover.getVVelocity());

                if(Math.abs(mover.getHVelocity()) - mover.getWidth() > (Float)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity(hSign*((Float)temp[1] + mover.getWidth()));
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(vSign*(float)(slope*mover.getHVelocity()));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(Math.abs(mover.getVVelocity()) > (Float)temp[2]){
                        mover.setVVelocity(vSign*(Float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity(hSign*(float)(slope_inverted*getHVelocity()));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

            case BL_TR:
                hSign = (int) (Math.abs(mover.getHVelocity()) / mover.getHVelocity());
                vSign = (int) (Math.abs(mover.getVVelocity()) / mover.getVVelocity());

                if(Math.abs(mover.getHVelocity()) - mover.getWidth() > (Float)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity(hSign*((Float)temp[1] + mover.getWidth()));
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(vSign*(float)(slope*Math.abs(mover.getHVelocity())));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(Math.abs(mover.getVVelocity()) > (Float)temp[2]){
                        mover.setVVelocity(vSign*(Float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity(hSign*(float)(slope_inverted*Math.abs(getHVelocity())));
                    return CollisionType.VERTICAL_GROUND;
                    }
                break;

            case BR_TL:
                hSign = (int) (Math.abs(mover.getHVelocity()) / mover.getHVelocity());
                vSign = (int) (Math.abs(mover.getVVelocity()) / mover.getVVelocity());

                if(Math.abs(mover.getHVelocity()) - mover.getWidth() > (Float)temp[1]){ ///////maybe minus 1
                        mover.setHVelocity(hSign*((Float)temp[1] + mover.getWidth()));
                        double slope = Math.abs(mover.getVVelocity() / mover.getHVelocity()); 
                        mover.setVVelocity(vSign*(float)(slope*Math.abs(mover.getHVelocity())));
                    return CollisionType.HORIZONTAL_GROUND;
                    }
                    if(Math.abs(mover.getVVelocity()) > (Float)temp[2]){
                        mover.setVVelocity(vSign*(Float)temp[2]);
                        double slope_inverted = Math.abs(mover.getHVelocity() / mover.getVVelocity()); 
                        mover.setHVelocity(hSign*(float)(slope_inverted*Math.abs(getHVelocity())));
                    return CollisionType.VERTICAL_GROUND;
                    }
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
        temp[2] = Math.sqrt( y );
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

        
       if(DecimalRounder.roundToTenths((float)a) == 1 || DecimalRounder.roundToTenths((float)b)==1){
           //System.out.println( "perfect contacting" );
           
        
        if ((DecimalRounder.roundToTenths((float)b)==1 && (og.getX() - other.getX()) < other.getWidth() && (og.getX() - other.getX()) > -og.getWidth()) )
        {
            c = CornerType.PERF_CNTCT;
        }

        Object[] thing = new Object[3];
        thing[0] = c;
        thing[1] = (float)Math.abs(a);
        thing[2] = (float)Math.abs(b);

        return thing; /////////////////////////////////////////////////////////////////////////////////////// POSSIBLE
                      /////////////////////////////////////////////////////////////////////////////////////// ERROR
                      /////////////////////////////////////////////////////////////////////////////////////// CHECK
                      /////////////////////////////////////////////////////////////////////////////////////// HERE

    }

}
