/**
 * File: MazeLoader.java
 * Author: Nithika Karunamoorthy
 * Description: The MazeLoader class is responsible for reading a maze structure
 * from a text file and converting it into a 2D array of `Element` objects. It handles 
 * the reading of the file and the conversion of each character in the file (either '#' or ' ')
 * into corresponding `Element` types (WALL or PASS).
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*; 

public class MazeLoader {
    private List<String> lines = new ArrayList<String>(); // Store each line of the maze

    /**
     * Generates a maze from the given input file.
     * This method reads the maze structure from the file and converts it into a 2D array of `Element` values.
     */
    public Element[][] generateMaze(String inputFile) throws IOException{
        readFile(inputFile);

        int rows = lines.size();
        int cols = lines.get(0).length(); 
        Element[][] maze = new Element[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            if(line.isEmpty()){ // Handle empty line case (fill with spaces if empty)
                line = " ".repeat(cols);
            }
            for (int j = 0; j < cols; j++) { 
                try { 
                    char cell = line.charAt(j);
                    if (cell == '#') {
                        maze[i][j] = Element.WALL;
                    } else if (cell == ' ') {
                        maze[i][j] = Element.PASS;
                    } 
                } catch (Exception e) { 
                    maze[i][j] = Element.PASS;
                }
            }
        } 

        return maze; // return populated maze
    }

     /**
     * Reads the maze structure from the specified input file and stores each line.
     */
    private void readFile(String inputFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read each line from the file and add it to the lines list
                this.lines.add(line);
            } 
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("An error has occurred");
        }   

    }

}