import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import net.arikia.dev.drpc.*;


/**
 * The game class opens a title screen and opens the game.
 *
 * @author Roshan Sevalia
 * @version May 18, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: Gaurav Vipat, Charles Huang
 */
public class Game
{
    public static boolean DISCORD_CONNECTED = true;
    /**
     * Main method
     * 
     * @param args
     *            command line arguments (s plays the game immediatley and d
     *            runs debug)
     */
    public static void main( String[] args )
    {
        try
        {
            connectToDiscord();
        }
        catch (Exception e)
        {
            DISCORD_CONNECTED = false;
        }
        ArrayList<String> arrrgs = new ArrayList<String>(Arrays.asList(args));
        if ( arrrgs.contains( "-d" ) )
        {
            Engine.DEBUG_MODE = true;
        }
        if (arrrgs.contains("-t"))
        {
            Engine.TEXTURES_ENABLED = false;
        }
        if ( arrrgs.contains( "-s" ) )
        {
            playGame();
        }
        else
        {
            openTitleScreen();
        }
    }


    /**
     * Plays the game.
     */
    private static void playGame()
    {
        Level level = new Level();
        level.play();
    }


    /**
     * Opens the title screen which has a button to play the game.
     */
    private static void openTitleScreen()
    {
        updatePresence("Waiting at title screen.", "Player doesn't want to press play.");
        final JFrame window = new JFrame( "Sliding Blocc" );
        window.setSize( 400, 400 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JButton playButton = new JButton( "Play" );
        playButton.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                window.setEnabled( false );
                window.setVisible( false );
                playGame();
            }
        } );
        window.add( playButton );
        window.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        window.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event)
            {
                Game.exit();
            }
        });
        window.setLocationRelativeTo( null );
        window.setIconImage( Toolkit.getDefaultToolkit().getImage( "SlidingBloccIcon.png" ) );
        window.setResizable( false );
        window.setVisible( true );
    }

    private static void connectToDiscord() throws UnsatisfiedLinkError
    {
        //DiscordRPC.discordInitialize("460197024680378369", new DiscordEventHandlers() , true );
    }

    public static void updatePresence(String header, String details)
    {
        if (Game.DISCORD_CONNECTED)
        {
            DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder(header).setDetails(details).build());
        }
    }

    public static void exit()
    {
        System.out.println( "Exiting." );
        if (Game.DISCORD_CONNECTED)
        {
            DiscordRPC.discordShutdown();
        }
        System.exit(0);
    }

}