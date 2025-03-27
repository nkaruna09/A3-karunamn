package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

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
    void testFindEntries_simpleMaze() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        assertEquals(new Position(0, 0), maze.getWestEntry());
        assertEquals(new Position(0, 2), maze.getEastEntry());
    }

    @Test
    void testFindEntries_multiRowMaze() throws IOException {
        File tempFile = createTempMazeFile("#####\n   \n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        assertEquals(new Position(1, 0), maze.getWestEntry());
        assertEquals(new Position(1, 4), maze.getEastEntry());
    }

    @Test
    void testGetRowCount_getColCount() throws IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        assertEquals(3, maze.getRowCount());
        assertEquals(5, maze.getColCount());
    }

    @Test
    void testGetElement() throws IOException {
        File tempFile = createTempMazeFile("#####\n# # #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        assertEquals(Element.WALL, maze.getElement(0, 0));
		assertEquals(Element.WALL, maze.getElement(1, 2));
        assertEquals(Element.PASS, maze.getElement(1, 1));
        assertEquals(Element.PASS, maze.getElement(1, 3));
    }
}