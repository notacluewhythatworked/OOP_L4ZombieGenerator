package models;

public class Runner extends Zombie {
    private int climbSpeed = speed / 3;
    private int damage = 0;

    public void attack(String zombie, int rollMin, int rollMax, int attackMin, int attackMax, int baseHPMin, int baseHPMax, int speedMin, int speedMax) {
        int rollCount = 2;
        int rollCount2 = 2;
        String attackMessage = "\nYou're being attacked by a " + zombie + "! They have " + arms + " arm(s) and " + legs + " leg(s). Let's roll and see how much damage you'll take.";
        setName(zombie);
        setArms(arms);
        setLegs(legs);

        setBaseHP(roll(baseHPMin, baseHPMax));
        setSpeed(roll(speedMin, speedMax));

        //sets attack variable equal to the roll to hold on to while we perform some math
        setAttack(roll(rollMin, rollMax));

        //IF statement whether the attack missed or hit
        if (attack < attackMin) {
            System.out.println("\nThe " + zombie + " attack missed! You received no damage.");
        } else if (attack > attackMin && attack < attackMax) {
            //The player took some damage, now we're rolling to find out how much, using an do/while to make sure we roll 3 times
            System.out.println(attackMessage);
            do {
                damage += roll(1, 8); //x2
                rollCount--;
            } while (rollCount > 0);
            System.out.println("Ouch! You took " + damage + " damage.");
        } else {
            //If the players d20 rolled a 20, then we need to roll some 3d6 and double the result for double damage.
            System.out.println(attackMessage);
            do {
                damage += roll(1, 8); //x2
                rollCount2--;
            } while (attack > attackMax && rollCount2 > 0);
            System.out.println("Oof. That one was a doosy and you suffered double damage! You took " + damage * 2 + " damage.");
        }
    }


    //default constructor
    public Runner() {

    }

    //custom constructor
    public Runner(int climbSpeed, int damage) {
        this.climbSpeed = climbSpeed;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nClimb Speed: " + climbSpeed +
                "\nDamage received: " + damage;
    }
}
