package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int row;
    private int col;
    private Position exit; 

    public Position(int row, int col) { // Consctructor 
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean stepForward(Compass compass, Maze maze) {
        int row = this.row;
        int col = this.col;
        Direction dir = compass.getDirection();

        if (dir == Direction.N && isPassable(row - 1, col, maze)) {
            this.row = row - 1;
            return true;
        } else if (dir == Direction.S && isPassable(row + 1, col, maze)) {
            this.row = row + 1;
            return true;
        } else if (dir == Direction.E && isPassable(row, col + 1, maze)) {
            this.col = col + 1;
            return true;
        } else if (dir == Direction.W && isPassable(row, col - 1, maze)) {
            this.col = col - 1;
            return true;
        }

        return false;
    }

    private boolean isPassable(int row, int col, Maze maze) {
        return row >= 0 && row < maze.getRowCount() &&
               col >= 0 && col < maze.getColCount() &&
               maze.getElement(row, col).equals(Element.PASS);
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

}
