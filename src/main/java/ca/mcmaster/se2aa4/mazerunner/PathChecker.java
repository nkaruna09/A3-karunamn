package ca.mcmaster.se2aa4.mazerunner; 
/**
 * The PathChecker class validates a user-provided path through the maze.
 * It uses the Maze and Compass classes to determine if the path is valid
 * based on the maze's structure and the rules for navigating through it.
 */
public class PathChecker { 
    private Maze maze;
    
    public PathChecker(Maze maze) { // Constructor
        this.maze = maze; 
    }

    public boolean isValidPath(String userPath) { 
        return checkPath(maze.getWestEntry(), Direction.E, userPath) || checkPath(maze.getEastEntry(), Direction.W, userPath);
    }

    public boolean checkPath(Position startPosition, Direction startDirection, String userPath) {
        Position currentPosition = startPosition; 
        Compass compass = new Compass(startDirection); 

        // Iterate through the user path steps
        for (char step : userPath.toCharArray()) {
            // Handle each step in the path
            if (step == 'F') { // Step forward
                if (!currentPosition.stepForward(compass, maze)) {
                    return false; // Invalid step (either out of bounds or into a wall)
                }
            } else if (step == 'L') { // Turn left
                compass.turnLeft();
            } else if (step == 'R') { // Turn right
                compass.turnRight();
            } else {
                return false; // Invalid step (anything other than 'F', 'L', or 'R')
            }
        }

        // If we finish the path with no issues, the path is valid
        return true;
    }

} 