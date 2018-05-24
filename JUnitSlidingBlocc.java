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

    /**
     * Used for testing Level
     */
    private Level levelTester = new Level();

    /**
     * Used for testing Engine
     */
    private Engine engineTester = levelTester.getEngine();

    /**
     * Used for testing PlayerSprite
     */
    private PlayerSprite playerTester = engineTester.getPlayer();

    /**
     * Used for testing EnemySprite
     */
    private EnemySprite enemyTester = engineTester.getAnEnemy();

    /**
     * Used for testing Window
     */
    private Window windowTester;

    // Game can't be tested


    // Level tests

    /**
     * Tests Level's play method
     */
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


    /**
     * Tests Level's getSprites method
     */
    @Test
    public void levelGetSprites()
    {
        assertNotNull( levelTester.getSprites() );
    }


    /**
     * Tests Level's nextLevel method
     */
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


    /**
     * Tests Level's restart method
     */
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


    /**
     * Tests Level's getLevelEndZone method
     */
    @Test
    public void levelGetLevelEndZone()
    {
        assertNotNull( Level.getLevelEndZone() );
    }


    /**
     * Tests Level's getEngine method
     */
    @Test
    public void levelGetEngine()
    {
        assertNotNull( levelTester.getEngine() );
    }


    // Engine Tests
    /**
     * Tests Engine's run method
     */
    @Test
    public void engineRun()
    {
        Engine.DEBUG_MODE = true;
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull( windowTester );
    }

    // manualMove can't be tested


    /**
     * Tests Engine's rightKeyPressed method
     */
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


    /**
     * Tests Engine's leftKeyPressed method
     */
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


    /**
     * Tests Engine's upKeyPressed method
     */
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


    /**
     * Tests Engine's rightKeyReleased method
     */
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


    /**
     * Tests Engine's leftKeyReleased method
     */
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


    /**
     * Tests Engine's upKeyReleased method
     */
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


    /**
     * Tests Engine's kill method
     */
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


    /**
     * Tests Engine's pause and resume methods
     */
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


    /**
     * Tests Window's getFrame method
     */
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


    /**
     * Tests Window's setEnabled method
     */
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


    /**
     * Tests Window's setVisible method
     */
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


    /**
     * Tests Window's dispose method
     */
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

    /**
     * Tests GroundSprite's copy method
     */
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

    // move cant be tested


    /**
     * Tests EnemySprite's copy method
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
     * Tests EnemySprite's reset method
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

    /**
     * Tests PlayerSprite's rightkeyPressed method
     */
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


    /**
     * Tests PlayerSprite's leftKeyPressed method
     */
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


    /**
     * Tests PlayerSprite's upKeyPressed method
     */
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


    /**
     * Tests PlayerSprite's rightKeyReleased method
     */
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


    /**
     * Tests PlayerSprite's leftKeyReleased method
     */
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


    /**
     * Tests PlayerSprite's upKeyReleased method
     */
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


    /**
     * Tests PlayerSprite's copy method
     */
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


    /**
     * Tests Moveable's getHVelocity method
     */
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


    /**
     * Tests Moveable's getVVelocity method
     */
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


    /**
     * Tests Moveable's setHVelocity method
     */
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


    /**
     * Tests Moveable's setVVelocity method
     */
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


    /**
     * Tests Moveable's addGravity method
     */
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


    /**
     * Tests Moveable's checkCollision method
     */
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
    /**
     * Tests GameMath's roundToHundreths method
     */
    @Test
    public void roundToHundredths()
    {
        assertEquals( GameMath.roundToHundredths( (float)0.0000000000000001 ), 0.0, 0.001 );
    }


    /**
     * Tests GameMath's roundToTenths method
     */
    @Test
    public void roundToTenths()
    {
        assertEquals( GameMath.roundToTenths( (float)0.0000000000000001 ), 0.0, 0.01 );
    }


    /**
     * Tests GameMath's getSign method
     */
    @Test
    public void getSign()
    {
        assertEquals( -1, GameMath.getSign( -5 ) );
    }

}
