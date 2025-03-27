package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RightHandAlgorithmTest {

    @TempDir
    File tempDir;

    private File createTempMazeFile(String content) throws IOException {
        File tempFile = new File(tempDir, "temp_maze.txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(content);
        }
        return tempFile;
    }

    @Test
    void testSolveMaze_simpleStraightPath() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        RightHandAlgorithm algorithm = new RightHandAlgorithm();
        Position start = maze.getWestEntry();
        Position exit = maze.getEastEntry();
        String path = algorithm.solveMaze(maze, start, exit);
		PathFormConverter converter = new PathFormConverter();
        assertEquals("2F", converter.canonicalToFactorized(path));
    }

    @Test
    void testSolveMaze_longerStraightMaze() throws IOException {
        File tempFile = createTempMazeFile("    ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        RightHandAlgorithm algorithm = new RightHandAlgorithm();
        Position start = maze.getWestEntry();
        Position exit = maze.getEastEntry();
        String path = algorithm.solveMaze(maze, start, exit);
		PathFormConverter converter = new PathFormConverter();
        assertEquals("3F", converter.canonicalToFactorized(path));
    }

    @Test
    void testSolveMaze_directMaze() throws IOException {
        File tempFile = createTempMazeFile(
                "########\n" +
                "  ######\n" +
                "# ######\n" +
                "#     ##\n" +
                "####  ##\n" +
                "#####   \n" +
                "########"
        );
        Maze maze = new Maze(tempFile.getAbsolutePath());
        RightHandAlgorithm algorithm = new RightHandAlgorithm();
        Position start = maze.getWestEntry();
        Position exit = maze.getEastEntry();
        String path = algorithm.solveMaze(maze, start, exit);
		PathFormConverter converter = new PathFormConverter();
        assertEquals("F R 2F L 3F R F L F R F L 2F", converter.canonicalToFactorized(path));
    }

} 