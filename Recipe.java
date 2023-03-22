package machine;

public class Recipe {

    private final int id;
    private final String name;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cost;

    public Recipe(int id, String name, int water, int milk, int beans, int cost) {
        this.id = id;
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }


    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }
}
