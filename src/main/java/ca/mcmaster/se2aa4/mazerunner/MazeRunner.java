package ca.mcmaster.se2aa4.mazerunner;

public class MazeRunner { 
    private MazeTask task; 

    public MazeRunner(Maze maze, String userPath, Algorithm algorithm) { 
        if (userPath == null) { 
            this.task = new MazeSolver(maze, algorithm); 
        } else { 
            this.task = new MazeChecker(maze, userPath); 
        }
    }

    public String solve() { 
       return task.solve();
    }
}