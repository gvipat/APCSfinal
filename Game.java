import java.awt.event.*;

import javax.swing.*;

public class Game
{
    public static void main( String[] args )
    {
        openTitleScreen();                
    }
    
    private static void playGame()
    {
        Level level = new Level();
        level.play();
    }
    
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
               playGame();
            }
        });
        window.add( playButton );
        
        
        
        window.setVisible( true );
    }

}