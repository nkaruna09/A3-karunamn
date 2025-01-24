package ca.mcmaster.se2aa4.mazerunner;

/**
 * The Wall class represents a wall element in the maze.
 * Walls are impassable and block the movement of the user.
 * This class extends the MazeElement superclass.
 */
public class Wall extends MazeElement {

    public Wall(int x, int y) { // Constructor 
        super(x, y);
    }

    /**
     * Returns the type of the maze element as a string.
     * 
     * @return A string "Wall", representing the type of this maze element.
     */
    @Override
    public String getType() {
        return "Wall";
    }

    /**
     * Returns a string representation of the wall, used for maze display.
     *
     * @return A string "#" representing the wall in the maze.
     */
    @Override
    public String toString() {
        return "#";
    }
}