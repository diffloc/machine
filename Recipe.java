package machine;

public class Recipe {

    private int id;
    private String name;
    private int water;
    private int milk;
    private int beans;
    private int cost;

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

    public String getName() {
        return name;
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
