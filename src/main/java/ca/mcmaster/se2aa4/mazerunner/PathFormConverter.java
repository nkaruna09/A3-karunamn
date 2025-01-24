package ca.mcmaster.se2aa4.mazerunner;

public class PathFormConverter { 
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
                count = 1;
            }
        }
        if (count > 1) {
            factorized.append(count);
        }
        factorized.append(path.charAt(path.length() - 1));
        return factorized.toString();
    }

    public String factorizedToCanonical(String path) {
        StringBuilder canonical = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);
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