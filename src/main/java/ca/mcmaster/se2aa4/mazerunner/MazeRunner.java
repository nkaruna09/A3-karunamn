/**
 * File: MazeRunner.java
 * Author: Nithika Karunamoorthy
 * Description: The MazeRunner class is responsible for running the appropriate maze-solving task.
 * It chooses between solving the maze algorithmically (using an Algorithm) or checking the user's provided path (using MazeChecker),
 * and delegates the task to the appropriate implementation of the MazeTask interface.
 */

package ca.mcmaster.se2aa4.mazerunner;

public class MazeRunner { 
    private StrategyTask strategy; // The task that will be executed (either solving the maze or checking the path)

    /**
     * Constructor to initialize the MazeRunner with the maze, user-provided path, and algorithm.
     * If the user provides a path, it will check it; otherwise, it will solve the maze using the algorithm.
     */ 
    public MazeRunner(Maze maze, String userPath, Algorithm algorithm) { 
        if (userPath == null) { // If no user path is provided, assign the task as MazeSolver with the given algorithm
            this.strategy = new SolverStrategy(maze, algorithm); 
        } else { // If a user path is provided, assign the task as MazeChecker to validate the path
            this.strategy = new CheckerStrategy(maze, userPath); 
        }
    }

     /**
     * Executes the assigned task (either solving the maze or checking the path) and returns the result.
     */ 
    public String solve() { 
       return strategy.solve(); // Delegate the solve method to the task (either MazeSolver or MazeChecker)
    }
}