import java.awt.Color;

public class Engine
{
    Color[][] level;
    
    private int camera;
    
    private boolean LEVEL_COMPLETE = true;
    
    private final int FPS = 60;
    
    public Engine(Sprite[] sprites)
    {
        camera = 0;
        level = new Color[600][/*TODO find number for level length*/];
        for (Sprite s : sprites)
        {
            addSprite(s);
        }
    }
    
    private void addSprite(Sprite sprite)
    {
        
    }
    
    private void run()
    {
        while (move() != LEVEL_COMPLETE)
        {
            draw();
            pause( Math.round(( 1 / FPS ) * 1000));            
        }
    }
    
    private boolean move()
    {
        return false;
    }
    
    private void draw()
    {
        
    }
    
    private void pause(long time)
    {
        try
        {
            Thread.sleep( time );
        }
        catch(Exception ex)
        {
            
        }
    }
    
    
}
