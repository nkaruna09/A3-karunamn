/**
 * File: TurnLeftCommand.java
 * Author: Nithika Karunamoorthy
 * Description: This class implements the Command interface to represent the action of turning left.
 * Turning left updates the agent's direction without changing its position in the maze.
 */
package ca.mcmaster.se2aa4.mazerunner;

public class TurnLeftCommand implements Command { 
    @Override 
    public boolean execute(Position position, Compass compass, Maze maze) { 
        compass.turnLeft(); 
        return true; 
    } 
}