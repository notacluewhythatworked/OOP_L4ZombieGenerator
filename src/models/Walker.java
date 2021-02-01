package models;

public class Walker extends Zombie {

    @Override
    public void attack(String zombie, int rollMin, int rollMax, int attackMin, int attackMax, int baseHPMin, int baseHPMax, int speedMin, int speedMax) {
        int rollCount = 3;
        int rollCount2 = 3;
        int damage = 0;
        String attackMessage = "\nYou're being attacked by a " + zombie + "! They have " + arms + " arm(s) and " + legs + " leg(s). Let's roll and see how much damage you'll take.";

        baseHP = roll(baseHPMin, baseHPMax);
        speed = roll(speedMin, speedMax);

        //sets attack variable equal to the roll to hold on to while we perform some math
        attack = roll(rollMin, rollMax);

        //IF statement whether the attack missed or hit
        if (attack < attackMin) {
            System.out.println("\nThe " + zombie + " attack missed! You received no damage.");
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
            System.out.println("\nOof. That one was a doosy and you suffered double damage! You took " + damage * 2 + " damage.");
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString()
                + "Walker{attack=" + attack + "}";
    }
}
