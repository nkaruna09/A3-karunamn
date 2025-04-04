/**
 * File: CheckerStrategy.java
 * Author: Nithika Karunamoorthy
 * Description: This class is responsible for validating a user-provided path through a maze.
 * It simulates each step and determines whether the path leads from one entry to the corresponding exit.
 * The class handles bidirectional checking (west-to-east and east-to-west) and uses Command pattern for path execution.
 */

package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckerStrategy implements TaskStrategy { 
    private Maze maze; 
    private String userPath;
    private PathFormConverter converter;

    private static final Map<Character, Command> COMMAND_MAP = Map.of(
        'F', new MoveForwardCommand(),
        'R', new TurnRightCommand(),
        'L', new TurnLeftCommand()
    );

    /**
     * Constructor to initialize the MazeChecker with the maze and user-provided path.
     * The path is converted into a canonical form to ensure uniformity.
     */ 
    public CheckerStrategy(Maze maze, String userPath) { 
        this.maze = maze;
        this.userPath = userPath;
        this.converter = new PathFormConverter();
        this.userPath = converter.factorizedToCanonical(userPath); // Convert path to canoncial form
    }
    
     /**
     * Solve method to return a string indicating if the user's path is correct or incorrect.
     */ 
    @Override
    public String solve() { 
       return isValidPath() ? "correct path" : "incorrect path";
    }

    /**
     * Validates if the user-provided path is correct by checking it from both the west and east entries.
     */ 
    public boolean isValidPath() {
        // Check path from both directions (west to east and east to west)
        return checkPath(maze.getWestEntry(), Direction.E, maze.getEastEntry()) || 
               checkPath(maze.getEastEntry(), Direction.W, maze.getWestEntry());
    }

    /**
     * Checks if the path from the start position to the exit is valid.
     * It simulates the user's path step by step, checking each movement and direction.
     */ 
    public boolean checkPath(Position start, Direction startDirection, Position exit) {
        Position currentPosition = new Position(start.getRow(), start.getCol());
        Compass compass = new Compass(startDirection);
        List<Command> commands = parseUserPath(userPath); // Parse the user path into commands

        for (Command command : commands) { 
            if (!command.execute(currentPosition, compass, maze)){
                return false; // If any command fails, the path is invalid
            }
        }

        return currentPosition.equals(exit); // Check if final position is at the exit 
    }

    /**
     * Parses the user-provided path string into a list of commands.
     * Each character in the string corresponds to a specific command (e.g., 'F', 'R', 'L').
     */
    private List<Command> parseUserPath(String userPath) {
        List<Command> commands = new ArrayList<>();
        for (char step : userPath.toCharArray()) {
            Command command = COMMAND_MAP.get(step);
            if (command != null) {
                commands.add(command);
            }
        }
        return commands;
    }
}
