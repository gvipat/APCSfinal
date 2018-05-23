import static org.junit.Assert.*;


import java.awt.Color;

import org.junit.Test;


//PASTE THIS IN FRONT OF MANY METHODS
//levelTester = new Level();
//engineTester = levelTester.getEngine();
//playerTester = engineTester.getPlayer();
//enemyTester = engineTester.getAnEnemy();
//groundTester = engineTester.getAGround();
//engineTester.run();
//windowTester = engineTester.getWindow();

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
    private GroundSprite groundTester = engineTester.getAGround();
    private Window windowTester;

    // Game tests
    @Test
    public void gameTest()
    {
        //not sure if possible
    }


    // Level tests
    @Test
    public void levelPlay()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        levelTester.play();
        assertNotNull(engineTester);
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
        assertEquals(current + 1, Level.level);
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
    }


    @Test
    public void levelRestart()
    {
        int current = Level.level;
        Engine temp = new Engine(levelTester);
        levelTester.restart();
        assertNotEquals( temp, levelTester.getEngine() );
        assertEquals(current, Level.level);
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
    }


    @Test
    public void levelGetLevelEndZone()
    {
        assertNotNull(Level.getLevelEndZone() );//CHECK
    }

    @Test
    public void levelGetEngine()
    {
        assertNotNull(levelTester.getEngine());
    }

    // Engine Tests
    @Test
    public void engineRun()
    {
        Engine.DEBUG_MODE = true;
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull(windowTester);
    }


    @Test
    public void engineManualMove()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.manualMove();
        assertTrue(true);//FIX
    }


    @Test
    public void engineRightKeyPressed()
    {
        //testE.rightKeyPressed();
        //assertTrue( testL.getSprites()[testL.getSprites().length - 1] );
    }


    @Test
    public void engineLeftKeyPressed()
    {
        //testE.leftKeyPressed();
    }


    @Test
    public void engineUpKeyPressed()
    {
        //testE.upKeyPressed();
    }


    @Test
    public void engineRightKeyReleased()
    {
        //testE.upKeyReleased();
    }


    @Test
    public void engineLeftKeyReleased()
    {
        //testE.leftKeyReleased();
    }


    @Test
    public void engineUpKeyReleased()
    {
    }


    @Test
    public void engineKill()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.kill();
        assertFalse(windowTester.isEnabled());        
    }


    @Test
    public void enginePauseResume()
    {
        Engine.DEBUG_MODE = false;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        engineTester.pause();
        assertTrue(engineTester.paused);
        engineTester.resume();
        assertFalse(engineTester.paused);;
    }


    // Window Tests
    @Test
    public void windowPaintComponent()
    {
        //I dont think so
    }


    @Test
    public void windowGetFrame()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull(windowTester.getFrame());
    }


    @Test
    public void windowSetEnabled()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        windowTester.setEnabled(false);
        assertFalse(windowTester.isEnabled());
        windowTester.setEnabled(true);
    }


    @Test
    public void windowSetVisible()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        windowTester.setVisible(false);
        assertFalse(windowTester.isVisible());
        windowTester.setVisible(true);
    }


    @Test
    public void windowDispose()
    {
        //IDK HOW TO TEST
    }

    // GroundSprite tests

    @Test
    public void groundSpriteCopy()
    {
        Sprite temp1 = new GroundSprite(0, 0, 0, 0);
        Sprite temp2 = (GroundSprite)temp1.copy();
        assertEquals(temp1.getX(), temp2.getX());
        assertEquals(temp1.getY(), temp2.getY());
        assertEquals(temp1.getWidth(), temp2.getWidth());
        assertEquals(temp1.getHeight(), temp2.getHeight());
        assertEquals(temp1.getColor(), temp2.getColor());
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
        Sprite temp1 = new EnemySprite(0, 0, 0, 0, Color.BLUE);
        Sprite temp2 = (EnemySprite)temp1.copy();
        assertEquals(temp1.getX(), temp2.getX());
        assertEquals(temp1.getY(), temp2.getY());
        assertEquals(temp1.getWidth(), temp2.getWidth());
        assertEquals(temp1.getHeight(), temp2.getHeight());
        assertEquals(temp1.getColor(), temp2.getColor());
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
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        int x = enemyTester.getX();
        int y = enemyTester.getY();
        enemyTester.reset();
        assertEquals(x, enemyTester.getX());
        assertEquals( y, enemyTester.getY() );
    }


    // PlayerSprite Tests
    @Test
    public void movePlayerSprite()
    {
        
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
        Sprite temp1 = new PlayerSprite(0, 0, 0, 0, Color.BLUE);
        Sprite temp2 = (PlayerSprite)temp1.copy();
        assertEquals(temp1.getX(), temp2.getX());
        assertEquals(temp1.getY(), temp2.getY());
        assertEquals(temp1.getWidth(), temp2.getWidth());
        assertEquals(temp1.getHeight(), temp2.getHeight());
        assertEquals(temp1.getColor(), temp2.getColor());
    }


    // Moveable Test
    @Test
    public void move()
    {
        
    }


    @Test
    public void getHVelocity()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull(playerTester.getHVelocity());
    }


    @Test
    public void getVVelocity()
    {
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        assertNotNull(playerTester.getVVelocity());
    }


    @Test
    public void setHVelocity()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.setHVelocity(2);
        assertEquals(2.0, playerTester.getHVelocity(), 0.1);
    }


    @Test
    public void setVVelocity()
    {
        Engine.DEBUG_MODE = true;
        levelTester = new Level();
        engineTester = levelTester.getEngine();
        playerTester = engineTester.getPlayer();
        enemyTester = engineTester.getAnEnemy();
        groundTester = engineTester.getAGround();
        engineTester.run();
        windowTester = engineTester.getWindow();
        playerTester.setVVelocity(2);
        assertEquals(2.0, playerTester.getVVelocity(), 0.1);
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
