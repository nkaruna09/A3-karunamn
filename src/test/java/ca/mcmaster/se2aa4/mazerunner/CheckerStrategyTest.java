package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CheckerStrategyTest {

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
    void testCorrectPath_tinyMaze() throws IOException {
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
        CheckerStrategy checker = new CheckerStrategy(maze, "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F");
        assertEquals("correct path", checker.solve());
		CheckerStrategy checker2 = new CheckerStrategy(maze, "FFFFF LL FF R FF R FF LL FF R FF R FFF"); // Correct path
        assertEquals("correct path", checker2.solve());
    }

    @Test
    void testIncorrectPath_tooShort() throws IOException {
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
        CheckerStrategy checker = new CheckerStrategy(maze, "3F");
        assertEquals("incorrect path", checker.solve());
    }

    @Test
    void testIncorrectPath_hitsWall() throws IOException {
        File tempFile = createTempMazeFile(
                "#######\n" +
                "# #    \n" +
                "### ###\n" +
                "#     #\n" +
                "### ###\n" +
                "      #\n" +
                "#######"
        );
        Maze maze = new Maze(tempFile.getAbsolutePath());
        CheckerStrategy checker = new CheckerStrategy(maze, "L 4F L");
        assertEquals("incorrect path", checker.solve());
    }

    @Test
    void testCorrectPath_rectangleMaze() throws IOException {
        File tempFile = createTempMazeFile(
                "###################################################\n" +
                "#       #   #                         #   #       #\n" +
                "# # ####### ### # ##### # # # # # ##### # # # #####\n" +
                "# #     #       #     # # # # # # #   # # # #     #\n" +
                "# # ####### ##### ##### # ######### ##### ### ### #\n" +
                "# #             # #   # #       #               # #\n" +
                "# # # ##### # # ### # ######### ### # ##### # # # #\n" +
                "# # #     # # # #   #   # #   #     #     # # # # #\n" +
                "# # # # # # # ##### ##### # # ### # # # ###########\n" +
                "# # # # # # #               #   # # # # #   #     #\n" +
                "# # ##### ### ### # # # # ##### # # ##### ### ###  \n" +
                "# #     # # #   # # # # #     # # #             # #\n" +
                "  # # ##### ######### # # # ####### # # # # # ### #\n" +
                "# # #               # # # #       # # # # # #   # #\n" +
                "# # # # # # # # ### ##### # # ####### ### # # # ###\n" +
                "# # # # # # # #   #     # # #       #   # # # #   #\n" +
                "# ### # ### # # # ### # # # # # ##### # ### # # ###\n" +
                "#   # #   # # # #   # # # # # #     # #   # # #   #\n" +
                "# ##### # ### # # # ##### ##### ####### # ### # ###\n" +
                "#     # #   # # # #   #       #       # # #   #   #\n" +
                "###################################################\n"
        );
        Maze maze = new Maze(tempFile.getAbsolutePath());
        CheckerStrategy checker = new CheckerStrategy(maze, "F R 7F L 4F 2L 4F R 2F R 2F 2L 2F R 16F R 2F R 14F 2L 4F R 2F R 6F 2L 4F R 2F R 6F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 2F L 2F R 2F R 4F R 2F L 2F R 2F 2L 2F R 2F R 2F 2L 2F L 4F R 2F L 8F R 2F 2L 2F R 6F R 2F R 2F 2L 4F R 6F R 2F R 4F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F L 4F R 2F R 6F R 4F 2L 4F R 2F R 6F L 2F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 4F 2L 4F R 2F R 10F R 2F 2L 6F 2L 4F R 8F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 4F L 6F 2L 6F R 2F R 4F 2L 4F R 2F R 4F 2L 6F R 2F R 4F 2L 6F R 2F R 2F 2L 4F R 2F R 2F L 2F R 2F R 2F L 2F R 2F 2L 2F L 2F R 2F L 2F L 2F R 2F R 2F 2L 2F R 6F R 4F R 2F R 2F L 2F 2L 2F R 2F L 2F L 2F R 2F 2L 2F R 2F R 6F R 4F R 2F R 2F 2L 2F L 4F R 2F R 4F L 2F R 2F R 4F 2L 2F R 4F 2L 4F R 2F R 6F R 4F 2L 4F R 2F R 4F L 6F R 2F L 2F R 4F 2L 4F R 2F R 6F 2L 2F R 2F R 6F 2L 2F R 2F R 4F 2L 2F R 2F R 2F 2L 2F L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 8F R 2F 2L 2F L 6F R 2F R 6F L 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F 2L 2F R 2F L 2F R 2F R 2F 2L 2F R 2F R 4F R 4F 2L 3F R F"); 
        assertEquals("correct path", checker.solve());
    }
}