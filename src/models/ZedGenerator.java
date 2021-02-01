package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ZedGenerator {
    private ArrayList<Zombie> horde = new ArrayList<>();


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
                zombieTypes(1, 3, 1);
                menu();
                break;
            case "2":
                int roll = Zombie.roll(1, 10);
                zombieTypes(1, 3, roll);
                menu();
                break;
            case "3":
                userGeneratedZombies();
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

    private void zombieTypes(int min, int max, int quantity){
        do {
            int roll = Zombie.roll(min, max);
            quantity--;
            if (roll == 1) {
                new Walker().attack("Walker", 1, 6, 8, 19, 15, 30, 6, 10);
            } else if (roll == 2) {
                new Runner().attack("Runner", 1, 8, 5, 18, 10, 22, 15, 25);
            } else {
                new Tank().attack("Tank", 1, 20, 10, 19, 45, 70, 4, 8);
            }
        } while (quantity > 0);
        //TODO: Here, we need to keep track of the number that is passed in for the quantity of zombies we need to generate. We need to loop the method until all zombies are generated. We need to do this all while keeping the max and min as seperated values that don't need to be used anywhere other than just the generation parameters.
    }

    protected static String promptForString(String prompt, boolean allowBlank) {
        if (prompt == null || prompt.isBlank()) {
            throw new IllegalArgumentException("The prompt cannot be null, empty, or just white space. prompt= " + prompt);
        }
        String input = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean inputIsInvalid = true;

        do {
            System.out.print(prompt);

            try {
                input = br.readLine();
                inputIsInvalid = input == null || (!allowBlank && input.isBlank());

                if (inputIsInvalid) {
                    System.out.println("Your input is invalid. Please try again.");
                }
            } catch (IOException ioe) {
                System.out.println("There was a problem and your input was not received. Please try again.");
            }
        } while (inputIsInvalid);

        return input;
    }

    protected static int promptForInt(String prompt, int min, int max) {
        if(min > max){
            throw new IllegalArgumentException("The min cannot exceed the max. min=" + min + "; max=" + max);
        }

        int userNum = -1;
        boolean numIsInvalid = true;

        do{
            try{
                userNum = Integer.parseInt(promptForString(prompt, false));
                numIsInvalid = userNum < min || userNum > max;
            } catch (NumberFormatException nfe){

            }

            if(numIsInvalid){
                System.out.println("You must enter a whole number between " + min + " and " + max + ". Please, try again.");
            }
        } while(numIsInvalid);

        return userNum;
    }

    private void userGeneratedZombies(){
        String userSelection;
        boolean isInvalid = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\nHow many zombies would you like to generate?");
            //TODO: userSelection is returning null constantly and that is not okay. It needs to wait for user input before proceeding.
            try {
                userSelection = br.readLine();
                Integer.parseInt(userSelection);
                isInvalid = userSelection == null || userSelection.isBlank();
                zombieTypes(1, 3, Integer.parseInt(userSelection));

                if (isInvalid) {
                    System.out.println("Oof. You gave us nothing and that's just sad. Let's try that again.");
                }
            } catch (IOException ioe) {
                System.out.println("Wow, you numskull. Take a look around you. Now don't come here again.");
            }
        } while (isInvalid);



    }
}
