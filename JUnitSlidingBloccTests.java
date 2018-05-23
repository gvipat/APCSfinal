import static org.junit.Assert.*;


import java.awt.Color;

import org.junit.Test;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Roshan Sevalia, Charles Huang, Gaurav Vipat
 * @version May 22, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: none
 */
public class JUnitSlidingBloccTests
{
    
    private Level levelTester = new Level();
    private Engine engineTester = levelTester.getEngine();
    private PlayerSprite playerTester = engineTester.getPlayer();
    private EnemySprite enemyTester = engineTester.getAnEnemy();
    private 

    // Game tests
    @Test
    public void gameMain()
    {
        //not sure if possible
    }


    // Level tests
    @Test
    public void levelPlay()
    {
    }


    @Test
    public void levelGetSprites()
    {
    }


    @Test
    public void levelNextLevel()
    {
    }


    @Test
    public void levelRestart()
    {
    }


    @Test
    public void levelGetLevelEndZone()
    {
    }

    @Test
    public void levelGetEngine()
    {

    }

    // Engine Tests
    Level testL = new Level();

    Engine testE = testL.getEngine();


    @Test
    public void engineRun()
    {
        assertNotNull( testE );
    }


    @Test
    public void engineManualMove()
    {
        Engine.DEBUG_MODE = true;
    }


    @Test
    public void engineRightKeyPressed()
    {
        testE.rightKeyPressed();
        assertTrue( testL.getSprites()[testL.getSprites().length - 1] );
    }


    @Test
    public void engineLeftKeyPressed()
    {
        testE.leftKeyPressed();
    }


    @Test
    public void engineUpKeyPressed()
    {
        testE.upKeyPressed();
    }


    @Test
    public void engineRightKeyReleased()
    {
        testE.upKeyReleased();
    }


    @Test
    public void engineLeftKeyReleased()
    {
        testE.leftKeyReleased();
    }


    @Test
    public void engineUpKeyReleased()
    {
    }


    @Test
    public void engineKill()
    {
    }


    @Test
    public void enginePause()
    {
    }


    @Test
    public void engineResume()
    {
    }


    // Window Tests
    @Test
    public void windowPaintComponent()
    {
    }


    @Test
    public void windowGetFrame()
    {
    }


    @Test
    public void windowSetEnabled()
    {
    }


    @Test
    public void windowSetVisible()
    {
    }


    @Test
    public void windowDispose()
    {
    }

    // GroundSprite tests
    Sprite testS = new GroundSprite( 0, 0, 0, 0 );

    Sprite testS2 = testS.copy();


    @Test
    public void groundSpriteCopy()
    {
        assertNotNull( testS2 );
        assertEquals( testS, testS2 );
    }


    // EnemySprite tests
    /**
     * Test move method
     */
    @Test
    public void enemySpriteMove()
    {
        Engine e = new Engine( new Level() );
        EnemySprite temp = new EnemySprite( 0, 0, 0, 0, Color.ORANGE );
        assertTrue( !temp.move() );
    }


    /**
     * test copy method
     */
    @Test
    public void enemySpriteCopy()
    {
        EnemySprite temp = new EnemySprite( 0, 0, 0, 0, Color.ORANGE );
        temp = (EnemySprite)temp.copy();
        assertEquals( temp.getX(), 0 );
        assertEquals( temp.getY(), 0 );
        assertEquals( temp.getWidth(), 0 );
        assertEquals( temp.getHeight(), 0 );
        assertEquals( temp.getColor(), Color.ORANGE );
    }


    /**
     * test reset method
     */
    @Test
    public void reset()
    {
    }


    // PlayerSprite Tests
    @Test
    public void movePlayerSprite()
    {
        fail("YOU ARE ANNOYING");
    }


    @Test
    public void rightKeyPressedPlayerSprite()
    {
    }


    @Test
    public void leftKeyPressedPlayerSprite()
    {
    }


    @Test
    public void upKeyPressedPlayerSprite()
    {
    }


    @Test
    public void rightKeyReleasedPlayerSprite()
    {
    }


    @Test
    public void leftKeyReleasedPlayerSprite()
    {
    }


    @Test
    public void upKeyReleasedPlayerSprite()
    {
    }


    @Test
    public void copyPlayerSprite()
    {
    }


    // Moveable Test
    @Test
    public void move()
    {
    }


    @Test
    public void getHVelocity()
    {
    }


    @Test
    public void getVVelocity()
    {
    }


    @Test
    public void setHVelocity()
    {
    }


    @Test
    public void setVVelocity()
    {
    }


    @Test
    public void addGravity()
    {
    }


    @Test
    public void checkCollision()
    {
    }


    // GameMath tests
    @SuppressWarnings("deprecation")
    @Test
    public void roundToHundredths()
    {
        assertEquals( GameMath.roundToHundredths( (float)0.000000007 ), 0.0 );
    }


    @SuppressWarnings("deprecation")
    @Test
    public void roundToTenths()
    {
        assertEquals( GameMath.roundToHundredths( (float)0.000000007 ), 0.0 );
    }


    @Test
    public void getSign()
    {
        assertEquals( -1, GameMath.getSign( -5 ) );
    }

}
