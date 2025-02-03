/**
 * File: Element.java
 * Author: Nithika Karunamoorthy
 * Description: This enum represents the elements of the maze: WALL and PASS.
 * WALL is represented by '#', and PASS is represented by a space (' '). 
 * This enum is used to define the structure of the maze and how it is represented.
 */

package ca.mcmaster.se2aa4.mazerunner;

public enum Element { 
    WALL('#'), PASS(' ');

    private final char symbol;

    /**
     * Constructor to initialize the element with its corresponding symbol.
     */ 
    Element(char symbol) { 
        this.symbol = symbol; 
    }

    /**
     * Returns the symbol associated with the element. 
     */
    public char getSymbol() { 
        return this.symbol; 
    }

}
