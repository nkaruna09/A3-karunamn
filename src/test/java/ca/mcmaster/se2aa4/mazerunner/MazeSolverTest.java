package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MazeSolverTest {

    @TempDir
    File tempDir;

    private File createTempMazeFile(String content) throws IOException {
        File tempFile = new File(tempDir, "temp_maze.txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(content);
        }
        return tempFile;
    }

	// dummy algorithm for testing
	private static class TestAlgorithm implements Algorithm { 
		private String solution; 
		public TestAlgorithm(String solution) { 
			this.solution = solution; 
		}
		@Override
		public String solveMaze(Maze maze, Position start, Position end) {
			return solution; 
		}
	}

    @Test
    void testSolve_simpleMaze() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = new TestAlgorithm("FF");
        PathFormConverter converter = new PathFormConverter();

        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        String expected = converter.canonicalToFactorized("FF");
        String actual = mazeSolver.solve();

        assertEquals(expected, actual);
    }

    @Test
    void testSolve_mazeWithTurns() throws IOException {
        File tempFile = createTempMazeFile(
				"#######\n" + 
				"#      \n" + 
				"### ###\n" + 
				"#     #\n" + 
				"### ###\n" + 
				"      #\n" + 
				"#######" 
        );
       Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = new TestAlgorithm("FFFFFLLFFRFFRFFLLFFRFFRFFF");
        PathFormConverter converter = new PathFormConverter();

        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        String expected = converter.canonicalToFactorized("FFFFFLLFFRFFRFFLLFFRFFRFFF");
        String actual = mazeSolver.solve();

        assertEquals(expected, actual);
    }
}