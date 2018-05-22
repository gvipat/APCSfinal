import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    Level testL = new Level();
    Engine testE = testL.getEngine();

    @Test
    void run() {
        assertNotNull(testE);
    }

    @Test
    void manualMove() {
        Engine.DEBUG_MODE = true;
    }

    @Test
    void rightKeyPressed() {
        testE.rightKeyPressed();
        //assertTrue(testL.getSprites()[testL.getSprites().length - 1]);
    }

    @Test
    void leftKeyPressed() {
        testE.leftKeyPressed();
    }

    @Test
    void upKeyPressed() {
        testE.upKeyPressed();
    }

    @Test
    void rightKeyReleased(){
        testE.upKeyReleased();
    }

    @Test
    void leftKeyReleased() {
        testE.leftKeyReleased();
    }

    @Test
    void upKeyReleased() {
    }

    @Test
    void kill() {
    }

    @Test
    void pause() {
    }

    @Test
    void resume() {
    }

    @Test
    void getEngine(){
        assertNotNull(testL.getEngine());
    }
}