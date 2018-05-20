import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
    private final Sprite[][] sprites =


                    { /*{ new PlayerSprite( 5, 5, 20, 20, Color.BLUE ),
                        new GroundSprite( 0, 400, 1000, 40 ),
                        new GroundSprite( 300, 200, 1000, 40 ),
                        new GroundSprite( 400, 360, 1000, 40 ),
                        new EnemySprite(500, 100, 20, 20, Color.RED) },*/
                        { new PlayerSprite( 5, 5, 20, 20, Color.ORANGE ),
                        new GroundSprite(0, 400, 1000, 40),
                        new GroundSprite(400, 320, 100, 40) } };

    /**
     * Represents what the current row to read when opening the level.
     */
    public static int level = 0;

    /**
     * The engine that runs the game.
     */
    private Engine engine;


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
}
