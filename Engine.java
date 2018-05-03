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

    private final int CAMERA_THRESHOLD = 800/3;
    
    private final int WINDOW_WIDTH = 800;
    
    private final int WINDOW_HEIGHT = 600;
    
    private final int FPS = 30;

    private Timer timer;

    private Window window;

    private PlayerSprite player;

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
        if (sprite instanceof PlayerSprite)
        {
            player = (PlayerSprite)sprite;
        }
    }
    
    public void run()
    {
        window = new Window(WINDOW_HEIGHT, WINDOW_WIDTH, sprites, this);
        timer = new Timer(Math.round(( 1 / FPS ) * 1000), new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (move() == COMPLETED_LEVEL)
                {
                    levelComplete();
                }
            }
        });
        timer.start();
    }
    
    private boolean move()
    {
        for (Sprite s : sprites)
        {
            if (s instanceof Moveable)
            {
                if (((Moveable)s).move() == COMPLETED_LEVEL)
                {
                    return true;
                }
                checkForCollisions();
            }
        }
        if (player.getX() > CAMERA_THRESHOLD)
        {
            camera = player.getX() - CAMERA_THRESHOLD; 
        }
        window.getFrame().repaint(); 
        return false;
    }

    private void checkForCollisions()
    {

    }

    public void rightKeyPressed()    {player.rightKeyPressed();}

    public void leftKeyPressed()    {player.leftKeyPressed();}

    public void upKeyPressed()    {player.upKeyPressed();}

    public void rightKeyReleased()    {player.rightKeyReleased();}

    public void leftKeyReleased()    {player.leftKeyReleased();}

    public void upKeyReleased()    {player.upKeyReleased();}
    
    private void levelComplete()
    {
        timer.stop();
        //TODO close out window
        level.nextLevel();
    }
    
}
