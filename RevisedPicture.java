import java.awt.Color;


public class RevisedPicture
{
    Color[][] color;


    public RevisedPicture( int width, int height )
    {
        color = new Color[width][height];
    }


    public Color[][] getPicture()
    {
        return color;
    }
}