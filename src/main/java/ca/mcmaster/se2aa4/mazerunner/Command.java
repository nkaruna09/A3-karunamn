package ca.mcmaster.se2aa4.mazerunner;

public interface Command {
    boolean execute(Position position, Compass compass, Maze maze); 
}