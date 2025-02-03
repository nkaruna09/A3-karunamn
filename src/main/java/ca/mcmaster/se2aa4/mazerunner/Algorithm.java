/**
 * File: Algorithm.java
 * Author: Nithika Karunamoorthy
 * Description: This interface defines the contract for a maze-solving algorithm.
 * It requires the implementation of a method that guides the solver through the maze 
 * from a specified start position to an exit.
 */

package ca.mcmaster.se2aa4.mazerunner;

public interface Algorithm {
    public String solveMaze(Maze maze, Position start, Position exit);  
} 