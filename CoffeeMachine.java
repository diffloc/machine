package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        do {
            System.out.println("Write action (buy, fill, take):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    buyOneCup();
                    break;
                case "fill":
                    fillSupplied();
                    break;
                case "take":
                    takeMoneyOut();
                    break;
                default:
                    System.out.println("Invalid input!");
                    validInput = true;
                    break;
            }
        } while(validInput);




    }


    private static void buyOneCup() {
        System.out.println("Bought...");
    }

    private static void fillSupplied() {
        System.out.println("Filled...");
    }

    private static void takeMoneyOut() {
        System.out.println("Taken...");
    }

}
