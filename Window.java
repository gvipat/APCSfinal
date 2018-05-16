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
        super.setBackground(Color.WHITE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.addKeyListener(new upKeyListener());
        frame.addKeyListener(new leftKeyListener());
        frame.addKeyListener(new rightKeyListener());
        super.setVisible( true );
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(getSize().toString());
        System.out.println( super.getSize().toString() );
        this.sprites = sprites;
        this.engine = engine;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Sprite s : sprites)
        {
            g.setColor(s.getColor());
            g.fillRect(s.getX() - Engine.camera, s.getY(),
                s.getWidth(), s.getHeight());
        }
    }

    public JFrame getFrame() {return frame;}
    
    
    private class upKeyListener implements KeyListener
    {
        public void keyTyped(KeyEvent e){}

        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                engine.upKeyPressed();
            }
            //System.out.println(e.getKeyCode());
        }

        public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                engine.upKeyReleased();
            }
        }
    }

    private class leftKeyListener implements KeyListener
    {
        public void keyTyped(KeyEvent e){}

        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                engine.leftKeyPressed();
            }
            //System.out.println(e.getKeyCode());
        }

        public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                engine.leftKeyReleased();
            }
        }
    }

    private class rightKeyListener implements KeyListener
    {
        public void keyTyped(KeyEvent e){}

        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                engine.rightKeyPressed();
            }
            //System.out.println(e.getKeyCode());
        }

        public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                engine.rightKeyReleased();
            }
        }
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        frame.setEnabled(enabled);
    }

    @Override
    public void setVisible(boolean visible)
    {
        super.setVisible(visible);
        frame.setVisible(false);
    }

    public void dispose()
    {
        frame.dispose();
    }



}
