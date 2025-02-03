/**
 * File: MazeChecker.java
 * Author: Nithika Karunamoorthy
 * Description: This class is responsible for validating a user-provided path through the maze.
 * It checks if the path is valid by simulating the movement step by step based on the given input string.
 * The class uses the `Compass` for direction control and `Position` for tracking the current location.
 */
package ca.mcmaster.se2aa4.mazerunner;

public class MazeChecker implements MazeTask { 
    private Maze maze; 
    private String userPath;
    private PathFormConverter converter;

    /**
     * Constructor to initialize the MazeChecker with the maze and user-provided path.
     * The path is converted into a canonical form to ensure uniformity.
     */ 
    public MazeChecker(Maze maze, String userPath) { 
        this.maze = maze;
        this.userPath = userPath;
        this.converter = new PathFormConverter();
        this.userPath = converter.factorizedToCanonical(userPath); // Convert path to canoncial form
    }
    
     /**
     * Solve method to return a string indicating if the user's path is correct or incorrect.
     */ 
    @Override
    public String solve() { 
       return isValidPath() ? "correct path" : "incorrect path";
    }

    /**
     * Validates if the user-provided path is correct by checking it from both the west and east entries.
     */ 
    public boolean isValidPath() {
        // Check path from both directions (west to east and east to west)
        return checkPath(maze.getWestEntry(), Direction.E, maze.getEastEntry()) || 
               checkPath(maze.getEastEntry(), Direction.W, maze.getWestEntry());
    }

    /**
     * Checks if the path from the start position to the exit is valid.
     * It simulates the user's path step by step, checking each movement and direction.
     */ 
    public boolean checkPath(Position start, Direction startDirection, Position exit) {
        Position currentPosition = new Position(start.getRow(), start.getCol());
        Compass compass = new Compass(startDirection);

        for (char step : userPath.toCharArray()) { // Iterate through the user path steps
            if (step == 'F') { 
                if (!currentPosition.stepForward(compass, maze)) {
                    return false; // Invalid step (either out of bounds or into a wall)
                }
            } else if (step == 'L') { 
                compass.turnLeft();
            } else if (step == 'R') { 
                compass.turnRight();
            } else {
                return false; // Invalid step (anything other than 'F', 'L', or 'R')
            }
        }

        return currentPosition.equals(exit); // Check if final position is at the exit 
    }
}
