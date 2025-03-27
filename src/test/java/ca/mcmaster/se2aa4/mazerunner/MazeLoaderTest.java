package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MazeLoaderTest {

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
    void testValidMaze() throws IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n# # #\n#   #\n#####");
        MazeLoader loader = new MazeLoader();
        Element[][] maze = loader.generateMaze(tempFile.getAbsolutePath());
        assertEquals(5, maze.length);
        assertEquals(5, maze[0].length);
        assertEquals(Element.WALL, maze[0][0]);
        assertEquals(Element.PASS, maze[1][1]);
        assertEquals(Element.WALL, maze[2][2]);
    }

    @Test
    void testEmptyLine() throws IOException {
        File tempFile = createTempMazeFile("#####\n\n# # #\n#####");
        MazeLoader loader = new MazeLoader();
        Element[][] maze = loader.generateMaze(tempFile.getAbsolutePath());
        assertEquals(4, maze.length);
        assertEquals(5, maze[0].length);
        assertEquals(Element.PASS, maze[1][0]);
        assertEquals(Element.PASS, maze[1][4]);
    }

    @Test
    void testIOException() throws IOException {
        File tempFile = createTempMazeFile("#####");
        MazeLoader loader = new MazeLoader();
        assertDoesNotThrow(() -> {
            loader.generateMaze(tempFile.getAbsolutePath());
        });
    }
}