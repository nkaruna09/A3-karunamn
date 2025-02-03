/**
 * File: Compass.java
 * Author: Nithika Karunamoorthy
 * Description: The Compass class represents a compass that maintains its current direction
 * and provides methods to check and change the direction by turning left or right.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.util.Map;

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
    
     /**
     * Constructor to initialize the compass with an initial direction.
     */
    public Compass(Direction initialDirection) { 
        this.direction = initialDirection; 
    }

    /**
     * Checks if the compass is currently pointing in the specified direction.
     */
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

    /**
     * Returns the current direction the compass is pointing.
     */
    public Direction getDirection() {
        return this.direction;
    }

}
