package ca.mcmaster.se2aa4.mazerunner; 

/**
 * The Pass class represents an empty or navigable space in the maze.
 * It extends MazeElement and overrides methods to define its type and display characteristics.
 */
public class Pass extends MazeElement {
    public Pass(int x, int y) {
        super(x, y);
    }

    /**
     * Returns the type of the MazeElement as "Pass".
     * 
     * @return A string representing the type of this element.
     */
    @Override
    public String getType() {
        return "Pass";
    }

    /**
     * Returns a string representation of the Pass element.
     * In this case, it is represented by a single space (" "), 
     * indicating an empty or navigable area in the maze.
     * 
     * @return A string representation of the Pass element.
     */
    @Override
    public String toString() {
        return " ";
    }
}