package ca.mcmaster.se2aa4.mazerunner;

/**
 * The Compass class represents a compass that maintains its current direction
 * and provides methods to check and change the direction by turning left or right.
 */
public class Compass {

    // The current direction the compass is pointing ("N", "S", "E", "W").
    private String direction; 

    public Compass() { // Constructor
        this.direction = "E"; 
    }

    /**
     * Checks if the compass is pointing North.
     * 
     * @return true if the compass is pointing North, false otherwise.
     */
    public boolean isPointingNorth() {
       return direction.equals("N");
    }

    /**
     * Checks if the compass is pointing South.
     * 
     * @return true if the compass is pointing South, false otherwise.
     */
    public boolean isPointingSouth() {
        return direction.equals("S");
    }

    /**
     * Checks if the compass is pointing East.
     * 
     * @return true if the compass is pointing East, false otherwise.
     */
    public boolean isPointingEast() {
        return direction.equals("E");
    }  

    /**
     * Checks if the compass is pointing West.
     * 
     * @return true if the compass is pointing West, false otherwise.
     */
    public boolean isPointingWest() {
        return direction.equals("W");
    }

    /**
     * Turns the compass 90 degrees to the left (counterclockwise).
     * Updates the direction accordingly:
     * - "N" -> "W"
     * - "W" -> "S"
     * - "S" -> "E"
     * - "E" -> "N"
     */
    public void turnLeft() {
        if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "E";
        } else { // direction is "E"
            direction = "N";
        }
    }

    /**
     * Turns the compass 90 degrees to the right (clockwise).
     * Updates the direction accordingly:
     * - "N" -> "E"
     * - "E" -> "S"
     * - "S" -> "W"
     * - "W" -> "N"
     */
    public void turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("E")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "W";
        } else { // direction is "W"
            direction = "N";
        }
    }

    /**
     * Returns a string representation of the compass, including its current direction.
     * 
     * @return a string indicating the direction the compass is pointing.
     */
    @Override
    public String toString() {
        return "Compass is pointing " + direction;
    }
}
