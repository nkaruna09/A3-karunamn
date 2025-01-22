package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeLoader {
    private List<String> lines = new ArrayList<String>();

    public generateMaze(String inputFile) {
        readFile(inputFile);

        // Array[column][row]
        Array[][] maze = new Array[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(0).length(); j++) { // deal with exception later
                if (lines.get(i).charAt(j) == '#') {
                    maze[i][j] = new Wall();
                } else if (lines.get(i).charAt(j) == ' ') {
                    maze[i][j] = new Pass();
                }
            }
        } 

        return maze;
    }

    private void readFile(String inputFile){
        //logger.info("**** Reading the maze from file: "+ inputFile); 
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while ((line = reader.readLine()) != null) {
            this.lines.add(line);
        } // Consider exception here later

    }

    // decide if this should be under Maze or MazeLoader
    public void printMaze(){
        for (String line : this.lines){
            StringBuilder lineLog = new StringBuilder();
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    lineLog.append("WALL "); 
                } else if (line.charAt(idx) == ' ') {
                    lineLog.append("PASS ");
                }
            }
            System.out.println(lineLog.toString().trim());
        }   
    }

}