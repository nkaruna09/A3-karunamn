package ca.mcmaster.se2aa4.mazerunner;

import java.util.*; 
import java.io.IOException; 

public class Maze {
    
    private MazeElement[][] maze;

    public Maze(String inputFile) throws IOException { // Constructor 
        MazeLoader loader = new MazeLoader();
        this.maze = loader.generateMaze(inputFile); 
    }

    public void printMaze(){
        int rows = maze.length;
        int cols = maze[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.print("\n"); 
        }
    }


}