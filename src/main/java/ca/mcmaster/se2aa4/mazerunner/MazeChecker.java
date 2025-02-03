package ca.mcmaster.se2aa4.mazerunner;

public class MazeChecker implements MazeTask { 
    private Maze maze; 
    private String userPath;
    private PathFormConverter converter;

    public MazeChecker(Maze maze, String userPath) { 
        this.maze = maze;
        this.userPath = userPath;
        this.converter = new PathFormConverter();
        this.userPath = converter.factorizedToCanonical(userPath);
    }

    @Override
    public String solve() { 
       return isValidPath() ? "correct path" : "incorrect path";
    }

    public boolean isValidPath() {
        // Check path from both sides
        return checkPath(maze.getWestEntry(), Direction.E, maze.getEastEntry()) || 
               checkPath(maze.getEastEntry(), Direction.W, maze.getWestEntry());
    }

    public boolean checkPath(Position start, Direction startDirection, Position exit) {
        Position currentPosition = new Position(start.getRow(), start.getCol());
        Compass compass = new Compass(startDirection);
        userPath = this.userPath;

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
        return currentPosition.equals(exit); 
    }
}
