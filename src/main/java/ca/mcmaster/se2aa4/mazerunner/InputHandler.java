package ca.mcmaster.se2aa4.mazerunner;

import java.io.File; 

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputHandler { 

    private static final Logger logger = LogManager.getLogger();
    private Options options;
    private CommandLine cmd;

    public InputHandler(String[] args) {
        options = new Options();
        options.addOption("i", "input", true, "Maze file to read");
        options.addOption("p", "path", true, "Verify path for the maze");

        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            logger.error("Error parsing command-line arguments: " + e.getMessage());
            cmd = null;
        }
    }

    public String getInputFile() {
        if (cmd != null && cmd.hasOption("i")) {
            return cmd.getOptionValue("i");
        }
        logger.error("Missing required input file (-i option).");
        return null;
    }

    public String getUserPath() {
        if (cmd != null && cmd.hasOption("p")) {
            return cmd.getOptionValue("p");
        }
        return null; // No user path provided, which is valid.
    }

    public boolean isValid() {
        return cmd != null && cmd.hasOption("i");
    }

}