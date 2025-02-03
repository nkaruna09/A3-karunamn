package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver extends MazeRunner {
    private StringBuilder path; // Path tracker
    private Position currentPosition; // Current position
    private Position exit; // Exit position
    private Compass compass; // Compass for direction
    private PathFormConverter converter; // Path converter

    public MazeSolver(Maze maze) {
        super(maze);
        this.path = new StringBuilder(); // Initialize path
        this.currentPosition = maze.getWestEntry(); // Set starting position
        this.exit = maze.getEastEntry(); // Set exit position
        this.compass = new Compass(Direction.E); // Start facing East
        this.converter = new PathFormConverter(); // Initialize path converter
    }

    @Override
    public String solve() {
        RightHandAlgorithm algorithm = new RightHandAlgorithm();
        algorithm.solveMaze(this); // Solve maze
        return converter.canonicalToFactorized(path.toString()); // Return path taken
    }

    public StringBuilder getPath() {
        return path;
    }

    public boolean reachedExit() {
        return currentPosition.equals(exit);
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public boolean stepForward() {
        if (currentPosition.stepForward(compass, maze)) {
            currentPosition = new Position(currentPosition.getRow(), currentPosition.getCol()); // Update position
            return true;
        }
        return false;
    }

    public Compass getCompass() {
        return compass;
    }
}