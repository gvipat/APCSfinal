//use with picture class
import java.awt.Color;


public class TestOutput
{
    public static void main( String args[] )
    {
        PictureFrame testFrame = new PictureFrame();
        Picture testPicture = new Picture( 800, 600 );
        testFrame.setPicture( testPicture );
        int i = 0;

        while ( true )
        {
            testPicture.setAllPixelsToAColor( new Color(255, 255, i) );
            testFrame.setPicture(testPicture);
            i++;
            
            try {
                Thread.sleep( 34 );
            }
            catch(Exception e) {
                
            }
        }
    }
}