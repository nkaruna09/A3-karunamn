package ca.mcmaster.se2aa4.mazerunner;

/**
 * The MazeRunner class handles the logic for navigating through a maze.
 * It uses a Compass for direction, tracks the current position,
 * and records the path taken to solve the maze.
 */

public class MazeRunner {
    private Maze maze;
    private Compass compass; 
    private Position currentPosition;
    private Position exit;
    private String path;

    public MazeRunner(Maze maze) {
        this.maze = maze; 
        this.currentPosition = maze.getWestEntry();
        this.exit = maze.getEastEntry();
        this.compass = new Compass();
        this.path = "";
    }
    
    /**
     * Moves the MazeRunner one step forward in the current direction if possible.
     *
     * @return "F" to indicate a forward step.
     */
    public String stepForward() {
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        if (compass.isPointingNorth() && isPassable(row-1, col)) {
            currentPosition = new Position(row-1, col);
        } else if (compass.isPointingSouth() && isPassable(row+1, col)) {
            currentPosition = new Position(row+1, col);
        } else if (compass.isPointingEast() && isPassable(row, col+1)) {
            currentPosition = new Position(row, col+1);
        } else if (compass.isPointingWest() && isPassable(row, col-1)) {
            currentPosition = new Position(row, col-1);
        } 

        return "F"; 
    }

    /**
     * Solves the maze by repeatedly moving forward until the exit is reached.
     */
    public void solveMaze() { 
        String path = ""; 
        while(!reachedExit()) {
            String step = stepForward(); 
            this.path += step; 
        }

    }

    /**
     * Gets the path taken to solve the maze.
     *
     * @return The path as a string.
     */
    public String getPath() {
        return this.path; 
    }

    /**
     * Checks if a position in the maze is passable.
     *
     * @param row The row of the position to check.
     * @param col The column of the position to check.
     * @return True if the position is within bounds and passable, false otherwise.
     */
    private boolean isPassable(int row, int col) {
        return row >= 0 && row < maze.getRowCount() &&
            col >= 0 && col < maze.getColCount() &&
            maze.getElement(row, col).getType().equals("Pass");
    }

    /**
     * Checks if the MazeRunner has reached the exit of the maze.
     *
     * @return True if the current position matches the exit position, false otherwise.
     */
    public boolean reachedExit() { 
        return currentPosition.getRow() == exit.getRow() && 
            currentPosition.getCol() == exit.getCol();
    }
    
}