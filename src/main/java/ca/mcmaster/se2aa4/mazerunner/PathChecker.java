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

    /**
     * Checks whether a given user path is valid within the maze.
     * 
     * @param userPath A string representing the sequence of moves ('F' for forward).
     * @return true if the path is valid, false otherwise.
     */
    public boolean isValidPath(String userPath) { 
        Position currentPosition = maze.getWestEntry(); 
        Compass compass = new Compass(); 

        for (char step : userPath.toCharArray()) {
            int row = currentPosition.getRow();
            int col = currentPosition.getCol();

            if (step == 'F'){
                if (compass.isPointingNorth() && isPassable(row-1, col)) {
                    currentPosition = new Position(row-1, col);
                } else if (compass.isPointingSouth() && isPassable(row+1, col)) {
                    currentPosition = new Position(row+1, col);
                } else if (compass.isPointingEast() && isPassable(row, col+1)) {
                    currentPosition = new Position(row, col+1);
                } else if (compass.isPointingWest() && isPassable(row, col-1)) {
                    currentPosition = new Position(row, col-1);
                } else {
                    return false; 
                }
            } else if (step == 'L') {
                compass.turnLeft(); 
            } else if (step == 'R') {
                compass.turnRight(); 
            } else {
                continue;
            }
        }

        return true;
    }

    /**
     * Checks whether a given cell in the maze is passable.
     * 
     * @param row The row index of the cell to check.
     * @param col The column index of the cell to check.
     * @return true if the cell is within bounds and is a "Pass" element, false otherwise.
     */
    private boolean isPassable(int row, int col) {
        return row >= 0 && row < maze.getRowCount() &&
            col >= 0 && col < maze.getColCount() &&
            maze.getElement(row, col).equals(Element.PASS);
    }

}