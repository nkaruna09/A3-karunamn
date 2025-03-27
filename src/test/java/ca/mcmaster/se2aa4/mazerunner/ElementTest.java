// ElementTest.java
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    @Test
    void testGetSymbol() {
        assertEquals('#', Element.WALL.getSymbol());
        assertEquals(' ', Element.PASS.getSymbol());
    }
}