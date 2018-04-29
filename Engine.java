import java.awt.Color;

public class Engine
{
    Color[][] stage;
    
    private int camera;
    
    private boolean LEVEL_COMPLETE = true;
    
    private final int WINDOW_WIDTH = 800;
    
    private final int WINDOW_HEIGHT = 600;
    
    private final int FPS = 60;
    
    Picture image = new Picture(WINDOW_HEIGHT, WINDOW_HEIGHT);
    
    PictureFrame frame = new PictureFrame(image);
    
    public Engine(Sprite[] sprites)
    {
        camera = 0;
        stage = new Color[WINDOW_HEIGHT][/*TODO find number for level length*/];
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
        Color[][] onScreenImage = new Color[WINDOW_HEIGHT][WINDOW_WIDTH];
        for (int row = 0; row < stage.length; row++)
        {
            for (int col = camera; col < camera + WINDOW_WIDTH; col++)
            {
                //send draw message
            }
        }
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
