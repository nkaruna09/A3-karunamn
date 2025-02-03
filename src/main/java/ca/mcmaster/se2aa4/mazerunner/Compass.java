package ca.mcmaster.se2aa4.mazerunner;

/**
 * The Compass class represents a compass that maintains its current direction
 * and provides methods to check and change the direction by turning left or right.
 */
public class Compass {

    private Direction direction; 

    public Compass(Direction start) { // Constructor
        this.direction = start; 
    }

    /**
     * Checks if the compass is pointing in a specific direction.
     * 
     * @param dir the direction to check against.
     * @return true if the compass is pointing in the given direction, false otherwise.
     */
    public boolean isPointing(Direction dir) {
       return this.direction == dir; 
    }

    
    /** 
     * Turns the compass 90 degrees to the left (counterclockwise).
     */
    public void turnLeft() {
        if (this.direction == Direction.N) {
            this.direction = Direction.W;
        } else if (this.direction == Direction.W) {
            this.direction = Direction.S;
        } else if (this.direction == Direction.S) {
            this.direction = Direction.E;
        } else {
            this.direction = Direction.N;
        }
    }

    /**
     * Turns the compass 90 degrees to the right (clockwise).
     */
    public void turnRight() {
        if (this.direction == Direction.N) {
            this.direction = Direction.E;
        } else if (this.direction == Direction.E) {
            this.direction = Direction.S;
        } else if (this.direction == Direction.S) {
            this.direction = Direction.W;
        } else {
            this.direction = Direction.N;
        }
    }

    public Direction getDirection() {
        return this.direction;
    }

}
