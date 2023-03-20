package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Ingredients per cup:
        int water = 200; // milliliters
        int milk = 50; // milliliters
        int coffeeBeans = 15; // grams

        System.out.println("Write how many cups of coffee you will need:");
        int numCups = scanner.nextInt();

    }
}
