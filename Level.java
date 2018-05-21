import java.awt.Color;
import java.awt.Image;
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
    private static final Sprite[][] sprites =


                    { { new PlayerSprite( 5, 5, 20, 20, Color.BLUE ),
                        new GroundSprite( 0, 400, 1000, 40),
                        new GroundSprite( 300, 240, 2000, 40 ),
                        new GroundSprite( 400, 360, 2000, 40 ),
                        //new GroundSprite(300, 180, 20, 20),
                        new PacingEnemySprite(1500, 100, 20, 20, Color.ORANGE, 50),
                        new EnemySprite(1200, 100, 20, 20, Color.RED),
                        new EnemySprite(1300, 100, 20, 20, Color.RED),
                        new EnemySprite(1400, 100, 20, 20, Color.RED),
                        new EnemySprite(1600, 100, 20, 20, Color.RED),
                        new EnemySprite(1700, 100, 20, 20, Color.RED) },
                        { new PlayerSprite( 200, 300, 20, 20, Color.ORANGE, "player" ),
                        new GroundSprite(0, 400, 1000, 40, "floor"),
                        new GroundSprite(400, 280, 500, 120, "hanging 1") }};

    /**
     * Represents what the current row to read when opening the level.
     */
    public static int level = 0;

    /**
     * The engine that runs the game.
     */
    private Engine engine;

    private static final int[] levelEndZones = {2400, 1000};


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
     * Opens the next level by making a new level. If there are no more levels, show the win screen.
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
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setAlwaysOnTop(true);
            frame.setResizable(false);
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

    public static int getLevelEndZone()
    {
        return levelEndZones[level];
    }

    // public static Image readImage(String path)
    // {
    //     Image img;
    //     try 
    //     {
    //         img = ImageIO.read(new File(path));
    //         return img;
    //     }
    //     catch (IOException e)
    //     {
	// 		e.printStackTrace();
	// 	}
    //     return null;
    // }
}
