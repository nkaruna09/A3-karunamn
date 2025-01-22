package ca.mcmaster.se2aa4.mazerunner;

public abstract class MazeElement { 
    private int x, y; 

    public MazeElement(int x, int y) { 
        this.x = x; 
        this.y = y; 
    }

    public int getX() { 
        return x; 
    }

    public int getY() { 
        return y; 
    }  

    public abstract String getType(); 
}