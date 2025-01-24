package ca.mcmaster.se2aa4.mazerunner;

/**
 * The Position class represents a specific location in a maze
 * using row and column coordinates.
 */
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) { // Consctructor 
        this.row = row;
        this.col = col;
    }

    /**
     * Constructor to initialize the Position with row and column values.
     *
     * @param row The row index of the position.
     * @param col The column index of the position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column index of the position.
     *
     * @return The column index.
     */
    public int getCol() {
        return col;
    }

    /**
     * Returns a string representation of the Position in the format "(row, col)".
     *
     * @return The string representation of the position.
     */
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
