package ca.mcmaster.se2aa4.mazerunner;

import java.util.*;

public class MazeRunner {
    protected Maze maze;
    protected Compass compass; 
    protected Position currentPosition;
    protected Position exit;
    protected StringBuilder path;
    private PathFormConverter converter;
    private MazeSolver solver; 
    private PathChecker pathChecker; 
    private String userPath;

    public MazeRunner(Maze maze, MazeSolver solver, String userPath) {
        this.maze = maze; 
        this.compass = new Compass(Direction.E); // Starting direction is East
        this.currentPosition = maze.getWestEntry(); // Starting position at West Entry
        this.exit = maze.getEastEntry(); // Exit at East Entry
        this.solver = solver; 
        this.pathChecker = new PathChecker(maze);
        this.userPath = userPath;
        this.path = new StringBuilder();  
        this.converter = new PathFormConverter();
    }

    public String solve() { 
        if (this.userPath == null) { 
            solver.solveMaze(this); // Solve the maze using the solver
            return converter.canonicalToFactorized(path.toString()); 
        } else {  
            userPath = converter.factorizedToCanonical(userPath); 
            if (pathChecker.isValidPath(this.userPath)) {
                return "correct path";  // If the user path is valid
            } else { 
                return "incorrect path";  // If the user path is invalid
            }
        }
    }

    public boolean stepForward() {
        return currentPosition.stepForward(this.compass, this.maze);
    }
    
    public boolean reachedExit() { 
        return currentPosition.getRow() == exit.getRow() && 
            currentPosition.getCol() == exit.getCol();
    }

    public String getPath() {
        return path.toString(); // Return the solved path (or empty if not solved)
    }
}
