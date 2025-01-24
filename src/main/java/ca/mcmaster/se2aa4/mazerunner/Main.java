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
        logger.info("** Starting Maze Runner"); 

        // Define command-line options for the input maze file and user path.
        Options options = new Options();
        options.addOption("i", "input", true, "Maze file to read"); 
        options.addOption("p", "path", true, "Verify path for the maze"); 

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            // Get the input file and user path from the command line.
            String inputFile = cmd.getOptionValue("i");
            String userPath = cmd.getOptionValue("p");

            logger.info("**** Reading the maze from file: "+ inputFile); 

            Maze maze = new Maze(inputFile);
            maze.printMaze(); 
            
            logger.info("East entry: " + maze.getEastEntry());
            logger.info("West entry: " + maze.getWestEntry());

            MazeRunner runner = new MazeRunner(maze);

            if (userPath != null) {
                logger.info("**** Validating user path: " + userPath);
                
                // Convert factorized path to canonical form
                PathFormConverter converter = new PathFormConverter();
                String canonicalPath = converter.factorizedToCanonical(userPath);
                logger.info("Expanded path for validation: " + canonicalPath);

                // Validate the provided path
                PathChecker pathChecker = new PathChecker(maze); 

                if (pathChecker.isValidPath(canonicalPath)) {
                    logger.info("The provided path is valid.");
                } else {
                    logger.warn("The provided path is invalid.");
                }
            } else {
                logger.info("**** Computing path.");
                runner.solveMaze();
                logger.info("Path: " + runner.getPath());
            }
           
        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        logger.info("** End of Maze Runner");
    }
}
