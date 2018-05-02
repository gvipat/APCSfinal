import java.awt.*;
import java.awt.event.*;
import java.util.PriorityQueue;
import javax.swing.*;

public class Window extends JPanel
{        
    private PriorityQueue<Sprite> sprites;
    private JFrame frame;
    private Engine engine;

    public Window(int height, int width, PriorityQueue<Sprite> sprites, Engine engine)
    {
        frame = new JFrame("Level " + (Level.level + 1));
        this.setPreferredSize(new Dimension(width, height));
        super.setBackground(Color.BLACK);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        super.addKeyListener(new KeyboardInputListener());
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
    
    
    private class KeyboardInputListener implements KeyListener
    {
        public void keyTyped(KeyEvent e)
        {

        }

        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_RIGHT:
                    engine.rightKeyPressed();
                    break;
                case KeyEvent.VK_LEFT:
                    engine.leftKeyPressed();
                    break;
                case KeyEvent.VK_UP:
                    engine.upKeyPressed();
                    break;
            }
        }

        public void keyReleased(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_RIGHT:
                    engine.rightKeyReleased();
                    break;
                case KeyEvent.VK_LEFT:
                    engine.leftKeyReleased();
                    break;
                case KeyEvent.VK_UP:
                    engine.upKeyReleased();
                    break;
            }
        }
    }

}
