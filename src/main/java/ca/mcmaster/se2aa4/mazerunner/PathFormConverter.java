/**
 * File: PathFormConverter.java
 * Author: Nithika Karunamoorthy
 * Description: The PathFormConverter class provides utility methods to convert paths
 * between two different formats:
 * - Canonical form: A simple sequence of steps (e.g., "FFRFL").
 * - Factorized form: A compressed version of the path with counts (e.g., "2F 1R 1F 1L").
 * These methods are used to help with path representation in the maze-solving application.
 */

package ca.mcmaster.se2aa4.mazerunner;

public class PathFormConverter { 

    /**
     * Converts a canonical path to its factorized form.
     */
    public String canonicalToFactorized(String path) {
        if (path == null || path.isEmpty()) {
            return "";
        }

        StringBuilder factorized = new StringBuilder();
        int count = 1; // To count consecutive similar steps
        for (int i = 1; i < path.length(); i++) { // Iterate through the path starting from the second character
            if (path.charAt(i) == path.charAt(i - 1)) { // If current step is the same as the previous one
                count++; 
            } else {
                if (count > 1) {
                    factorized.append(count);
                }
                factorized.append(path.charAt(i - 1)); // Append the current step
                factorized.append(' ');
                count = 1; // Reset the count for the new step
            }
        }

        // Append the last set of steps if there are any
        if (count > 1) {
            factorized.append(count); // If count > 1, append the count to the factorized path
        }
        factorized.append(path.charAt(path.length() - 1));
       
        return factorized.toString(); // Return the factorized path
    }

    /**
     * Converts a factorized path back to its canonical form.
     */
    public String factorizedToCanonical(String path) {
        if (path == null || path.isEmpty()) {
            return "";
        }
        StringBuilder canonical = new StringBuilder();
        int i = 0;
        while (i < path.length()) { // Iterate through the factorized path
            char c = path.charAt(i);
            
            if (Character.isWhitespace(c)) { // Skip any whitespace
                i++;
                continue;
            }
    
            if (Character.isDigit(c)) { // If the character is a digit
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