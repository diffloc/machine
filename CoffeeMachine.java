package machine;

public class CoffeeMachine {
    public static void main(String[] args) {

        // Stage 6/6 done!
        // DEFAULT COFFEE MACHINE SUPPLIES
        int water = 400;         // milliliters (ml)
        int milk = 540;          // milliliters (ml)
        int beans = 120;         // grams (g)
        int disposableCups = 9;  // count
        int money = 550;         // USD ($)
        Machine machine = new Machine(water, milk, beans, disposableCups, money);
        UserInterface ui = new UserInterface(machine);
        ui.run();

    }
}
