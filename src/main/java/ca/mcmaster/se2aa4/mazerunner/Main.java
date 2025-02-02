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

        InputHandler inputHandler = new InputHandler(args);

        if (!inputHandler.isValid()) {
            logger.error("Invalid command-line arguments. Exiting.");
            return;
        }

        String inputFile = inputHandler.getInputFile();
        String userPath = inputHandler.getUserPath();

        try {
            logger.info("**** Reading the maze from file: "+ inputFile); 

            Maze maze = new Maze(inputFile);
            maze.printMaze(); 
            
            logger.info("East entry: " + maze.getEastEntry());
            logger.info("West entry: " + maze.getWestEntry());

            MazeSolver rightHandSolver = new RightHandAlgorithm();
            MazeRunner runner = new MazeRunner(maze, rightHandSolver);
            PathFormConverter converter = new PathFormConverter();

            if (userPath != null) {
                logger.info("**** Validating user path: " + userPath);
                
                // Convert factorized path to canonical form
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
                runner.solve();
                String factorizedPath = converter.canonicalToFactorized(runner.getPath().toString());
                logger.info("Path: " + factorizedPath);
            }
           
        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        logger.info("** End of Maze Runner");
    }
}
