/**
 * File: RightHandAlgorithm.java
 * Author: Nithika Karunamoorthy
 * Description: This class implements the right-hand maze-solving algorithm. 
 * The algorithm follows the "right-hand rule" where the solver always keeps 
 * its right hand against the wall and follows the path accordingly.
 */
package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Algorithm {

    /**
     * Solves the maze using the right-hand rule.
     */ 
    @Override
    public String solveMaze (Maze maze, Position start, Position exit) { 
        StringBuilder path = new StringBuilder(); 
        Position currentPosition = new Position(start.getRow(), start.getCol()); // Initialize current position to start
        Compass compass = new Compass(Direction.E); // Start by facing East

        while (!currentPosition.equals(exit)) { // Continue until current position reaches the exit
            // Try turning right first and moving forward
            compass.turnRight();
            if (currentPosition.stepForward(compass, maze)) {
                path.append("R").append("F");
                continue;
            }

            // If we can't move forward, undo the right turn and try to move forward
            compass.turnLeft(); // Undo the right turn
            if (currentPosition.stepForward(compass, maze)) {
                path.append("F");
                continue;
            }

            // If moving forward isn't possible, turn left and move forward
            compass.turnLeft();
            if (currentPosition.stepForward(compass, maze)) {
                path.append("L").append("F");
                continue;
            }

            // If all else fails, turn around and move forward
            compass.turnLeft();
            if (currentPosition.stepForward(compass, maze)) {
                path.append("L").append("L").append("F");
                continue;
            }
        }

        return path.toString();
    }

}
