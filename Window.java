import java.awt.*;
import javax.swing.*;

public class Window extends JPanel
{        
    
    public Window(int height, int width)
    {
        super.setSize( width, height );
        super.setVisible( true );
        super.add( label );
    }
    
    public void updaeImage(Color[][] pixels)
    {
        //image.setImage( new Image() );
    }
    
    
    
}
