package models;

import java.util.Random;

public abstract class Zombie {

    protected int baseHP;
    protected int speed;
    private int arms;
    private int legs;

    //getters
    public int getBaseHP() {
        return baseHP;
    }
    public int getSpeed() {
        return speed;
    }

    //setters
    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void roll(){

    }

    private void attack(){

    }

    private int getRandNum(int min, int max){
        Random rng = new Random();

        int randIndex = rng.nextInt(max - min + 1) + min;

        return randIndex;
    }


}
