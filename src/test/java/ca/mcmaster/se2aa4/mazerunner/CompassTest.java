package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompassTest {

    private Compass compass;

    @BeforeEach 
    void setUp() {
        compass = new Compass(Direction.N);
    }

    @Test
    void testTurnLeft() {
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