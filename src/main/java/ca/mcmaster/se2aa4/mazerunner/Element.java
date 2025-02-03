package ca.mcmaster.se2aa4.mazerunner;

public enum Element { 
    WALL('#'), PASS(' ');

    private final char symbol;

    Element(char symbol) { 
        this.symbol = symbol; 
    }

    public char getSymbol() { 
        return this.symbol; 
    }

}
