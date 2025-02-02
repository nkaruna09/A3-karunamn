package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements MazeSolver { 

    public RightHandAlgorithm() { }

    @Override
    public void solveMaze(MazeRunner runner) { 
        StringBuilder path = runner.path;

        // Check if the exit is reached in the maze
        while (!runner.reachedExit()) {

            // Turn right first
            runner.compass.turnRight();
            if (runner.stepForward()) {
                path.append("R").append("F");
                continue;
            }

            // If not possible, undo the right turn and move forward
            runner.compass.turnLeft(); // Undo right turn
            if (runner.stepForward()) {
                path.append("F");
                continue;
            }

            // If moving forward is not possible, turn left
            runner.compass.turnLeft();
            if (runner.stepForward()) {
                path.append("L").append("F");
                continue;
            }

            // If all else fails, turn around (left twice) and move forward
            runner.compass.turnLeft();
            if (runner.stepForward()) {
                path.append("L").append("L").append("F");
                continue;
            }
        }
    }
}
