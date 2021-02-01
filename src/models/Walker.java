package models;

public class Walker extends Zombie {
    private int damage = 0;

    @Override
    public void attack(String zombie, int rollMin, int rollMax, int attackMin, int attackMax, int baseHPMin, int baseHPMax, int speedMin, int speedMax) {
        int rollCount = 3;
        int rollCount2 = 3;
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
            //TODO: The lovely generated zombie prints to the console because of sout. It DOES NOT get added to the database like it should. How does one do that?
        } else if (attack > attackMin && attack < attackMax) {
            //The player took some damage, now we're rolling to find out how much, using an do/while to make sure we roll 3 times
            System.out.println(attackMessage);
            do {
                damage += roll(1, 6); //x3
                rollCount--;
            } while (rollCount > 0);
            System.out.println("Ouch! You took " + damage + " damage.");
        } else {
            //If the players d20 rolled a 20, then we need to roll some 3d6 and double the result for double damage.
            System.out.println(attackMessage);
            do {
                damage += roll(1, 6); //x3
                rollCount2--;
            } while (attack == 20 && rollCount2 > 0);
            System.out.println("Oof. That one was a doosy and you suffered double damage! You took " + damage * 2 + " damage.");
        }
    }

    //default constructor
    public Walker() {

    }

    //custom constructor
    public Walker(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDamage received: " + damage;
    }
}
