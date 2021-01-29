package models;

import java.util.Random;

public class Die {
    private int sides = 6;
    private int currentFace = 1;
    private Random roll;

    public int roll(){
        Random roll = new Random();
        int midroll = roll.nextInt(6) + 1;
        return midroll;
    }

    //getters
    public int getSides() {
        return sides;
    }
    public int getCurrentFace() {
        return currentFace;
    }

    //setters
    public void setSides(int sides) {
        this.sides = sides;
    }
    public void setCurrentFace(int currentFace) {
        this.currentFace = currentFace;
    }
}
