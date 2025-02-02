package ca.mcmaster.se2aa4.mazerunner;

public class MazeRunner {
    protected Maze maze;
    protected Compass compass; 
    protected Position currentPosition;
    protected Position exit;
    protected StringBuilder path;
    private MazeSolver solver; 

    public MazeRunner(Maze maze, MazeSolver solver) {
        this.maze = maze; 
        this.currentPosition = maze.getWestEntry();
        this.exit = maze.getEastEntry();
        this.compass = new Compass();
        this.path = new StringBuilder();
        this.solver = solver; 
    }
    
    public boolean stepForward() {
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();

        Direction dir = compass.getDirection(); 

        if (dir == Direction.N && isPassable(row-1, col)) {
            currentPosition = new Position(row-1, col);
            return true; 
        } else if (dir == Direction.S && isPassable(row+1, col)) {
            currentPosition = new Position(row+1, col);
            return true; 
        } else if (dir == Direction.E && isPassable(row, col+1)) {
            currentPosition = new Position(row, col+1);
            return true; 
        } else if (dir == Direction.W && isPassable(row, col-1)) {
            currentPosition = new Position(row, col-1);
            return true; 
        } 

        return false; 
    }

    public void solve() { 
        if (solver != null) { 
            solver.solve(this); 
        } else { 
            throw new IllegalStateException("No solver has been set.");
        }

    }

    public String getPath() {
        return path.toString(); 
    }

    private boolean isPassable(int row, int col) {
        return row >= 0 && row < maze.getRowCount() &&
            col >= 0 && col < maze.getColCount() &&
            maze.getElement(row, col).equals(Element.PASS);
    }

    public boolean reachedExit() { 
        return currentPosition.getRow() == exit.getRow() && 
            currentPosition.getCol() == exit.getCol();
    }
    
}