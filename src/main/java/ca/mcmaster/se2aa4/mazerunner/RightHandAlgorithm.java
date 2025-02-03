
package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Algorithm {

    @Override
    public void solveMaze(MazeSolver solver) {
        StringBuilder path = solver.getPath();
        Compass compass = solver.getCompass();

        // Continue until the exit is reached
        while (!solver.reachedExit()) {
            // Turn right first
            compass.turnRight();
            if (solver.stepForward()) {
                path.append("R").append("F");
                continue;
            }

            // If we can't move forward, undo the right turn and move forward
            compass.turnLeft(); // Undo the right turn
            if (solver.stepForward()) {
                path.append("F");
                continue;
            }

            // If moving forward isn't possible, turn left
            compass.turnLeft();
            if (solver.stepForward()) {
                path.append("L").append("F");
                continue;
            }

            // If all else fails, turn around (turn left twice) and move forward
            compass.turnLeft();
            if (solver.stepForward()) {
                path.append("L").append("L").append("F");
                continue;
            }
        }
    }
}
