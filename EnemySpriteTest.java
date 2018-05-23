import org.junit.*;

import static org.junit.Assert.*;

import java.awt.Color;


/**
 * JUnit tests for EnemySprite
 *
 * @author
 * @version May 22, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: None
 */
public class EnemySpriteTest
{

    /**
     * Test move method
     */
    @Test
    public void move()
    {
        Engine e = new Engine(new Level());
        EnemySprite temp = new EnemySprite(0,0, 0, 0, Color.ORANGE);
        assertTrue(!temp.move());
    }


    /**
     * test copy method
     */
    @Test
    public void copy()
    {
        EnemySprite temp = new EnemySprite(0,0, 0, 0, Color.ORANGE);
        temp = (EnemySprite)temp.copy();
        assertEquals(temp.getX(), 0);
        assertEquals(temp.getY(), 0);
        assertEquals(temp.getWidth(), 0);
        assertEquals(temp.getHeight(), 0);
        assertEquals(temp.getColor(), Color.ORANGE);
    }


    /**
     * test reset method
     */
    @Test
    public void reset()
    {
    }
}