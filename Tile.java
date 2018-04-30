import java.awt.Point;

public class Tile
{
    private static final int TILE_SIZE = 20;//TODO placeholder number

    private int xPos;

    private int yPos;

    private Sprite containedSprite;

    public Tile(int xPos, int yPos, Sprite sprite)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.containedSprite = sprite;
    }

    public Sprite getSprite()
    {
        return containedSprite;
    }

    public Point[][] getCoordinateRange()
    {
        Point[][] range = new Point[TILE_SIZE][TILE_SIZE];

        for (int i = xPos; i <= TILE_SIZE + xPos; i++)
        {
            for (int j = yPos; j < TILE_SIZE + yPos; j++)
            {
                range[i - TILE_SIZE][j - TILE_SIZE] = new Point(xPos, yPos);
            }
        }
        return range;
    }
}
