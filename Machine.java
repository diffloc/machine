package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {

    private int waterSupply;
    private int milkSupply;
    private int beanSupply;
    private int cupSupply;
    private int moneyBalance;
    private ArrayList<Recipe> recipes;

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.waterSupply = water;
        this.milkSupply = milk;
        this.beanSupply = beans;
        this.cupSupply = cups;
        this.moneyBalance = money;
        loadRecipes();

    }

    protected void loadRecipes() {
        // TODO: load from a CSV
        recipes = new ArrayList<>();
        recipes.add(new Recipe(1, "espresso", 1250, 0, 16, 4));
        recipes.add(new Recipe(2, "latte", 350, 75, 20, 7));
        recipes.add(new Recipe(3, "cappuccino", 200, 100, 12, 6));
    }

    public int getWater() {
        return this.waterSupply;
    }

    public int getMilk() {
        return this.milkSupply;
    }

    public int getBeans() {
        return this.beanSupply;
    }

    public int getCups() {
        return this.cupSupply;
    }

    public int getMoney() {
        return this.moneyBalance;
    }

    public void status() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n", waterSupply);
        System.out.printf("%d of milk\n", milkSupply);
        System.out.printf("%d of coffee beans\n", beanSupply);
        System.out.printf("%d of disposable cups\n", cupSupply);
        System.out.printf("$%d of money\n", moneyBalance);
    }
    public Recipe getRecipe(int recipeId) {
        Recipe recipe = recipes.stream()
                .filter (n -> n.getId() == recipeId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return recipe;
    }
    public void brewCoffee(int recipeID) {
        Recipe recipe = getRecipe(recipeID);
        if (hasEnoughSupplies(recipeID)) {
            waterSupply -= recipe.getWater();
            moneyBalance -= recipe.getMilk();
            beanSupply -= recipe.getBeans();
            cupSupply -= 1;
            moneyBalance += recipe.getCost();
            status();
        } else {
            System.out.println("Not enough supplies!");
            status();
            System.out.println("Please restock your coffee machine.");
        }

    }
    public boolean hasEnoughSupplies(int recipeId) {
        Recipe recipe = getRecipe(recipeId);
        boolean enoughWater = waterSupply >= recipe.getWater();
        boolean enoughMilk = milkSupply >= recipe.getMilk();
        boolean enoughBeans = beanSupply >= recipe.getBeans();
        boolean enoughCups = cupSupply >= 1;
        return enoughWater && enoughMilk && enoughBeans && enoughCups;

    }
    public void fillSupplies(int water, int milk, int beans, int cups) {
        waterSupply += water;
        milkSupply += milk;
        beanSupply += beans;
        cupSupply += cups;
        System.out.println();
        status();
    }
    public  void takeMoneyOut() {
        System.out.println("I gave you $" + this.moneyBalance);
        this.moneyBalance = 0;
        status();
    }
}
