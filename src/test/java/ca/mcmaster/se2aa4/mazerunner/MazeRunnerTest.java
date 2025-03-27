package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MazeRunnerTest {

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
    void testCheckPath_correct() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        MazeRunner runner = new MazeRunner(maze, "2F", new RightHandAlgorithm()); 
        assertEquals("correct path", runner.solve());
    }

    @Test
    void testCheckPath_incorrect() throws IOException {
        File tempFile = createTempMazeFile("   ");
        Maze maze = new Maze(tempFile.getAbsolutePath());
        MazeRunner runner = new MazeRunner(maze, "F", new RightHandAlgorithm()); 
        assertEquals("incorrect path", runner.solve());
    }

	@Test
    void testSolveMaze_smallMaze() throws IOException {
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
        RightHandAlgorithm algorithm = new RightHandAlgorithm();
        MazeRunner runner = new MazeRunner(maze, null, algorithm);
        String expectedPath = "F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F";
        assertEquals(expectedPath, runner.solve());
    }
}