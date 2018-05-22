import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroundSpriteTest {

	Sprite testS = new Sprite();
	SPtire testS2 = testS.copy();

    @Test
    void copy() {
	    assertNotNull(testS2);
	    assertEqual(testS, testS2);
    }
}
