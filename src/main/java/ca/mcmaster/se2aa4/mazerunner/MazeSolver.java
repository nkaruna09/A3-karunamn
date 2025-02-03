/**
 * File: MazeSolver.java
 * Author: Nithika Karunamoorthy
 * Description: The MazeSolver class is responsible for solving the maze using a specified algorithm.
 * It utilizes the provided algorithm to navigate the maze from the west entry to the east entry.
 * After solving, the path is converted into a factorized format for user display.
 */

package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver implements MazeTask {
    private Maze maze; // The maze to be solved
    private Algorithm algorithm; // The algorithm used to solve the maze
    private PathFormConverter converter; // Path converter

     /**
     * Constructor to initialize the MazeSolver with the maze and the algorithm.
     */
    public MazeSolver(Maze maze, Algorithm algorithm) {
        this.maze = maze; 
        this.algorithm = algorithm;
        this.converter = new PathFormConverter(); // Initialize path converter
    }

    /**
     * Solves the maze using the provided algorithm and converts the path to a factorized format.
     */
    @Override
    public String solve() {
        Position start = maze.getWestEntry(); // Get starting position (west entry)
        Position exit = maze.getEastEntry(); // Get exit position (east entry)
        String path = algorithm.solveMaze(maze, start, exit); // Solve maze
        return converter.canonicalToFactorized(path); // Return path taken
    }

}