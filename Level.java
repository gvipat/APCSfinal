import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordUser;


/**
 * A class that represents a level. Contains the data for each level as well.
 * Initializes an engine to actually run the game.
 *
 * @author Roshan Sevalia
 * @version May 18, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: Gaurav Vipat, Charlie Huang
 */
public class Level
{
    /**
     * Contains the data for all level, each row represents one level's sprites.
     */
    private static final Sprite[][] sprites =

        {   {   new PlayerSprite( 5, 5, 20, 20, readImage("Assets\\pizzel.png") ),
                new GroundSprite( 0, 400, 100, 40, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 300, 400, 40, 40, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 400, 400, 440, 40, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 920, 170, 300, 40, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 1180, 400, 300, 40, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 1480, 360, 200, 100, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 1680, 300, 200, 160, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 1880, 240, 200, 220, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 750, 340, 60, 60, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 800, 240, 60, 160, readImage("Assets\\grass.jpg") ),
                new GroundSprite( 1180, 210, 60, 180, readImage("Assets\\grass.jpg") ),
                new EnemySprite( 710, 100, 20, 20, Color.RED, null ),
                new EnemySprite( 750, 100, 20, 20, Color.RED, null ),
                new EnemySprite( 780, 100, 20, 20, Color.RED, null )
            },
            { 
                new PlayerSprite( 200, 300, 20, 20, readImage("Assets\\pizzel.png") ),
                new GroundSprite( 0, 400, 1000, 40, "floor", readImage("Assets\\grass.jpg") ),
                new GroundSprite( 400, 280, 500, 120, "hanging 1", readImage("Assets\\grass.jpg") ),
                new EnemySprite(810, 230, 20, 20, Color.RED, null)
            },
            {
                new PlayerSprite( 5, 300, 20, 20, readImage("Assets\\pizzel.png") ),
                new GroundSprite(0, 500, 800, 100, "ground start", readImage("Assets\\grass.jpg")),
                new GroundSprite(400, 450, 145, 50, "tower base", readImage("Assets\\grass.jpg")),
                new GroundSprite(500, 100, 50, 400, "tower stand", readImage("Assets\\grass.jpg")),
                new GroundSprite(400, 300, 145, 50, "tower level 1", readImage("Assets\\grass.jpg")),
                new GroundSprite(400, 150, 145, 50, "tower level 2", readImage("Assets\\grass.jpg")),
                new EnemySprite(420, 425, 20, 20, Color.RED, "enemy twr lev 1", null),
                new EnemySprite(420, 275, 20, 20, Color.RED, "enemy twr lev 2", null),
                new EnemySprite(420, 125, 20, 20, Color.RED, "enemy twr lev 3", null),
                new GroundSprite(850, 500, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(920, 600, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(935, 550, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(990, 380, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1030, 420, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1070, 350, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1100, 500, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1180, 320, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1250, 490, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1260, 550, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1310, 505, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1365, 395, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1422, 435, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1500, 420, 10, 10, readImage("Assets\\grass.jpg")),
                new GroundSprite(1600, 550, 1800, 50, readImage("Assets\\grass.jpg")),
                new GroundSprite(1800, 450, 100, 100, readImage("Assets\\grass.jpg")),
                new GroundSprite(1900, 350, 100, 200, readImage("Assets\\grass.jpg")),
                new GroundSprite(2000, 250, 100, 300, readImage("Assets\\grass.jpg")),
                new GroundSprite(2100, 150, 100, 400, readImage("Assets\\grass.jpg"))
            }
        };

    /**
     * Represents what the current row to read when opening the level.
     */
    public static int level = 0;

    /**
     * The engine that runs the game.
     */
    private Engine engine;

    /**
     * Defines the ending mark for each level. levelEndZones[n] is the ending
     * zone for the level represented by the sprites in sprites[n]
     */
    private static final int[] levelEndZones = { 2400, 1000, 2500 };


    /**
     * Constructor (gives engine this level to reference)
     */
    public Level()
    {
        engine = new Engine( this );
    }


    /**
     * Calls the engine's run method which begins the game
     */
    public void play()
    {
        Game.updatePresence("Playing level " + (level + 1), "Trying not do die.");
        engine.run();
    }


    /**
     * Returns the sprites for the current level
     * 
     * @return an array of sprites in the current level
     */
    public Sprite[] getSprites()
    {
        Sprite[] copy = new Sprite[sprites[level].length];
        for ( int i = 0; i < sprites[level].length; i++ )
        {
            copy[i] = sprites[level][i].copy();
        }
        return copy;
    }


    /**
     * Opens the next level by making a new level. If there are no more levels,
     * show the win screen.
     */
    public void nextLevel()
    {
        level++;
        if ( level < sprites.length )
        {
            engine = new Engine( this );
            play();
        }
        else
        {
            JFrame frame = new JFrame( "You Win!" );
            JLabel label = new JLabel( "You Win!" );
            JButton button = new JButton( "Exit" );
            frame.add( label );
            frame.add( button );
            button.addActionListener( new ActionListener()
            {

                @Override
                public void actionPerformed( ActionEvent e )
                {
                    Game.exit();
                }
            } );
            frame.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
            frame.addWindowListener( new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent event)
                {
                    Game.exit();
                }
            });
            frame.setSize( 300, 200 );
            frame.setLocationRelativeTo( null );
            frame.setAlwaysOnTop( true );
            frame.setResizable( false );
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage("SlidingBloccIcon.png"));
            frame.setVisible( true );
            button.setVisible( true );
            label.setVisible( true );
        }
    }


    /**
     * Re initializes the engine and begins.
     */
    public void restart()
    {
        engine = null;
        engine = new Engine( this );
        play();
    }


    /**
     * Returns the ending mark (ending x-position) for this level
     * @return an x-value that represents the end mark
     */
    public static int getLevelEndZone()
    {
        return levelEndZones[level];
    }

    /**
     * returns the current engine
     * @return the current engine
     */
    public Engine getEngine()
    {
        return engine;
    }

    private static Image readImage(String path)
    {
        try
        {
            Image img = ImageIO.read(new File(path));
            return img;
        }
        catch (IOException ex)
        {
            System.out.println("UR FAKIN BAD");
        }
        return null;
    }
}
