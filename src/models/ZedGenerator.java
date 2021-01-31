package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZedGenerator {

    public void run() throws IOException {
        menu();
    }

    private void menu() throws IOException {
        System.out.println("\nLet's choose an option, shall we?");
        String userSelection = null;
        boolean isInvalid = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1) Generate 1 zombie \n2) Generate some zombies \n3) Generate a certain number of zombies \n4) Exit");
            try {
                userSelection = br.readLine();
                isInvalid = userSelection == null || userSelection.isBlank();

                if (isInvalid) {
                    System.out.println("Oof. You gave us nothing and that's just sad. Let's try that again.");
                }
            } catch (IOException ioe) {
                System.out.println("Wow, you numskull. Take a look around you. Now don't come here again.");
            }
        } while (isInvalid);

        switch (userSelection) {
            case "1":
                zombieTypes(1,3);
                menu();
                break;
            case "2":
                zombieTypes(1,10);
                menu();
                break;
            case "3":
                System.out.println("How many zombies would you like to generate?");
                zombieTypes(1, Integer.parseInt(userSelection));
                menu();
                break;
            case "4":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("That was out of bounds. Please try something different.");
                menu();
        }
    }

    private void zombieTypes(int min, int max){
        int roll = Zombie.roll(min, max);
        if (roll == 1){
            new Walker().attack("Walker",1,6,8,19,15,30,6,10);
        } else if (roll == 2){
            new Runner().attack("Runner",1,8,5,18,10,22,15,25);
        } else {
            new Tank().attack("Tank",1,20,10,19,45,70,4,8);
        }
    }
}
