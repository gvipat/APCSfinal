import static org.junit.Assert.*;

import org.junit.*;


public class JUGame
{
    // Level Tests

    private Level level;
    
    @Test
    public void levelConstructor()
    {
        level = new Level();
        assertNotNull( level );
    }


    @Test
    public void levelContructorParameter()
    {
        level = new Level( level );
        assertNotNull( level );
    }


    @Test
    public void levelPlayTest()
    {

    }


    @Test
    public void levelGetSpritesTest()
    {
        assertNotNull(level.getSprites());
    }
    
    @Test
    public void levelNextLevel()
    {
        int current = Level.level;
        level.nextLevel();
        assertTrue(Level.level == current + 1);
    }
    
    
    //Engine Tests
    
    private Engine engine;
    
    @Test
    public void engineContructor()
    {
        engine = new Engine(level);
        assertNotNull(engine);
    }
    
    @Test
    public void engineRunTest()
    {
        engine.run();
    }
}