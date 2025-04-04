/**
 * File: MoveForwardCommand.java
 * Author: Nithika Karunamoorthy
 * Description: This class implements the Command interface to represent the action of moving forward in the maze.
 * It uses the current position and compass direction to attempt a forward movement.
 * The move is validated against the maze structure to ensure it doesn't hit a wall or go out of bounds.
 */

package ca.mcmaster.se2aa4.mazerunner;

public class MoveForwardCommand implements Command { 
    @Override 
    public boolean execute(Position position, Compass compass, Maze maze) { 
        return position.stepForward(compass, maze); 
    }
}