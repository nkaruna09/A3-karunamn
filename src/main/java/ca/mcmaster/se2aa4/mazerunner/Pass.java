package ca.mcmaster.se2aa4.mazerunner; 

public class Pass extends MazeElement {
    public Pass(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "Pass";
    }

    @Override
    public String toString() {
        return " ";
    }
}