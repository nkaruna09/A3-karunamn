package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RightHandAlgorithmTest {

    @TempDir
    File tempDir;

    private RightHandAlgorithm algorithm;
    private PathFormConverter converter;

    @BeforeEach
    void setUp() {
        algorithm = new RightHandAlgorithm();
        converter = new PathFormConverter();
    }

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
        Position start = maze.getWestEntry();
        Position exit = maze.getEastEntry();
        String path = algorithm.solveMaze(maze, start, exit);
        assertEquals("2F", converter.canonicalToFactorized(path));
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
        Position start = maze.getWestEntry();
        Position exit = maze.getEastEntry();
        String path = algorithm.solveMaze(maze, start, exit);
        assertEquals("F R 2F L 3F R F L F R F L 2F", converter.canonicalToFactorized(path));
    }

	@Test 
	void testSolveMaze_rectangleMaze() throws IOException { 
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
        Position start = maze.getWestEntry();
        Position exit = maze.getEastEntry();
        String path = algorithm.solveMaze(maze, start, exit);
		assertEquals("F R 7F L 4F 2L 4F R 2F R 2F 2L 2F R 16F R 2F R 14F 2L 4F R 2F R 6F 2L 4F R 2F R 6F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 2F L 2F 2L 2F R 2F L 2F R 2F L 2F R 2F R 4F R 2F L 2F R 2F 2L 2F R 2F R 2F 2L 2F L 4F R 2F L 8F R 2F 2L 2F R 6F R 2F R 2F 2L 4F R 6F R 2F R 4F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F L 4F R 2F R 6F R 4F 2L 4F R 2F R 6F L 2F 2L 2F R 2F R 4F R 2F 2L 2F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 4F 2L 4F R 2F R 10F R 2F 2L 6F 2L 4F R 8F R 2F R 6F 2L 4F R 2F R 4F 2L 2F R 2F R 4F L 6F 2L 6F R 2F R 4F 2L 4F R 2F R 4F 2L 6F R 2F R 4F 2L 6F R 2F R 2F 2L 4F R 2F R 2F L 2F R 2F R 2F L 2F R 2F 2L 2F L 2F R 2F L 2F L 2F R 2F R 2F 2L 2F R 6F R 4F R 2F R 2F L 2F 2L 2F R 2F L 2F L 2F R 2F 2L 2F R 2F R 6F R 4F R 2F R 2F 2L 2F L 4F R 2F R 4F L 2F R 2F R 4F 2L 2F R 4F 2L 4F R 2F R 6F R 4F 2L 4F R 2F R 4F L 6F R 2F L 2F R 4F 2L 4F R 2F R 6F 2L 2F R 2F R 6F 2L 2F R 2F R 4F 2L 2F R 2F R 2F 2L 2F L 2F R 2F L 2F R 4F R 2F R 2F 2L 2F R 2F R 4F 2L 4F R 2F R 6F 2L 6F R 2F R 8F R 2F 2L 2F L 6F R 2F R 6F L 2F 2L 2F R 2F R 2F 2L 2F R 2F R 2F 2L 2F R 2F L 2F R 2F R 2F 2L 2F R 2F R 4F R 4F 2L 3F R F", converter.canonicalToFactorized(path));
	}

} 