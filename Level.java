
public class Level
{
    private static final Sprite[][] sprites = {};
    private static int level = 0;
    
    public Level()
    {
        //initialize the new controller here (possibly window too)
    }
    
    public Level(Level last)
    {
        //same as default constructor but closes out the previous level
    }
    
    public void play()
    {
        
    }
    
    private void nextLevel()
    {
        level++;
        Level next = new Level(this);
    }
}
