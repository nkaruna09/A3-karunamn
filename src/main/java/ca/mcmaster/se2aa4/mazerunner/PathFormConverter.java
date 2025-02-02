package ca.mcmaster.se2aa4.mazerunner;

/**
 * The PathFormConverter class provides utility methods to convert paths
 * between canonical and factorized forms. 
 * - Canonical form: A sequence of steps. 
 * - Factorized form: A compressed version with counts.
 */
public class PathFormConverter { 

    /**
     * Converts a canonical path to its factorized form.
     * 
     * @param path The canonical path string 
     * @return The factorized path string 
     */
    public String canonicalToFactorized(String path) {
        StringBuilder factorized = new StringBuilder();
        int count = 1;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == path.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    factorized.append(count);
                }
                factorized.append(path.charAt(i - 1));
                factorized.append(' ');
                count = 1;
            }
        }
        if (count > 1) {
            factorized.append(count);
        }
        factorized.append(path.charAt(path.length() - 1));
        return factorized.toString();
    }

    /**
     * Converts a factorized path back to its canonical form.
     * 
     * @param path The factorized path string 
     * @return The canonical path string 
     */
    public String factorizedToCanonical(String path) {
        StringBuilder canonical = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            if (Character.isDigit(c)) {
                int count = Character.getNumericValue(c);
                char instruction = path.charAt(i + 1);
                for (int j = 0; j < count; j++) {
                    canonical.append(instruction);
                }
                i += 2;
            } else {
                canonical.append(c);
                i++;
            }
        }
        return canonical.toString();
    }

}