import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


/**
 * Runs unit tests on all public methods that can be tested in the various
 * classes
 *
 * @author Roshan Sevalia, Charles Huang, Gaurav Vipat
 * @version May 22, 2018
 * @author Period: 4
 * @author Assignment: APCSfinal
 *
 * @author Sources: none
 */
public class JUnitSlidingBlocc
{

    private Level levelTester = new Level();

    private Engine engineTester = levelTester.getEngine();

    private PlayerSprite playerTester = engineTester.getPlayer();

    private EnemySprite enemyTester = engineTester.getAnEnemy();

    private Window windowTester;

    // Game can't be tested


    // Level tests
    @Test
    public void levelPlay()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        levelTester.play();
        assertNotNull( engineTester );
    }


    @Test
    public void levelGetSprites()
    {
        assertNotNull( levelTester.getSprites() );
    }


    @Test
    public void levelNextLevel()
    {
        int current = Level.level;
        levelTester.nextLevel();
        assertEquals( current + 1, Level.level );
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
    }


    @Test
    public void levelRestart()
    {
        int current = Level.level;
        Engine temp = new Engine( levelTester );
        levelTester.restart();
        assertNotEquals( temp, levelTester.getEngine() );
        assertEquals( current, Level.level );
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
    }


    @Test
    public void levelGetLevelEndZone()
    {
        assertNotNull( Level.getLevelEndZone() );
    }


    @Test
    public void levelGetEngine()
    {
        assertNotNull( levelTester.getEngine() );
    }


    // Engine Tests
    @Test
    public void engineRun()
    {
        Engine.DEBUG_MODE = true;
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull( windowTester );
    }

    // manualMove can't be tested


    @Test
    public void engineRightKeyPressed()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.rightKeyPressed();
        assertTrue( playerTester.getRightKeyPressed() );
    }


    @Test
    public void engineLeftKeyPressed()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.leftKeyPressed();
        assertTrue( playerTester.getLeftKeyPressed() );
    }


    @Test
    public void engineUpKeyPressed()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.upKeyPressed();
        assertTrue( playerTester.getUpKeyPressed() );
    }


    @Test
    public void engineRightKeyReleased()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.rightKeyReleased();
        assertFalse( playerTester.getRightKeyPressed() );
    }


    @Test
    public void engineLeftKeyReleased()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.leftKeyReleased();
        assertFalse( playerTester.getLeftKeyPressed() );
    }


    @Test
    public void engineUpKeyReleased()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.upKeyReleased();
        assertFalse( playerTester.getUpKeyPressed() );
    }


    @Test
    public void engineKill()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.kill();
        assertFalse( windowTester.isEnabled() );
    }


    @Test
    public void enginePauseResume()
    {
        Engine.DEBUG_MODE = false;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.pause();
        assertTrue( engineTester.paused );
        engineTester.resume();
        assertFalse( engineTester.paused );
        ;
    }

    // Window Tests

    // paintComponent can't be tested.


    @Test
    public void windowGetFrame()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull( windowTester.getFrame() );
    }


    @Test
    public void windowSetEnabled()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        windowTester.setEnabled( false );
        assertFalse( windowTester.isEnabled() );
    }


    @Test
    public void windowSetVisible()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        windowTester.setVisible( false );
        assertFalse( windowTester.isVisible() );
    }


    @Test
    public void windowDispose()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        windowTester.dispose();
        assertFalse( windowTester.getFrame().isVisible() );
    }


    // GroundSprite tests

    @Test
    public void groundSpriteCopy()
    {
        Sprite temp1 = new GroundSprite( 0, 0, 0, 0 );
        Sprite temp2 = temp1.copy();
        assertEquals( temp1.getX(), temp2.getX() );
        assertEquals( temp1.getY(), temp2.getY() );
        assertEquals( temp1.getWidth(), temp2.getWidth() );
        assertEquals( temp1.getHeight(), temp2.getHeight() );
        assertEquals( temp1.getColor(), temp2.getColor() );
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
        Sprite temp1 = new EnemySprite( 0, 0, 0, 0, Color.BLUE );
        Sprite temp2 = temp1.copy();
        assertEquals( temp1.getX(), temp2.getX() );
        assertEquals( temp1.getY(), temp2.getY() );
        assertEquals( temp1.getWidth(), temp2.getWidth() );
        assertEquals( temp1.getHeight(), temp2.getHeight() );
        assertEquals( temp1.getColor(), temp2.getColor() );
    }


    /**
     * test reset method
     */
    @Test
    public void reset()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        int x = enemyTester.getX();
        int y = enemyTester.getY();
        enemyTester.reset();
        assertEquals( x, enemyTester.getX() );
        assertEquals( y, enemyTester.getY() );
    }


    // PlayerSprite Tests

    @Test
    public void rightKeyPressedPlayerSprite()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.rightKeyPressed();
        assertTrue( playerTester.getRightKeyPressed() );
    }


    @Test
    public void leftKeyPressedPlayerSprite()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.leftKeyPressed();
        assertTrue( playerTester.getLeftKeyPressed() );
    }


    @Test
    public void upKeyPressedPlayerSprite()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.upKeyPressed();
        assertTrue( playerTester.getUpKeyPressed() );
    }


    @Test
    public void rightKeyReleasedPlayerSprite()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.rightKeyReleased();
        assertFalse( playerTester.getRightKeyPressed() );
    }


    @Test
    public void leftKeyReleasedPlayerSprite()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.leftKeyReleased();
        assertFalse( playerTester.getLeftKeyPressed() );
    }


    @Test
    public void upKeyReleasedPlayerSprite()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.upKeyReleased();
        assertFalse( playerTester.getUpKeyPressed() );
    }


    @Test
    public void copyPlayerSprite()
    {
        Sprite temp1 = new PlayerSprite( 0, 0, 0, 0, Color.BLUE );
        Sprite temp2 = temp1.copy();
        assertEquals( temp1.getX(), temp2.getX() );
        assertEquals( temp1.getY(), temp2.getY() );
        assertEquals( temp1.getWidth(), temp2.getWidth() );
        assertEquals( temp1.getHeight(), temp2.getHeight() );
        assertEquals( temp1.getColor(), temp2.getColor() );
    }

    // Moveable Test

    // move can't be tested


    @Test
    public void getHVelocity()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull( playerTester.getHVelocity() );
    }


    @Test
    public void getVVelocity()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull( playerTester.getVVelocity() );
    }


    @Test
    public void setHVelocity()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.setHVelocity( 2 );
        assertEquals( 2.0, playerTester.getHVelocity(), 0.1 );
    }


    @Test
    public void setVVelocity()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.setVVelocity( 2 );
        assertEquals( 2.0, playerTester.getVVelocity(), 0.1 );
    }


    @Test
    public void addGravity()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        float prev = playerTester.getVVelocity();
        playerTester.addGravity();
        assertTrue( prev < playerTester.getVVelocity() );
    }


    @Test
    public void checkCollision()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull( playerTester.checkCollision() );
    }


    // GameMath tests
    @Test
    public void roundToHundredths()
    {
        assertEquals( GameMath.roundToHundredths( (float)0.0000000000000001 ), 0.0, 0.001 );
    }


    @Test
    public void roundToTenths()
    {
        assertEquals( GameMath.roundToTenths( (float)0.0000000000000001 ), 0.0, 0.01 );
    }


    @Test
    public void getSign()
    {
        assertEquals( -1, GameMath.getSign( -5 ) );
    }

}
