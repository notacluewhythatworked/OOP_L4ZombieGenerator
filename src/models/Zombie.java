package models;

import java.util.ArrayList;
import java.util.Random;

public abstract class Zombie {

    protected String name;
    protected int baseHP;
    protected int speed;
    protected int attack;
    protected int arms = roll(0,2);
    protected int legs = roll(0,2);

    //getters
    public String getName() {
        return name;
    }
    public int getBaseHP() {
        return baseHP;
    }
    public int getSpeed() {
        return speed;
    }
    public int getAttack() {
        return attack;
    }
    public int getArms() {
        return arms;
    }
    public int getLegs() {
        return legs;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setArms(int arms) {
        this.arms = arms;
    }
    public void setLegs(int legs) {
        this.legs = legs;
    }

    public static int roll(int min, int max){
        Random roll = new Random();
        int dieRoll = roll.nextInt(max - min + 1) + min;
        return dieRoll;
    }

    public abstract void attack(String zombie, int rollMin, int rollMax, int attackMin, int attackMax, int baseHPMin, int baseHPMax, int speedMin, int speedMax);

    @Override
    public String toString() {
        return getName() +
                "\nBase HP: " + getBaseHP() +
                "\nSpeed: " + getSpeed() +
                "\nAttack Strength: " + getAttack() +
                "\n# of arms: " + getArms() +
                "\n# of legs: " + getLegs();
    }
}
