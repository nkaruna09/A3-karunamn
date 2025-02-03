package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver implements MazeTask {
    private Maze maze; 
    private Algorithm algorithm;
    private PathFormConverter converter; // Path converter

    public MazeSolver(Maze maze, Algorithm algorithm) {
        this.maze = maze; 
        this.algorithm = algorithm;
        this.converter = new PathFormConverter(); // Initialize path converter
    }

    @Override
    public String solve() {
        Position start = maze.getWestEntry(); // Get starting position
        Position exit = maze.getEastEntry(); // Get exit position   
        String path = algorithm.solveMaze(maze, start, exit); // Solve maze
        return converter.canonicalToFactorized(path); // Return path taken
    }

}