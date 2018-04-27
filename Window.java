import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame
{    
    private ImageIcon image = new ImageIcon();
    
    private JLabel label = new JLabel(image);
    
    public Window(int height, int width)
    {
        super.setSize( width, height );
        super.setTitle( "Level " + Level.level );
        super.setVisible( true );
        super.add( label );
    }
    
    public void updateImage(Color[][] pixels)
    {
        //image.setImage( new Image() );
    }
    
    
    
}
