import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.Timer;


public class Engine
{
    Color[][] stage;

    public static int camera;

    private boolean COMPLETED_LEVEL = true;

    private final int CAMERA_THRESHOLD = 800 / 3;

    public static final int WINDOW_WIDTH = 800;

    public static final int WINDOW_HEIGHT = 600;

    public static boolean DEBUG_MODE = false;

    private final int FPS = 30;

    public boolean paused = false;

    private Timer timer;

    private Window window;

    private PlayerSprite player;

    public static PriorityQueue<Sprite> sprites;
    // Sprite types will override their compare value specified in the sprite
    // class.
    // This will allow sprites to be drawn

    private Level level;


    public Engine( Level lev )
    {
        level = lev;
        Sprite[] levelSprites = lev.getSprites();
        sprites = new PriorityQueue<Sprite>( levelSprites.length );
        camera = 0;
        stage = new Color[WINDOW_HEIGHT][/* TODO find number for level length */];
        for ( Sprite s : levelSprites )
        {
            addSprite( s );
        }
    }


    private void addSprite( Sprite sprite )
    {
        sprites.add( sprite );
        if ( sprite instanceof PlayerSprite )
        {
            player = (PlayerSprite)sprite;
        }
    }


    public void run()
    {
        window = new Window( WINDOW_HEIGHT, WINDOW_WIDTH, sprites, this );
        if (!DEBUG_MODE)
        {
            timer = new Timer( Math.round( ( 1 / FPS ) * 1000 ), new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    if ( move() == COMPLETED_LEVEL )
                    {
                        levelComplete();
                    }
                }
            } );
            timer.start();
        }
    }

    public void manualMove()
    {
        if ( DEBUG_MODE && move() == COMPLETED_LEVEL )
        {
            levelComplete();
        }
    }


    private boolean move()
    {
        for ( Sprite s : sprites )
        {
            if ( s instanceof Moveable )
            {
                if ( ( (Moveable)s ).move() == COMPLETED_LEVEL )
                {
                    return true;
                }

                if ( ( (Moveable)s ).isDead )
                {
                    if ( s == player )
                    {
                        if (!DEBUG_MODE)
                        {
                            timer.stop();
                        }
                        openDeathScreen();
                    }
                    else
                    {
                        removeSprite( s );
                    }
                }

            }
        }
        if ( player.getX() > CAMERA_THRESHOLD )
        {
            camera = player.getX() - CAMERA_THRESHOLD;
        }
        window.getFrame().repaint();
        return false;
    }


    public void removeSprite( Sprite toBeRemoved )
    {
        sprites.remove( toBeRemoved );
    }


    public void rightKeyPressed()
    {
        player.rightKeyPressed();
    }


    public void leftKeyPressed()
    {
        player.leftKeyPressed();
    }


    public void upKeyPressed()
    {
        player.upKeyPressed();
    }


    public void rightKeyReleased()
    {
        player.rightKeyReleased();
    }


    public void leftKeyReleased()
    {
        player.leftKeyReleased();
    }


    public void upKeyReleased()
    {
        player.upKeyReleased();
    }


    private void levelComplete()
    {
        kill();
        level.nextLevel();
    }


    private void openDeathScreen()
    {
        JPopupMenu exitOption = new JPopupMenu();
        JButton exit = new JButton( "Exit" );
        exit.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                System.exit( 0 );
            }
        } );
        exitOption.add( exit );

        JButton restart = new JButton( "Restart" );
        restart.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                kill();
                exitOption.setVisible( false );
                exitOption.setEnabled( false );
                level.restart();
            }
        } );
        exitOption.add( restart );
        exitOption.setAlignmentX( (float)100 );
        exitOption.setVisible( true );

    }


    public void kill()
    {
        timer.stop();
        window.setVisible( false );
        window.setEnabled( false );
        window.dispose();
    }

    public void pause()
    {
        if (!DEBUG_MODE)
        {
            timer.stop();
            paused = true;
        }
    }

    public void resume()
    {
        if (!DEBUG_MODE)
        {
            timer.start();
            paused = false;
        }
    }

}
