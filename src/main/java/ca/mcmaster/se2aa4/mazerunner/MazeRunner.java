package ca.mcmaster.se2aa4.mazerunner;

public class MazeRunner { 
    protected Maze maze; 
    protected String userPath; 
    protected Algorithm algorithm;

    public MazeRunner(Maze maze, String userPath, Algorithm algorithm) { 
        this.maze = maze; 
        this.userPath = userPath; 
        this.algorithm = algorithm;
    }

    public MazeRunner(Maze maze, String userPath) { 
        this(maze, userPath, new RightHandAlgorithm()); // Default algorithm
    }

    public MazeRunner(Maze maze, Algorithm algorithm) { 
        this(maze, null, algorithm);
    }

    public String solve() { 
        if (this.userPath == null) { 
            MazeSolver solver = new MazeSolver(maze, algorithm); 
            return solver.solve();  
        } else { 
            MazeChecker checker = new MazeChecker(maze, userPath); 
            return checker.solve(); 
        }
    }
}