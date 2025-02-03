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

            // Skip any whitespace
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            // If the character is a digit
            if (Character.isDigit(c)) {
                int count = 0;
                
                // Handle the multi-digit number
                while (i < path.length() && Character.isDigit(path.charAt(i))) {
                    count = count * 10 + Character.getNumericValue(path.charAt(i));
                    i++;
                }
                
                char instruction = path.charAt(i);
                
                // Append the instruction count times
                for (int j = 0; j < count; j++) {
                    canonical.append(instruction);
                }
                i++;  // Skip the instruction character
            } else {
                // If it's a single character instruction, append it
                canonical.append(c);
                i++;
            }
        }
        return canonical.toString();
    }

}