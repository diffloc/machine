package machine;

import java.util.Scanner;

public class UserInterface {
    private final Machine machine;
    private final Scanner scanner;

    public UserInterface(Machine machine) {
        this.machine = machine;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> buyMenu();
                // case "fill" -> machine.fillSupplies();
                case "fill" -> fillMenu();
                case "take" -> machine.takeMoneyOut();
                case "remaining" -> machine.status();
                case "exit" -> exit = true;
                default -> System.out.println("Invalid input!");
            }
        } while (!exit);
    }

    private void buyMenu() {
        boolean validInput = false;
        do {
            System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1", "2", "3" -> machine.brewCoffee(Integer.parseInt(selection));
                case "back" -> System.out.println("--BACK--");
                default -> {
                    System.out.println("Invalid input!");
                    validInput = true;
                }
            }
        } while (validInput);
    }

    private void fillMenu() {
        System.out.println("\nWrite how many ml of water you want to add: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int cups = scanner.nextInt();
        machine.fillSupplies(water, milk, beans, cups);
        scanner.nextLine();
    }
}