package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // howMuchIngredients(scanner);
        fillMachine(scanner);


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

    public static void fillMachine(Scanner scanner) {
        // Ingredients per cup:
        final int water = 200; // milliliters
        final int milk = 50; // milliliters
        final int beans = 15; // grams

        System.out.println("Write how many ml of water the coffee machine has:");
        int amtWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int amtMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int amtBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int numCups = scanner.nextInt();

        int cupsWater = amtWater / water;
        int cupsMilk = amtMilk / milk;
        int cupsBeans = amtBeans / beans;

        int maxCups = Math.min(cupsWater, cupsMilk);
        maxCups = Math.min(cupsBeans, maxCups);

        if (numCups == maxCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (numCups < maxCups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", (maxCups - numCups));
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxCups);
        }





    }
}
