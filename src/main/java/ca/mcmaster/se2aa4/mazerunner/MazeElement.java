package ca.mcmaster.se2aa4.mazerunner;

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