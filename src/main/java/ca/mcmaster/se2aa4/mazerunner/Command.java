/**
 * File: Command.java
 * Author: Nithika Karunamoorthy
 * Description: This interface defines a command that can be executed as part of navigating through the maze.
 * Each implementing class will represent a specific action (e.g., move forward, turn left, turn right).
 * The Command pattern allows encapsulating these actions and executing them uniformly.
 */

package ca.mcmaster.se2aa4.mazerunner;

public interface Command {
    boolean execute(Position position, Compass compass, Maze maze); 
}