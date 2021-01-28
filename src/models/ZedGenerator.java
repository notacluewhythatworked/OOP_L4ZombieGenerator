package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZedGenerator {

    private void menu(){
        System.out.println("Let's choose an option, shall we?");
        String userSelection = null;
        boolean isInvalid = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1) Generate 1 zombie \n2) Generate some zombies \n3) Generate a certain number of zombies \n4) Exit");
            try {
                userSelection = br.readLine();
                isInvalid = userSelection == null || userSelection.isBlank();

                if (isInvalid) {
                    System.out.println("Oof. You really screwed that one up. Let's try that again.");
                }
            } catch (IOException ioe) {
                System.out.println("Wow, you numbskull. Take a look around you. Now don't come here again.");
            }
        } while (isInvalid);

        switch (userSelection) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
        }
    }
}
