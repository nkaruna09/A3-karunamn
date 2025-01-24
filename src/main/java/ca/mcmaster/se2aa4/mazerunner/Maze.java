package ca.mcmaster.se2aa4.mazerunner;

import java.util.*; 
import java.io.IOException; 

public class Maze {
    
    private MazeElement[][] maze;
    private Position eastEntry; 
    private Position westEntry; 

    public Maze(String inputFile) throws IOException { // Constructor 
        MazeLoader loader = new MazeLoader();
        this.maze = loader.generateMaze(inputFile); 
        this.eastEntry = findEastEntry(); 
        this.westEntry = findWestEntry(); 
    }

    private Position findWestEntry(){
        int rows = maze.length;

        for (int i=0; i < rows; i++){
            if (maze[i][0].getType().equals("Pass")){
                return new Position(i, 0); 
            }
        }

        return null;
    }

    private Position findEastEntry(){
        int rows = maze.length;

        for (int i=0; i < rows; i++){
            if (maze[i][maze[0].length-1].getType().equals("Pass")){
                return new Position(i, maze[0].length-1); 
            }
        }   

        return null;
    }

    public Position getEastEntry(){
        return this.eastEntry; 
    }

    public Position getWestEntry(){
        return this.westEntry; 
    }

    public int getRowCount(){
        return this.maze.length; 
    }

    public int getColCount(){
        return this.maze[0].length; 
    }

    public MazeElement getElement(int row, int col){
        return this.maze[row][col]; 
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