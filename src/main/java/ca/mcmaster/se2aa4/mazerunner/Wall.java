package ca.mcmaster.se2aa4.mazerunner;

public class Wall extends MazeElement {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public String getType() {
        return "Wall";
    }

    @Override
    public String toString() {
        return "#";
    }
}