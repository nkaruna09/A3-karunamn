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
