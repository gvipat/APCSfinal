import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;


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
    private static final Sprite[][] sprites = //found glitch: if fall down the wall 2 and hold left, it acts as if it lands on the ground tho mid air

                    { { new PlayerSprite( 5, 5, 20, 20, Color.BLUE ),
                        new GroundSprite( 0, 400, 100, 40 ),//floor1
                        new GroundSprite( 300, 400, 30, 40 ),//hanging floor
                        new GroundSprite( 400, 400, 450, 40 ),//floor2
                        new GroundSprite( 920, 170, 300, 40 ),//floor3
                        new GroundSprite( 1180, 400, 300, 40 ),//floor4
                        new GroundSprite( 1480, 360, 200, 100 ),//floor5
                        new GroundSprite( 1680, 300, 200, 160 ),//floor6
                        new GroundSprite( 1880, 240, 200, 220 ),//floor7
                        //new GroundSprite( 100, 360, 50, 40 ),//wall 1
                        new GroundSprite( 750, 340, 50, 60 ),//step
                        new GroundSprite( 800, 240, 50, 160 ),//wall 2
                        new GroundSprite( 1180, 210, 40, 190 ),//wall 3
                        //new GroundSprite( 550, 400, 500, 40 ),
                        new EnemySprite( 710, 100, 20, 20, Color.RED ),
                        new EnemySprite( 750, 100, 20, 20, Color.RED ),
                        new EnemySprite( 780, 100, 20, 20, Color.RED ),
                        // new GroundSprite(300, 180, 20, 20),
                        //new PacingEnemySprite( 1500, 100, 20, 20, Color.ORANGE, 50 ),
                        
                        //new EnemySprite( 1300, 100, 20, 20, Color.RED ),
                        //new EnemySprite( 1400, 100, 20, 20, Color.RED ),
                        //new EnemySprite( 1600, 100, 20, 20, Color.RED ),
                        /*new EnemySprite( 1700, 100, 20, 20, Color.RED )*/ },
                        { new PlayerSprite( 200, 300, 20, 20, Color.ORANGE, "player" ),
                            new GroundSprite( 0, 400, 1000, 40, "floor" ),
                            new GroundSprite( 400, 280, 500, 120, "hanging 1" ) } };

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
    private static final int[] levelEndZones = { 2400, 1000 };


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
                    System.exit( 0 );
                }
            } );
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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
}
