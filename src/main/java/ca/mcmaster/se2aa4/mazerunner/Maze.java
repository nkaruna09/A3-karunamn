/**
 * File: Maze.java
 * Author: Nithika Karunamoorthy
 * Description: This class represents a maze, which is stored as a 2D array of `Element` values.
 * It includes methods for loading the maze from a file, retrieving maze dimensions, 
 * finding the east and west entry points, and printing the maze to the console.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.util.*; 
import java.io.IOException; 

public class Maze {
    
    private Element[][] maze;
    private Position eastEntry; 
    private Position westEntry; 

     /**
     * Constructor to initialize the maze from an input file.
     * The maze is loaded, and the east and west entries are located.
     */ 

    public Maze(String inputFile) throws IOException { // Constructor 
        MazeLoader loader = new MazeLoader();
        this.maze = loader.generateMaze(inputFile); // Generate maze from input file
        this.eastEntry = findEastEntry(); 
        this.westEntry = findWestEntry(); 
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

    /**
     * Returns the element (WALL or PASS) at the specified row and column.
     */ 
    public Element getElement(int row, int col){
        return this.maze[row][col]; 
    }

    /**
     * Searches for the west entry (first PASS element in the leftmost column) and returns the position.
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
     * Searches for the east entry (first PASS element in the rightmost column) and returns the position.
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
     * Prints the maze to the console using the symbol for each element (WALL or PASS).
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