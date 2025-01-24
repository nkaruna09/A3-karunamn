package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*; 

public class MazeLoader {
    private List<String> lines = new ArrayList<String>();

    public MazeElement[][] generateMaze(String inputFile) throws IOException{
        readFile(inputFile);

        int rows = lines.size();
        int cols = lines.get(0).length(); 

        // Array[column][row]
        MazeElement[][] maze = new MazeElement[rows][cols];

        for (int i = 0; i < rows; i++) {
            
            String line = lines.get(i); 

            if(line.isEmpty()){
                line = new String(new char[maze[0].length]).replace('\0', ' ');
            }

            for (int j = 0; j < cols; j++) { // deal with exception later
                char cell = line.charAt(j);
                if (cell == '#') {
                    maze[i][j] = new Wall(i, j);
                } else if (cell == ' ') {
                    maze[i][j] = new Pass(i, j);
                }
            }
        } 

        return maze;
    }

    private void readFile(String inputFile){
        //logger.info("**** Reading the maze from file: "+ inputFile); 
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