package ca.mcmaster.se2aa4.mazerunner; 

public class PathChecker { 
    private Maze maze;
    
    public PathChecker(Maze maze) {
        this.maze = maze; 
    }

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
            }
        }

        return true;
    }

    private boolean isPassable(int row, int col) {
        return row >= 0 && row < maze.getRowCount() &&
            col >= 0 && col < maze.getColCount() &&
            maze.getElement(row, col).getType().equals("Pass");
    }

}