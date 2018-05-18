import java.awt.event.*;

import javax.swing.*;

/**
 *  The game class opens a title screen and opens the game.
 *
 *  @author  Roshan Sevalia
 *  @version May 18, 2018
 *  @author  Period: 4
 *  @author  Assignment: APCSfinal
 *
 *  @author  Sources: Gaurav Vipat, Charlie Huang
 */
public class Game
{
    /**
     * Main method
     * @param args command line arguments (any argument causes the game to skip the title screen)
     */
    public static void main( String[] args )
    {
        if (args.length > 0)
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
        final JFrame window = new JFrame("Super Cool Game");
        window.setSize( 400, 400 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                window.setEnabled(false);
                window.setVisible(false);
                playGame();
            }
        });
        window.add( playButton );
        window.setVisible( true );
    }

}