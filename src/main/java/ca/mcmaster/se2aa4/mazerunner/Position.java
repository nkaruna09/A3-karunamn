package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int row;
    private int col;

    // Constructor
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
