
public class Level
{
    private static final Sprite[][] sprites = {};
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
