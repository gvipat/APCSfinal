import java.awt.Color;
import java.awt.Point;

public abstract class Moveable extends Sprite
{
    private float horizontalVelocity;

    private float verticalVelocity;

    public static final int MAX_V_VELOCITY = 5;

    public static final int MAX_H_VELOCITY = 2;

    private boolean applyGravity = true;

    private enum CollisionType {NO_COLLISION, HORIZONTAL_GROUND, VERTICAL_GROUND,
                                HORIZONTAL_ENEMY, UNDER_ENEMY, OVER_ENEMY};

    private enum CornerType {TR_BL, TR_BR, TL_BR, TL_BL, BL_TR, BR_TR, BR_TL, BL_TL, DONT};

    public abstract boolean move();

    public Moveable(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
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
    public void setHVelocity(float newVelocity)
    {
        horizontalVelocity = newVelocity;
    }

    public void setVVelocity(float newVelocity)
    {
        verticalVelocity = newVelocity;
    }

    public void addGravity()
    {
        if (verticalVelocity < MAX_V_VELOCITY )
        {
            verticalVelocity += 0.05;
            if (DecimalRounder.roundToHundreths(verticalVelocity) == 0.0)
            {
                verticalVelocity += 0.05;
            }
            verticalVelocity = DecimalRounder.roundToHundreths(verticalVelocity);
        }
    }

    private CollisionType checkCollision()
    {
        for (Sprite s : Engine.sprites)
        {
            if (s != this)
            {
                switch (checkCorners(this, s))
                {
                    case TR_BL:

                        break;
                    case TR_BR:

                        break;
                    case TL_BR:

                        break;
                    case TL_BL:

                        break;
                    case BL_TR:

                        break;
                    case BR_TR:

                        break;
                    case BR_TL:

                        break;
                    case BL_TL:

                        break;
                    case DONT:
                        break;
                }
            }
        }
        return CollisionType.NO_COLLISION;
    }
  private double[] getDiag(Point a, Point b)
    {
        double [] temp = new double [3];
        double x =  (a.getX() - b.getX()) * (a.getX() - b.getX());
        double y = (a.getY() - b.getY()) * (a.getY() - b.getY());   
        temp[0] = Math.sqrt( x + y );
        temp[1] = Math.sqrt(x);
        temp[2] = Math.sqrt(x);
        return temp;
    }   
    //enums: {TR_BL/, TR_BR/, TL_BR/, TL_BL/, BL_TR/, BR_TR/, BR_TL/, BL_TL/}
    private Object[] checkCorners(Sprite og, Sprite other)
    {
          CornerType cornerTemp = CornerType.TR_BL;
          double mindistance = getDiag(og.getGetTopRightCorner(), other.getGetBotLeftCorner()) [0];
          
          double temp  =  getDiag(og.getGetTopRightCorner(), other.getGetBotRightCorner()) [0];

          
          if (temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.TR_BR;
              
          }
          
          temp = getDiag(og.getGetTopLeftCorner(), other.getGetBotRightCorner()) [0];
          if(temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.TL_BR;
          }
          
          temp = getDiag(og.getGetTopLeftCorner(), other.getGetBotLeftCorner()) [0];
          if(temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.TL_BL;
          }
          
          temp = getDiag(og.getGetBotLeftCorner(), other.getGetTopRightCorner()) [0];
          if(temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.BL_TR;
          }
          
          temp = getDiag(og.getGetBotRightCorner(), other.getGetTopRightCorner()) [0];
          if(temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.BR_TR;
          }
          
          temp = getDiag(og.getGetBotRightCorner(), other.getGetTopLeftCorner()) [0];
          if(temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.BR_TL;
          }
          
          temp = getDiag(og.getGetBotLeftCorner(), other.getGetTopLeftCorner()) [0];
          if(temp < mindistance)
          {
              mindistance = temp;
              cornerTemp =  CornerType.BL_TL;
          }
          
          return new Object[cornerTemp, ];
          
         
          
          
          
       
    }
    
    
  
    
    
    
    
    
    
    
    
    
}
