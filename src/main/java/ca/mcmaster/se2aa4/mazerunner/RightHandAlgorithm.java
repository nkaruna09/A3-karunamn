package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm extends MazeRunner { 

    public RightHandAlgorithm(Maze maze) { 
        super(maze);
    }

    @Override
    public void solve() { 
        while (!reachedExit()){

            // turn right first 
            compass.turnRight();
            if (stepForward()) {
                path.append("R"); 
                path.append("F");
                continue;
            }

            // if not possible, move forward 
            compass.turnLeft(); //undo right turn
            if (stepForward()) {
                path.append("F"); 
                continue;
            }

            // if not possible, turn left
            compass.turnLeft();
            if (stepForward()) {
                path.append("L"); 
                path.append("F");
                continue;
            }

            // if all else fails, turn around
            //compass.turnLeft(); 
            compass.turnLeft(); 
            if (stepForward()) {
                path.append("L");
                path.append("L");
                path.append("F");
                continue;
            }
            
        }
    }
}