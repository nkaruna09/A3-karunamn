// PathFormConverterTest.java
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathFormConverterTest {

    @Test
    void testCanonicalToFactorized() {
        PathFormConverter converter = new PathFormConverter();
        String canonical = "FFFLLRFF";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("3F 2L R 2F", factorized);
    }

    @Test
    void testFactorizedToCanonical() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "3F 2L R 2F";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFLLRFF", canonical);
    }

    @Test
    void testFactorizedToCanonical_withWhitespace() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = " 3F  2L R 2F ";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFLLRFF", canonical);
    }

    @Test
    void testCanonicalToFactorized_emptyString() {
        PathFormConverter converter = new PathFormConverter();
        String canonical = "";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("", factorized);
    }

    @Test
    void testFactorizedToCanonical_onlyWhitespace() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "   ";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("", canonical);
    }

    @Test
    void testFactorizedToCanonical_multiDigitCount() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "10F 2L";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFFFFFFFFLL", canonical);
    }
}