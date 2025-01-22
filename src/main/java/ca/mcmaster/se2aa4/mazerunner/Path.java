package ca.mcmaster.se2aa4.mazerunner;

public abstract class Path {
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;

    public Path(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public abstract boolean isValidPath();
    public abstract void findPath();
}