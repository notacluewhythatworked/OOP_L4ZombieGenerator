package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Zombie {

    protected int baseHP;
    protected int speed;
    protected int attack;
    private int arms;
    private int legs;
    private ArrayList<Zombie> zombie = new ArrayList<>();

    //getters
    public int getBaseHP() {
        return baseHP;
    }
    public int getSpeed() {
        return speed;
    }
    public int getAttack() {
        return attack;
    }

    //setters
    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setAttack(int attack) {
        this.attack = attack;
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
