import java.awt.Color;

public class Level
{
    private static final Sprite[][] sprites = 


    {{new PlayerSprite(5, 5, 20, 20, Color.BLUE), new GroundSprite(0, 500, 1000, 40), new EnemySprite(10, 5, 20, 20, Color.RED)}};
    
    
    public static int level = 0;
    private Engine engine;
    
    public Level()
    {
        engine = new Engine(this);
    }
    
    public Level(Level last)
    {
        this();
        //same as default constructor but closes out the previous level
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
        Level next = new Level(this);
    }
}
