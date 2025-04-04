package ca.mcmaster.se2aa4.mazerunner;

public class MoveForwardCommand implements Command { 
    @Override 
    public boolean execute(Position position, Compass compass, Maze maze) { 
        return position.stepForward(compass, maze); 
    }
}