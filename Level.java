import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;

public class Level
{
    private final Sprite[][] sprites = 


{{new PlayerSprite(5, 5, 20, 20, Color.BLUE), new GroundSprite(0, 400, 1000, 40), new GroundSprite(300, 200,  1000,  40), new GroundSprite(200, 360, 1000, 40)},
 {new PlayerSprite(5, 5, 20, 20, Color.ORANGE)}};
    
    
    public static int level = 0;
    private Engine engine;
    
    public Level()
    {
        engine = new Engine(this);
    }
    
    
    public void play()
    {
        engine.run();
    }

    public Sprite[] getSprites()
    {
        Sprite[] copy = new Sprite[sprites[level].length];
        for (int i = 0; i < sprites[level].length; i++)
        {
            copy[i] = sprites[level][i].copy();
        }
        return copy;
    }
    
    public void nextLevel()
    {
        level++;
        if (level < sprites.length)
        {
            engine = new Engine(this);
            play();
        }
        else
        {
            JFrame frame = new JFrame("You Win!");
            JLabel label = new JLabel("You Win!");
            JButton button = new JButton("Exit");
            frame.add(label);
            frame.add(button);
            button.addActionListener(new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            frame.setVisible(true);
            button.setVisible(true);
            label.setVisible(true);
        }
    }

    public void restart()
    {
        engine = null;
        engine = new Engine(this);
        play();
    }
}
