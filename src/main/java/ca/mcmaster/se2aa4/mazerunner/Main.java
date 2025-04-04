/**
 * File: Main.java
 * Author: Nithika Karunamoorthy
 * Description: The main entry point of the Maze Runner application. 
 * This class handles the parsing of command-line arguments, 
 * loads the maze, and solves it using a specified algorithm (default is RightHandAlgorithm).
 * It also logs errors and outputs the solution of the maze.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*; 

public class Main { 

    private static final Logger logger = LogManager.getLogger();
 
    public static void main(String[] args) {
        try {
            logger.info("***Start maze***"); 
            Configuration config = Configuration.fromArgs(args);
            Maze maze = new Maze(config.getInputFile()); 
            Algorithm algorithm = new RightHandAlgorithm(); // Can be changed for future implementations 
            MazeRunner runner = new MazeRunner(maze, config.getInputPath(), algorithm);
            String output = runner.solve();
            System.out.println(output); 
        } catch (ParseException pe) { // Log error if command-line arguments are invalid
            logger.error("Command-line argument error: " + pe.getMessage());
        } catch (IllegalArgumentException e) { // Log error if there are invalid input or path issues
            logger.error("Invalid input/path error: " + e.getMessage());
        } catch (Exception e) { // Log any other unexpected errors
            logger.error("An error occurred: ", e);
        }
        logger.info("***End maze***");
    }
}