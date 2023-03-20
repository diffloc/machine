package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        howMuchIngredients(scanner);


    }

    public static void howMuchIngredients(Scanner scanner) {
        // Ingredients per cup:
        int water = 200; // milliliters
        int milk = 50; // milliliters
        int coffeeBeans = 15; // grams

        System.out.println("Write how many cups of coffee you will need:");
        int numCups = scanner.nextInt();

        System.out.println("For " + numCups + " cups of coffee you will need:");
        System.out.println((water * numCups) + " ml of water");
        System.out.println((milk * numCups) + " ml of milk");
        System.out.println((coffeeBeans * numCups) + " g of coffee beans");
    }
}
