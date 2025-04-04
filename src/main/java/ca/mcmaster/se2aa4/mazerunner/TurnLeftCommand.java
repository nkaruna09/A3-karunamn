package ca.mcmaster.se2aa4.mazerunner;

public class TurnLeftCommand implements Command { 
    @Override 
    public boolean execute(Position position, Compass compass, Maze maze) { 
        compass.turnLeft(); 
        return true; 
    } 
}