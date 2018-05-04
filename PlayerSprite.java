import java.awt.Color;

public class PlayerSprite extends Moveable
{
    private boolean jumpFlag = false;

    public PlayerSprite(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
        this.compareValue++;
    }

    public boolean move()
    {
        super.addGravity();
        if (getY() + getHVelocity() > 400)
        {
            setVVelocity(0);
            setY(400);
        }
        checkJump();
        setX(getX() + getHVelocity());
        setY(getY() + getVVelocity());
        return false;
    }

    private void checkJump()
    {
        if (jumpFlag == true && DecimalRounder.roundToHundreths(getVVelocity()) == 0.0)
        {
            setVVelocity(-Moveable.MAX_V_VELOCITY);
            jumpFlag = false;
        }
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
        jumpFlag = true;
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
        if (jumpFlag == true && !(DecimalRounder.roundToHundreths(getVVelocity()) == 0.0))
        {
            jumpFlag = false;
        }
    }
}