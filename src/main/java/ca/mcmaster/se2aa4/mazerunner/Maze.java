package ca.mcmaster.se2aa4.mazerunner;

import java.util.*; 
import java.io.IOException; 

/**
 * The Maze class represents a maze structure loaded from a file.
 * It includes methods to retrieve maze elements, find entry points,
 * and print the maze to the console.
 */

public class Maze {
    
    private Element[][] maze;
    private Position eastEntry; 
    private Position westEntry; 

    public Maze(String inputFile) throws IOException { // Constructor 
        MazeLoader loader = new MazeLoader();
        this.maze = loader.generateMaze(inputFile); 
        this.eastEntry = findEastEntry(); 
        this.westEntry = findWestEntry(); 
    }

    /**
     * Finds the position of the west entry point in the maze.
     *
     * @return the position of the west entry or null if no entry is found.
     */
    private Position findWestEntry(){
        int rows = maze.length;

        for (int i=0; i < rows; i++){
            if (maze[i][0] == Element.PASS){
                return new Position(i, 0); 
            }
        }

        return null;
    }

    /**
     * Finds the position of the east entry point in the maze.
     *
     * @return the position of the east entry or null if no entry is found.
     */
    private Position findEastEntry(){
        int rows = maze.length;

        for (int i=0; i < rows; i++){
            if (maze[i][maze[0].length-1] == Element.PASS){
                return new Position(i, maze[0].length-1); 
            }
        }   

        return null;
    }

    /**
     * Returns the position of the east entry point.
     *
     * @return the east entry position.
     */
    public Position getEastEntry(){
        return this.eastEntry; 
    }

    /**
     * Returns the position of the west entry point.
     *
     * @return the west entry position.
     */
    public Position getWestEntry(){
        return this.westEntry; 
    }

    /**
     * Returns the number of rows in the maze.
     *
     * @return the number of rows.
     */
    public int getRowCount(){
        return this.maze.length; 
    }

    /**
     * Returns the number of columns in the maze.
     *
     * @return the number of columns.
     */
    public int getColCount(){
        return this.maze[0].length; 
    }

    /**
     * Retrieves the MazeElement at a specific position in the maze.
     *
     * @param row the row index.
     * @param col the column index.
     * @return the MazeElement at the specified position.
     */
    public Element getElement(int row, int col){
        return this.maze[row][col]; 
    }

    /**
     * Prints the maze to the console.
     * Each element is represented as a character, row by row.
     */
    public void printMaze(){
        int rows = maze.length;
        int cols = maze[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j].getSymbol());
            }
            System.out.print("\n"); 
        }
    }


}