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

            MazeSolver rightHandSolver = new RightHandAlgorithm();
            MazeRunner runner = new MazeRunner(maze, rightHandSolver, userPath);
            String output = runner.solve(); 
            System.out.println(output); 
           
        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        logger.info("** End of Maze Runner");
    }
}
