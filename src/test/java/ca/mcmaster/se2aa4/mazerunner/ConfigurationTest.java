// ConfigurationTest.java
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationTest {

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
    void testValidInputFile() throws ParseException, IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        String[] args = {"-i", tempFile.getAbsolutePath()};
        Configuration config = Configuration.fromArgs(args);
        assertEquals(tempFile.getAbsolutePath(), config.getInputFile());
        assertNull(config.getInputPath());
    }

    @Test
    void testValidInputFileWithPath() throws ParseException, IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        String[] args = {"-i", tempFile.getAbsolutePath(), "-p", "FFRLL"};
        Configuration config = Configuration.fromArgs(args);
        assertEquals(tempFile.getAbsolutePath(), config.getInputFile());
        assertEquals("FFRLL", config.getInputPath());
    }

    @Test
    void testInvalidInputFile() {
        String[] args = {"-i", "non_existent_file.txt"};
        assertThrows(IllegalArgumentException.class, () -> Configuration.fromArgs(args));
    }

    @Test
    void testMissingInputFileFlag() {
        String[] args = {"-p", "FF"};
        assertThrows(IllegalArgumentException.class, () -> Configuration.fromArgs(args));
    }

    @Test
    void testInvalidPathFormat() throws ParseException, IOException {
        File tempFile = createTempMazeFile("#####\n#   #\n#####");
        String[] args = {"-i", tempFile.getAbsolutePath(), "-p", "F G"};
        assertThrows(IllegalArgumentException.class, () -> Configuration.fromArgs(args));
    }
}