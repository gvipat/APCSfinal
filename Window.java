import java.awt.*;
import java.util.PriorityQueue;
import javax.swing.*;

public class Window extends JPanel
{        
    private PriorityQueue<Sprite> sprites;
    private JFrame frame;

    public Window(int height, int width, PriorityQueue<Sprite> sprites)
    {
        frame = new JFrame("Level " + (Level.level + 1));
        frame.add(this);
        frame.setSize( width + 16, height + 38 );
        frame.setVisible(true);
        System.out.println( super.getSize().toString() );
        this.sprites = sprites;
        super.setSize( width, height );
        super.setBackground(Color.BLACK);
        super.setVisible( true );
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Sprite s : sprites)
        {
            g.setColor(s.getColor());
            g.drawRect(s.getX() - Engine.camera, s.getY() - Engine.camera,
                s.getWidth(), s.getHeight());
        }
    }
    
    
    
}
