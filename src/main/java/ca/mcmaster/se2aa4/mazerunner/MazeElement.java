package ca.mcmaster.se2aa4.mazerunner;

/**
 * Abstract class representing a generic element within a maze.
 * Each element is located at a specific row and column in the maze grid.
 */
public abstract class MazeElement { 
    private int row, col; 

    public MazeElement(int row, int col) { 
        this.row = row; 
        this.col = col; 
    }

    public int getRow() { 
        return this.row; 
    }

    public int getCol() { 
        return this.col; 
    }  

    public abstract String getType(); 
}