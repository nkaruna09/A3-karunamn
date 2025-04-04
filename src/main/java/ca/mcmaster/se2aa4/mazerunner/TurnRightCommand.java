package ca.mcmaster.se2aa4.mazerunner;

public class TurnRightCommand implements Command { 
    @Override 
    public boolean execute(Position position, Compass compass, Maze maze) { 
        compass.turnRight(); 
        return true; 
    } 
}