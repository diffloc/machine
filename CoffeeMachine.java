package machine;

import java.util.Scanner;

/*This solution attempts to adhere only to the practices learned
 * thus far in the Hyperskill course material. Advanced capabilities
 * available in later JDK versions (e.g. enhanced switch) are used
 * only where I became tired of the IDEs recommendations.*/

public class CoffeeMachine {

    // DEFAULT COFFEE MACHINE SUPPLIES
    static int water = 400;         // milliliters (ml)
    static int milk = 540;          // milliliters (ml)
    static int beans = 120;         // grams (g)
    static int money = 550;         // USD ($)
    static int disposableCups = 9;  // count

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        status();



        // MAIN MENU
        boolean validInput = false;
        do {
            System.out.println("Write action (buy, fill, take):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> buyOneCup(scanner);
                case "fill" -> fillSupplies(scanner);
                case "take" -> takeMoneyOut();
                default -> {
                    System.out.println("Invalid input!");
                    validInput = true;
                }
            }
        } while (validInput);
    }

    // STATUS MESSAGE
    private static void status() {
        System.out.println("The coffee machine has:\n"
                + water + " ml of water\n"
                + milk + " ml of milk\n"
                + beans + " g of coffee beans\n"
                + disposableCups + " disposable cups\n"
                + "$" + money + " of money"
        );
        System.out.println();
    }

    // Buy one cup routine
    private static void buyOneCup(Scanner scanner) {
        String type = null;
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        int price = 0;


        boolean validInput = false;
        do {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1 -> {
                    type = "espresso";
                    waterNeeded = 250;
                    beansNeeded = 16;
                    price = 4;
                }
                case 2 -> {
                    type = "latte";
                    waterNeeded = 350;
                    milkNeeded = 75;
                    beansNeeded = 20;
                    price = 7;
                }
                case 3 -> {
                    type = "cappuccino";
                    waterNeeded = 200;
                    milkNeeded = 100;
                    beansNeeded = 12;
                    price = 6;
                }
                default -> {
                    System.out.println("Invalid input!");
                    validInput = true;
                }
            }
        } while (validInput);
        Coffee coffee = new Coffee(type, waterNeeded, milkNeeded, beansNeeded, price);
        if (hasEnoughSupplies(coffee)) {
            water -= coffee.getWater();
            milk -= coffee.getMilk();
            beans -= coffee.getBeans();
            disposableCups -= 1;
            money += coffee.getPrice();
            System.out.println();
            status();
        } else {
            System.out.println("Not enough supplies!");
            status();
            System.out.println("Please restock your coffee machine.");
        }


    }

    // Fill supplies routine
    private static void fillSupplies(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        disposableCups += scanner.nextInt();
        System.out.println();
        status();
    }

    // Take out money routine
    private static void takeMoneyOut() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
        status();
    }

    private static boolean hasEnoughSupplies(Coffee coffee) {
        boolean enoughWater = water >= coffee.getWater();
        boolean enoughMilk = milk >= coffee.getMilk();
        boolean enoughBeans = beans >= coffee.getBeans();
        return enoughWater && enoughMilk && enoughBeans;
    }

}
