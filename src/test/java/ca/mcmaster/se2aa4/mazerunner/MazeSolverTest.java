package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void testMazeSolverConstructor() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = mock(Algorithm.class);
        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        assertNotNull(mazeSolver);
        
    }

    @Test
    void testSolve_simpleMaze() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = mock(Algorithm.class);
        PathFormConverter converter = new PathFormConverter();

        // mock algorithm
        when(algorithm.solveMaze(any(Maze.class), any(Position.class), any(Position.class))).thenReturn("FF");

        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        String expected = converter.canonicalToFactorized("FF");
        String actual = mazeSolver.solve();

        assertEquals(expected, actual);
        verify(algorithm, times(1)).solveMaze(eq(maze), any(Position.class), any(Position.class));
    }

    @Test
    void testSolve_mazeWithTurns() throws IOException {
        File tempFile = createTempMazeFile(
                " # \n" +
                "   "
        );
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = mock(Algorithm.class);
        PathFormConverter converter = new PathFormConverter();

        when(algorithm.solveMaze(any(Maze.class), any(Position.class), any(Position.class))).thenReturn("RFFLFF");

        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        String expected = converter.canonicalToFactorized("RFFLFF");
        String actual = mazeSolver.solve();

        assertEquals(expected, actual);
        verify(algorithm, times(1)).solveMaze(eq(maze), any(Position.class), any(Position.class));
    }

    @Test
    void testSolve_emptyPath() throws IOException {
        File tempFile = createTempMazeFile("  ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = mock(Algorithm.class);
        PathFormConverter converter = new PathFormConverter();

        when(algorithm.solveMaze(any(Maze.class), any(Position.class), any(Position.class))).thenReturn("");

        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        String expected = converter.canonicalToFactorized("");
        String actual = mazeSolver.solve();

        assertEquals(expected, actual);
        verify(algorithm, times(1)).solveMaze(eq(maze), any(Position.class), any(Position.class));
    }

    @Test
    void testSolve_noExit() throws IOException {
        File tempFile = createTempMazeFile(" ##");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Algorithm algorithm = mock(Algorithm.class);
        PathFormConverter converter = new PathFormConverter();

        // The algorithm might return null or an empty string if no exit is found
        when(algorithm.solveMaze(any(Maze.class), any(Position.class), any(Position.class))).thenReturn(null);

        MazeSolver mazeSolver = new MazeSolver(maze, algorithm);
        String expected = converter.canonicalToFactorized(null); // Should handle null gracefully
        String actual = mazeSolver.solve();

        assertEquals(expected, actual);
        verify(algorithm, times(1)).solveMaze(eq(maze), any(Position.class), eq(null)); 
    }
}