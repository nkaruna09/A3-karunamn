// PathFormConverterTest.java
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathFormConverterTest {

    @Test
    void testCanonicalToFactorized_noRepeats() {
        PathFormConverter converter = new PathFormConverter();
        String canonical = "FRL";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("F R L", factorized);
    }

    @Test
    void testCanonicalToFactorized_withRepeats() {
        PathFormConverter converter = new PathFormConverter();
        String canonical = "FFFLLRFF";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("3F 2L R 2F", factorized);
    }

    @Test
    void testCanonicalToFactorized_singleStep() {
        PathFormConverter converter = new PathFormConverter();
        String canonical = "F";
        String factorized = converter.canonicalToFactorized(canonical);
        assertEquals("F", factorized);
    }

    @Test
    void testFactorizedToCanonical_noRepeats() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "F R L";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FRL", canonical);
    }

    @Test
    void testFactorizedToCanonical_withRepeats() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "3F 2L R 2F";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("FFFLLRFF", canonical);
    }

    @Test
    void testFactorizedToCanonical_singleStep() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "F";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("F", canonical);
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
    void testFactorizedToCanonical_emptyString() {
        PathFormConverter converter = new PathFormConverter();
        String factorized = "";
        String canonical = converter.factorizedToCanonical(factorized);
        assertEquals("", canonical);
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