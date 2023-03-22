package machine;

import java.util.ArrayList;
import java.util.List;

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
        recipes.add(new Recipe(1, "espresso", 250, 0, 16, 4));
        recipes.add(new Recipe(2, "latte", 350, 75, 20, 7));
        recipes.add(new Recipe(3, "cappuccino", 200, 100, 12, 6));
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
        return recipes.stream()
                .filter(n -> n.getId() == recipeId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void brewCoffee(int recipeID) {
        Recipe recipe = getRecipe(recipeID);
        List<String> missingSupplies = getMissingSupplies(recipe);
        if (missingSupplies.isEmpty()) {
            System.out.println("I have enough resources, making you a coffee!");
            waterSupply -= recipe.getWater();
            milkSupply -= recipe.getMilk();
            beanSupply -= recipe.getBeans();
            cupSupply -= 1;
            moneyBalance += recipe.getCost();
        } else {
            System.out.printf("Sorry, not enough %s.%n", String.join(", ", missingSupplies));
        }
    }

    public List<String> getMissingSupplies(Recipe recipe) {
        List<String> missingSupplies = new ArrayList<>();
        if (waterSupply < recipe.getWater()) {
            missingSupplies.add("water");
        }
        if (milkSupply < recipe.getMilk()) {
            missingSupplies.add("milk");
        }
        if (beanSupply < recipe.getBeans()) {
            missingSupplies.add("coffee beans");
        }
        if (cupSupply < 1) {
            missingSupplies.add("cups");
        }
        return missingSupplies;
    }


    public void fillSupplies(int water, int milk, int beans, int cups) {
        waterSupply += water;
        milkSupply += milk;
        beanSupply += beans;
        cupSupply += cups;
    }

    public void takeMoneyOut() {
        System.out.println("I gave you $" + this.moneyBalance);
        this.moneyBalance = 0;
    }
}
