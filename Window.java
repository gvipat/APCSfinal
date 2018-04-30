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
        this.setPreferredSize(new Dimension(width, height));
        super.setBackground(Color.BLACK);
        frame.add(this);
        frame.pack();
        super.setVisible( true );
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(getSize().toString());
        System.out.println( super.getSize().toString() );
        this.sprites = sprites;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // for (Sprite s : sprites)
        // {
        //     g.setColor(s.getColor());
        //     g.drawRect(s.getX() - Engine.camera, s.getY() - Engine.camera,
        //         s.getWidth(), s.getHeight());
        // }
    }
    
    
    
}
