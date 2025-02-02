package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;

public class Configuration {

    private String inputFile;
    private String inputPath;

    public Configuration(String inputFile, String inputPath) {
        // Validate inputFile existence
        File tmp = new File(inputFile);
        if (!tmp.exists()) {
            throw new IllegalArgumentException("Given file does not exist.");
        }

        // Validate the inputPath format if it's not null
        if (inputPath != null && !validPathFormat(inputPath)) {
            throw new IllegalArgumentException("Path is not provided in a valid form.");
        }

        this.inputFile = inputFile;
        this.inputPath = inputPath;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getInputPath() {
        return inputPath;
    }

    /**
     * Static method to parse the command line arguments.
     */
    public static Configuration fromArgs(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("i", true, "Must specify filepath (.txt) for maze");
        options.addOption("p", true, "Activate path sequence check for maze");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        String inputFile = null;
        String inputPath = null;

        if (cmd.hasOption("i")) {
            inputFile = cmd.getOptionValue("i");

            if (cmd.hasOption("p")) {
                inputPath = cmd.getOptionValue("p");
            }
        } else {
            throw new IllegalArgumentException("Must enter -i flag: Maze Runner access denied.");
        }

        return new Configuration(inputFile, inputPath);
    }

    /**
     * Validates the input path format to only include F, R, L, digits, and spaces.
     */
    private boolean validPathFormat(String inputPath) {
        for (int i = 0; i < inputPath.length(); i++) {
            char c = inputPath.charAt(i);
            if (!Character.isDigit(c) && c != 'F' && c != 'R' && c != 'L' && c != ' ') {
                return false;
            }
        }
        return true;
    }
}
