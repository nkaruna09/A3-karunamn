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

        Options options = new Options();
        options.addOption("i", "input", true, "Maze file to read"); 
        options.addOption("p", "path", true, "Verify path for the maze"); 

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

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
                PathChecker pathChecker = new PathChecker(maze);
                if (pathChecker.isValidPath(userPath)) {
                    logger.info("The provided path is valid.");
                } else {
                    logger.warn("The provided path is invalid.");
                }
            } else {
                logger.info("**** Solving the maze automatically.");
                runner.solveMaze();
                logger.info("Path: " + runner.getPath());
            }
           
        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        //logger.info("**** Computing path");
        //logger.warn("PATH NOT COMPUTED");
        logger.info("** End of Maze Runner");
    }
}
