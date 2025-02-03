
package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Algorithm {

    @Override
    public String solveMaze (Maze maze, Position start, Position exit) { 
        StringBuilder path = new StringBuilder(); 
        Position currentPosition = new Position(start.getRow(), start.getCol()); 
        Compass compass = new Compass(Direction.E); 

        while (!currentPosition.equals(exit)) { 
            // Turn right first
            compass.turnRight();
            if (currentPosition.stepForward(compass, maze)) {
                path.append("R").append("F");
                continue;
            }

            // If we can't move forward, undo the right turn and move forward
            compass.turnLeft(); // Undo the right turn
            if (currentPosition.stepForward(compass, maze)) {
                path.append("F");
                continue;
            }

            // If moving forward isn't possible, turn left
            compass.turnLeft();
            if (currentPosition.stepForward(compass, maze)) {
                path.append("L").append("F");
                continue;
            }

            // If all else fails, turn around (turn left twice) and move forward
            compass.turnLeft();
            if (currentPosition.stepForward(compass, maze)) {
                path.append("L").append("L").append("F");
                continue;
            }
        }

        return path.toString();
    }

}
