import java.awt.*;
import java.util.PriorityQueue;
import javax.swing.*;

public class Window extends JPanel
{        
    private PriorityQueue<Sprite> sprites;

    public Window(int height, int width, PriorityQueue<Sprite> sprites)
    {
        this.sprites = sprites;
        super.setSize( width, height );
        super.setBackground(Color.WHITE);
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
