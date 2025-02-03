package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*; 

/**
 * The MazeLoader class is responsible for reading a maze structure
 * from a text file and converting it into a 2D array of MazeElement objects.
 */
public class MazeLoader {
    private List<String> lines = new ArrayList<String>();

    /**
     * Generates a maze from the given input file.
     */
    public Element[][] generateMaze(String inputFile) throws IOException{
        readFile(inputFile);

        int rows = lines.size();
        int cols = lines.get(0).length(); 

        Element[][] maze = new Element[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);

            if(line.isEmpty()){
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

        return maze;
    }

     /**
     * Reads the maze structure from the specified input file.
     */
    private void readFile(String inputFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
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