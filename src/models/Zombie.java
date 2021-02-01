package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Zombie {

    protected int baseHP;
    protected int speed;
    protected int attack;
    protected int arms = roll(0,2);
    protected int legs = roll(0,2);

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


    public static int roll(int min, int max){
        Random roll = new Random();
        int dieRoll = roll.nextInt(max - min + 1) + min;
        return dieRoll;
    }

    public abstract void attack(String zombie, int rollMin, int rollMax, int attackMin, int attackMax, int baseHPMin, int baseHPMax, int speedMin, int speedMax);

    @Override
    public String toString() {
        return "Zombie{" +
                "baseHP=" + baseHP +
                ", speed=" + speed +
                ", attack=" + attack +
                ", arms=" + arms +
                ", legs=" + legs +
                '}';
    }
}
