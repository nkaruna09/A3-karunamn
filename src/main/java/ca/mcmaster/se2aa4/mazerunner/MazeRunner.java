package ca.mcmaster.se2aa4.mazerunner;

public class MazeRunner { 
    protected Maze maze; 
    protected String userPath; 

    public MazeRunner(Maze maze, String userPath) { 
        this.maze = maze; 
        this.userPath = userPath; 
        
    }

    public MazeRunner(Maze maze) { 
        this.maze = maze; 
        this.userPath = null; 
    }

    public String solve() { 
        if (this.userPath == null) { 
            MazeSolver solver = new MazeSolver(maze); 
            return solver.solve();  
        } else { 
            MazeChecker checker = new MazeChecker(maze, userPath); 
            return checker.solve(); 
        }
    }
}