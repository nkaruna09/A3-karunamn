package ca.mcmaster.se2aa4.mazerunner;

import java.util.Map;

/**
 * The Compass class represents a compass that maintains its current direction
 * and provides methods to check and change the direction by turning left or right.
 */
public class Compass {

    private Direction direction; 

    private static final Map<Direction, Direction> LEFT_TURN = Map.of(
        Direction.N, Direction.W,
        Direction.W, Direction.S,
        Direction.S, Direction.E,
        Direction.E, Direction.N
    );

    private static final Map<Direction, Direction> RIGHT_TURN = Map.of(
        Direction.N, Direction.E,
        Direction.E, Direction.S,
        Direction.S, Direction.W,
        Direction.W, Direction.N
    );

    public Compass(Direction initialDirection) { // Constructor
        this.direction = initialDirection; 
    }

    public boolean isPointing(Direction dir) {
       return this.direction == dir; 
    }

    /**
     * Turns the compass 90 degrees to the left (counterclockwise).
     */
    public void turnLeft() {
        direction = LEFT_TURN.get(direction);
    }

    /**
     * Turns the compass 90 degrees to the right (clockwise).
     */
    public void turnRight() {
        direction = RIGHT_TURN.get(direction);
    }

    public Direction getDirection() {
        return this.direction;
    }

}
