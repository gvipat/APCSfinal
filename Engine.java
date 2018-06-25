import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;


/**
 * An engine is the back end of the game. It opens a window, and tells all the
 * sprites to move at an increment defined in the FPS variable.
 *
 * @author Roshan Sevalia
 * @version May 18, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: Charles Huang, Gaurav Vipat
 */
public class Engine
{
    /**
     * Represents the position of the "camera." Defines where in the stage the
     * window should be drawing.
     */
    public static int camera;

    /**
     * Used for readability in the move method. If a sprite returns true, then
     * the level is completed.
     */
    private final boolean COMPLETED_LEVEL = true;

    /**
     * Defines how far right into the window the player has to move before the
     * camera begins following the player.
     */
    private final int CAMERA_THRESHOLD = 800 / 3;

    /**
     * Defines how wide the game window will be.
     */
    public static final int WINDOW_WIDTH = 800;

    /**
     * Defines how tall the game window will be.
     */
    public static final int WINDOW_HEIGHT = 600;

    /**
     * If true, the engine will not start the timer that moves the players
     * automatically.
     */
    public static boolean DEBUG_MODE = false;

    /**
     * Defines how many times per second to execute the move method for each
     * sprite.
     */
    private final int FPS = 120;

    /**
     * Represents if the game is paused or not.
     */
    public boolean paused = false;

    /**
     * The timer used to call the move methods of every sprite
     */
    private Timer timer;

    /**
     * The window used to display the game.
     */
    private Window window;

    /**
     * Holds the player to identify deaths
     */
    private PlayerSprite player;

    /**
     * Holds the level's sprites with the ones to be rendered last having the
     * lowest priority.
     */
    public static PriorityQueue<Sprite> sprites;
    // Sprite types will override their compare value specified in the sprite
    // class.
    // This will allow sprites to be drawn

    /**
     * Holds the level that created the engine to communicate when to switch or
     * restart levels.
     */
    private Level level;

    /**
     * Holds the dead sprites so that they are ready to respawn later on
     */
    private static ArrayList<EnemySprite> deadSprites = new ArrayList<EnemySprite>();

    public static boolean TEXTURES_ENABLED = true;


    /**
     * Constructor
     * 
     * @param lev
     *            the level that created this engine
     */
    public Engine( Level lev )
    {
        level = lev;
        Sprite[] levelSprites = lev.getSprites();
        sprites = new PriorityQueue<Sprite>( levelSprites.length );
        camera = 0;
        for ( Sprite s : levelSprites )
        {
            addSprite( s );
        }
    }


    /**
     * Adds the sprite to the sprites priority queue. If the sprite is a player,
     * it registers the sprite as the player
     * 
     * @param sprite
     *            the sprite to be added
     */
    private void addSprite( Sprite sprite )
    {
        sprites.add( sprite );
        if ( sprite instanceof PlayerSprite )
        {
            player = (PlayerSprite)sprite;
        }
    }


    /**
     * Opens the window and initializes the timer. If the engine is not in debug
     * mode, it begins the timer to call move as well.
     */
    public void run()
    {
        window = new Window( WINDOW_HEIGHT, WINDOW_WIDTH, sprites, this );
        if ( !DEBUG_MODE )
        {
            timer = new Timer( (int)( Math.round( ( 1 / (double) FPS ) * 1000 ) ),
                new ActionListener()
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


    /**
     * Used to manually call move in debug mode
     */
    public void manualMove()
    {
        if ( DEBUG_MODE && move() == COMPLETED_LEVEL )
        {
            levelComplete();
        }
    }


    /**
     * Moves every sprite. If the player is past the finish line, the level is
     * completed and it returns true.
     * 
     * @return true if the level is complete.
     */
    private boolean move()
    {
        Iterator<Sprite> aliveIter = Engine.sprites.iterator();
        while ( aliveIter.hasNext() )
        {
            Sprite s = aliveIter.next();
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
                        if ( !DEBUG_MODE )
                        {
                            timer.stop();
                        }
                        openDeathScreen();
                    }
                    else
                    {
                        if ( s instanceof EnemySprite )
                        {
                            deadSprites.add( (EnemySprite)s );
                            aliveIter.remove();
                        }
                    }
                }

            }
        }
        if ( player.getX() > CAMERA_THRESHOLD )
        {
            camera = player.getX() - CAMERA_THRESHOLD;
        }
        Iterator<EnemySprite> deadIter = deadSprites.iterator();
        while ( deadIter.hasNext() )
        {
            EnemySprite temp = deadIter.next();
            if ( temp.reset() )
            {
                sprites.add( temp );
                deadIter.remove();
            }
        }
        window.getFrame().repaint();
        return false;
    }


    /**
     * Tells the player that the right arrow key is pressed.
     */
    public void rightKeyPressed()
    {
        player.rightKeyPressed();
    }


    /**
     * Tells the player that the left arrow key is pressed.
     */
    public void leftKeyPressed()
    {
        player.leftKeyPressed();
    }


    /**
     * Tells the player that the up arrow key is pressed.
     */
    public void upKeyPressed()
    {
        player.upKeyPressed();
    }


    /**
     * Tells the player that the right arrow key is released.
     */
    public void rightKeyReleased()
    {
        player.rightKeyReleased();
    }


    /**
     * Tells the player that the left arrow key is released.
     */
    public void leftKeyReleased()
    {
        player.leftKeyReleased();
    }


    /**
     * Tells the player that the up arrow key is released.
     */
    public void upKeyReleased()
    {
        player.upKeyReleased();
    }


    /**
     * Stops the timer and tells the level to go to the next level
     */
    private void levelComplete()
    {
        kill();
        level.nextLevel();
    }


    /**
     * Opens the death dialog box that gives the option to either restart the
     * level or quit the game.
     */
    private void openDeathScreen()
    {
        Game.updatePresence("Player Dead.", "RIP");
        final JFrame frame = new JFrame( "You Died..." );
        JButton exit = new JButton( "Exit" );
        exit.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                Game.exit();
            }
        } );
        JButton restart = new JButton( "Restart" );
        restart.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                kill();
                frame.dispose();
                level.restart();
            }
        } );
        frame.add( restart );
        frame.add( exit, BorderLayout.AFTER_LAST_LINE );
        frame.setMinimumSize( new Dimension( 400, 200 ) );
        frame.setSize( 400, 200 );
        frame.setResizable( false );
        frame.setIconImage( Toolkit.getDefaultToolkit().getImage( "SlidingBloccIcon.png" ) );
        frame.setVisible( true );
        frame.setAlwaysOnTop( true );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setLocationRelativeTo( window );

    }


    /**
     * Closes the window and stops the timers.
     */
    public void kill()
    {
        if ( timer != null )
        {
            timer.stop();
        }
        Engine.sprites.removeAll( Engine.sprites );
        Engine.deadSprites.removeAll( Engine.deadSprites );
        window.setVisible( false );
        window.setEnabled( false );
        window.dispose();
    }


    /**
     * Pauses the timer to pause the game
     */
    public void pause()
    {
        if ( !DEBUG_MODE )
        {
            timer.stop();
            paused = true;
        }
    }


    /**
     * Restarts the timer to resume the game.
     */
    public void resume()
    {
        if ( !DEBUG_MODE )
        {
            timer.start();
            paused = false;
        }
    }


    /**
     * Returns the player
     * 
     * @return the player
     */
    public PlayerSprite getPlayer()
    {
        return player;
    }


    /**
     * Returns an enemy sprite from the engine's sprites (testing use only)
     * 
     * @return an enemy sprite (testing use only)
     */
    public EnemySprite getAnEnemy()
    {
        for ( Sprite s : sprites )
        {
            if ( s instanceof EnemySprite )
            {
                return (EnemySprite)s;
            }
        }
        return null;
    }


    /**
     * Returns a ground sprite from the engine's sprites (testing use only)
     * 
     * @return a ground sprite (testing use only)
     */
    public GroundSprite getAGround()
    {
        for ( Sprite s : sprites )
        {
            if ( s instanceof GroundSprite )
            {
                return (GroundSprite)s;
            }
        }
        return null;
    }


    /**
     * Returns the window used for display (testing only)
     * 
     * @return window (testing only)
     */
    public Window getWindow()
    {
        return window;
    }

}
