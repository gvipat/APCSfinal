import java.awt.Color;

public class Level
{
    private final Sprite[][] sprites = 


{{new PlayerSprite(5, 5, 20, 20, Color.BLUE), new GroundSprite(0, 500, 1000, 40), /*new CornerSprite(1001,500,20,20,true )*/}};
    
    
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
        return sprites[level];
    }
    
    public void nextLevel()
    {
        level++;
        engine = new Engine(this);
        play();
    }

    public void restart()
    {
        engine = new Engine(this);
        play();
    }
}
