import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.Timer;

public class Engine
{
    Color[][] stage;
    
    public static int camera;
    
    private boolean COMPLETED_LEVEL = true;
    
    private final int WINDOW_WIDTH = 800;
    
    private final int WINDOW_HEIGHT = 600;
    
    private final int FPS = 60;

    private Timer timer;

    private PriorityQueue<Sprite> sprites;
    //Sprite types will override their compare value specified in the sprite class.
    //This will allow sprites to be drawn 

    private Level level;
    
    public Engine(Level lev)
    {
        level = lev;
        Sprite[] levelSprites = lev.getSprites();
        sprites = new PriorityQueue<Sprite>(levelSprites.length);
        camera = 0;
        stage = new Color[WINDOW_HEIGHT][/*TODO find number for level length*/];
        for (Sprite s : levelSprites)
        {
            addSprite(s);
        }
    }
    
    private void addSprite(Sprite sprite)
    {
        sprites.add(sprite);
    }
    
    public void run()
    {
        timer = new Timer(Math.round(( 1 / FPS ) * 1000), new ActionListener()
        {
        
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (move() != COMPLETED_LEVEL)
                {
                    levelComplete();
                }
            }
        });
        timer.start();
    }
    
    private boolean move()
    {
        return false;
    }
    
    private void levelComplete()
    {
        timer.stop();
        level.nextLevel();
    }
    
}
