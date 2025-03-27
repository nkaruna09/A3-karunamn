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
    void testFindEntries() throws IOException {
        File tempFile = createTempMazeFile("#####\n   \n#####");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        assertEquals(new Position(1, 0), maze.getWestEntry());
        assertEquals(new Position(1, 4), maze.getEastEntry());
    }

	@Test
	void testFindEntries_multiRowMaze2() throws IOException {
		File tempFile = createTempMazeFile(
                "###########\n" +
                "#         #\n" +
                "### ### ###\n" +
                "#     #   #\n" +
                "# # ##### #\n" +
                "# #     #  \n" +
                "### # #####\n" +
                "#   #     #\n" +
                "  # # ### #\n" +
                "# # # #   #\n" +
                "###########"
        );
		Maze maze = new Maze(tempFile.getAbsolutePath());
		assertEquals(new Position(8, 0), maze.getWestEntry());
		assertEquals(new Position(5, 10), maze.getEastEntry());
	} 
}