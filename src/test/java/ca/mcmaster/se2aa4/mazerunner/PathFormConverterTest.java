package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathFormConverterTest {

    private PathFormConverter converter;

    @BeforeEach
    void setUp() {
       converter = new PathFormConverter();
    }

    @Test
    void testCanonicalToFactorized() {
        String canonical = "FFFLLRFF";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("3F 2L R 2F", factorized);
    }

    @Test
    void testFactorizedToCanonical() {
        String factorized = "3F 2L R 2F";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFLLRFF", canonical);
    }

    @Test
    void testFactorizedToCanonical_withWhitespace() {
        String factorized = " 3F  2L R 2F ";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFLLRFF", canonical);
    }

    @Test
    void testCanonicalToFactorized_emptyString() {
        String canonical = "";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("", factorized);
    }

    @Test
    void testFactorizedToCanonical_onlyWhitespace() {
        String factorized = "   ";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("", canonical);
    }

    @Test
    void testFactorizedToCanonical_multiDigitCount() {
        String factorized = "10F 2L";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFFFFFFFFLL", canonical);
    }
}