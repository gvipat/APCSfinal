import java.awt.Color;

public class PlayerSprite extends Moveable
{
    public PlayerSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    public boolean move()
    {
        super.addGravity();
        setX(getX() + getHVelocity());
        setY(getY() + getVVelocity());
        if (getY() > 400)
        {
            setVVelocity(0);
            setY(400);
        }
        return false;
    }

    public void rightKeyPressed()
    {
        if (getHVelocity() < Moveable.MAX_H_VELOCITY)
        {
            setHVelocity(getHVelocity() + 1);
        }
    }

    public void leftKeyPressed()
    {
        if (getHVelocity() > -Moveable.MAX_H_VELOCITY)
        {
            setHVelocity(getHVelocity() - 1);
        }
    }

    public void upKeyPressed()
    {
        if (getVVelocity() < 0 && getVVelocity() > -0.1)
        {
            setVVelocity(-Moveable.MAX_V_VELOCITY);
        }
    }

    public void rightKeyReleased()
    {
        setHVelocity(0);
    }

    public void leftKeyReleased()
    {
        setHVelocity(0);
    }

    public void upKeyReleased()
    {

    }
}