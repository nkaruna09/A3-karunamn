package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements MazeSolver { 

    public RightHandAlgorithm() { }

    @Override
    public void solve(MazeRunner runner) { 
        StringBuilder path = runner.path;

        while (!runner.reachedExit()){

            // turn right first 
            runner.compass.turnRight();
            if (runner.stepForward()) {
                path.append("R").append("F");
                continue;
            }

            // if not possible, move forward 
            runner.compass.turnLeft(); //undo right turn
            if (runner.stepForward()) {
                path.append("F"); 
                continue;
            }

            // if not possible, turn left
            runner.compass.turnLeft();
            if (runner.stepForward()) {
                path.append("L").append("F");
                continue;
            }

            // if all else fails, turn around
            runner.compass.turnLeft(); 
            if (runner.stepForward()) {
                path.append("L").append("L").append("F");
                continue;
            }
            
        }
    }
}