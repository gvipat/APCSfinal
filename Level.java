import java.awt.Color;
import java.util.Arrays;

public class Level
{
    private final Sprite[][] sprites = 


{{new PlayerSprite(5, 5, 20, 20, Color.BLUE), new GroundSprite(0, 400, 1000, 40), new GroundSprite(300, 200,  1000,  40), new GroundSprite(200, 360, 1000, 40)},
 {new PlayerSprite(5, 5, 20, 20, Color.ORANGE)}};
    
    
    public static int level = 0;
    private Engine engine;
    
    public Level()
    {
        engine = new Engine(this);
    }
    
    
    public void play()
    {
        engine.run();
    }

    public Sprite[] getSprites()
    {
        Sprite[] copy = new Sprite[sprites[level].length];
        for (int i = 0; i < sprites[level].length; i++)
        {
            copy[i] = sprites[level][i].copy();
        }
        return copy;
    }
    
    public void nextLevel()
    {
        level++;
        engine = new Engine(this);
        play();
    }

    public void restart()
    {
        engine = null;
        engine = new Engine(this);
        play();
    }
}
