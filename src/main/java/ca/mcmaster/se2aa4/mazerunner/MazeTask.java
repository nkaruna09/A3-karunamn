/**
 * File: MazeTask.java
 * Author: Nithika Karunamoorthy
 * Description: This interface defines the contract for tasks related to the maze.
 * Any class that implements this interface must provide a solution for the maze,
 * typically either solving the maze or validating a user-provided path.
 */
package ca.mcmaster.se2aa4.mazerunner;

public interface MazeTask {
    public String solve(); 
}