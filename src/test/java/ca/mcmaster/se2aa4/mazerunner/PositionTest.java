package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

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
    void testEquals() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        Position p3 = new Position(3, 4);
        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertNotEquals(p1, null);
        assertNotEquals(p1, new Object());
    }

    @Test
    void testStepForward_intoWall() throws IOException {
        File tempFile = createTempMazeFile("#####\n# # #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Position pos = new Position(0, 1);
        Compass compass = new Compass(Direction.N);
        assertFalse(pos.stepForward(compass, maze));
        assertEquals(0, pos.getRow());
        assertEquals(1, pos.getCol());
    }

    @Test
    void testStepForward_north() throws IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Position pos = new Position(1, 1);
        Compass compass = new Compass(Direction.N);
        assertFalse(pos.stepForward(compass, maze));
    }

    @Test
    void testStepForward_east() throws IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Position pos = new Position(1, 1);
        Compass compass = new Compass(Direction.E);
        assertTrue(pos.stepForward(compass, maze));
    }

    @Test
    void testStepForward_south() throws IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Position pos = new Position(1, 1);
        Compass compass = new Compass(Direction.S);
        assertFalse(pos.stepForward(compass, maze));
    }

    @Test
    void testStepForward_west() throws IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        Position pos = new Position(1, 1);
        Compass compass = new Compass(Direction.W);
        assertFalse(pos.stepForward(compass, maze));
    }
}