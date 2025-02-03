
package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Algorithm {

    @Override
    public String solveMaze (Maze maze, Position start, Position exit) { 
        StringBuilder path = new StringBuilder(); 
        Position currentPosition = new Position(start.getRow(), start.getCol()); 
        Compass compass = new Compass(Direction.E); 

        while (!currentPosition.equals(exit)) { 
            // Try to move in right-hand rule order: right, forward, left, back 
            if (tryMoveRight(currentPosition, compass, maze, path)) continue; 
            if (tryMoveForward(currentPosition, compass, maze, path)) continue; 
            if (tryMoveLeft(currentPosition, compass, maze, path)) continue; 
            if (tryMoveBackwards(currentPosition, compass, maze, path)) continue; 
            break; // No valid moves, stop 
        }

        return path.toString();
    }

    private boolean tryMoveRight(Position position, Compass compass, Maze maze, StringBuilder path) {
        compass.turnRight();
        if (position.stepForward(compass, maze)) {
            path.append("R").append("F");
            return true;
        }
        return false;
    }
    
    private boolean tryMoveForward(Position position, Compass compass, Maze maze, StringBuilder path) {
        if (position.stepForward(compass, maze)) {
            path.append("F");
            return true;
        }
        return false;
    }

    private boolean tryMoveLeft(Position position, Compass compass, Maze maze, StringBuilder path) {
        compass.turnLeft();
        if (position.stepForward(compass, maze)) {
            path.append("L").append("F");
            return true;
        }
        return false;
    }

    private boolean tryMoveBackwards(Position position, Compass compass, Maze maze, StringBuilder path) {
        compass.turnLeft(); // Turn around
        compass.turnLeft(); // Turn around again to face opposite direction
        if (position.stepForward(compass, maze)) {
            path.append("L").append("L").append("F");
            return true;
        }
        return false;
    }


}
