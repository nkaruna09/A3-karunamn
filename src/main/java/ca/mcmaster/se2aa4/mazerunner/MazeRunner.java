package ca.mcmaster.se2aa4.mazerunner;

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

    public void solveMaze() { 
        String path = ""; 
        while(!reachedExit()) {
            String step = stepForward(); 
            this.path += step; 
        }

    }

    public String getPath() {
        return this.path; 
    }

    private boolean isPassable(int row, int col) {
        return row >= 0 && row < maze.getRowCount() &&
            col >= 0 && col < maze.getColCount() &&
            maze.getElement(row, col).getType().equals("Pass");
    }

    public boolean reachedExit() { 
        return currentPosition.getRow() == exit.getRow() && currentPosition.getCol() == exit.getCol();
    }
    

}