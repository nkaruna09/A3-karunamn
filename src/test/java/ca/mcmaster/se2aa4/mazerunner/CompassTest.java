// CompassTest.java
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompassTest {

    @Test
    void testInitialDirection() {
        Compass compass = new Compass(Direction.N);
        assertTrue(compass.isPointing(Direction.N));
        assertEquals(Direction.N, compass.getDirection());
    }

    @Test
    void testTurnLeft() {
        Compass compass = new Compass(Direction.N);
        compass.turnLeft();
        assertTrue(compass.isPointing(Direction.W));
        compass.turnLeft();
        assertTrue(compass.isPointing(Direction.S));
        compass.turnLeft();
        assertTrue(compass.isPointing(Direction.E));
        compass.turnLeft();
        assertTrue(compass.isPointing(Direction.N));
    }

    @Test
    void testTurnRight() {
        Compass compass = new Compass(Direction.N);
        compass.turnRight();
        assertTrue(compass.isPointing(Direction.E));
        compass.turnRight();
        assertTrue(compass.isPointing(Direction.S));
        compass.turnRight();
        assertTrue(compass.isPointing(Direction.W));
        compass.turnRight();
        assertTrue(compass.isPointing(Direction.N));
    }
}