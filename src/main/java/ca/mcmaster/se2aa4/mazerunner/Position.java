/**
 * File: Position.java
 * Author: Nithika Karunamoorthy
 * Description: The Position class represents a position (or coordinate) in the maze.
 * It holds the row and column values and provides methods for moving within the maze,
 * checking if a move is valid, and comparing positions.
 */
package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int row;
    private int col;

    /**
     * Constructor to initialize the position with a row and column.
     */
    public Position(int row, int col) { // Constructor 
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /**
     * Attempts to move the position one step forward in the direction the compass is pointing.
     */ 
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

    /**
     * Checks if a given position (row, col) in the maze is passable (i.e., not a wall).
     */
    private boolean isPassable(int row, int col, Maze maze) {
        return row >= 0 && row < maze.getRowCount() &&
               col >= 0 && col < maze.getColCount() &&
               maze.getElement(row, col).equals(Element.PASS);
    }

    /**
     * Compares the current position with another object for equality.
     */ 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
