package ca.mcmaster.se2aa4.mazerunner;

public class Compass {

    private String direction; 

    public Compass() {
        this.direction = "E"; 
    }
   
    public boolean isPointingNorth() {
       return direction.equals("N");
    }

    public boolean isPointingSouth() {
        return direction.equals("S");
    }

    public boolean isPointingEast() {
        return direction.equals("E");
    }  

    public boolean isPointingWest() {
        return direction.equals("W");
    }

    public void turnLeft() {
        if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "E";
        } else {
            direction = "N";
        }
    }

    public void turnRight() {
        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("E")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "W";
        } else {
            direction = "N";
        }
    }

    @Override
    public String toString() {
        return "Compass is pointing" + direction;
    }

}