import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMathTest {

    @Test
    void roundToHundredths() {
	    assertEquals(GameMath.roundToHundredths(0.000000007), 0.0)
    }

    @Test
    void roundToTenths() {
	assertEquals(GameMath.roundToHundredths(0.000000007), 0.0)
    }

    @Test
    void getSign() {
	    assertEquals(-1, GameMath.getSign(-5));
    }
}
