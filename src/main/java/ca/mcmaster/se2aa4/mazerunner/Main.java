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
            // Parse the command-line arguments and get the configuration
            Configuration config = Configuration.fromArgs(args);

            // Create a Maze object with the input file
            Maze maze = new Maze(config.getInputFile());

            // Start solving the maze
            MazeSolver rightHandSolver = new RightHandAlgorithm();
            MazeRunner runner = new MazeRunner(maze, rightHandSolver, config.getInputPath());
            String output = runner.solve();

            // Print the output of the maze-solving process
            System.out.println(output);

        } catch (ParseException pe) {
            logger.error("Command-line argument error: " + pe.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
        
    }
}
