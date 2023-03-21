package machine;

public class Coffee {

    private String type;
    private int water;
    private int milk;
    private int beans;
    private int price;

    public Coffee(String type, int water, int milk, int beans, int price) {
        this.type = type;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }



    public Coffee() {

    }

    public String getType() {
        return this.type;
    }

    public int getWater() {
        return this.water;
    }

    public int getMilk() {
        return this.milk;
    }

    public int getBeans() {
        return this.beans;
    }

    public int getPrice() {
        return this.price;
    }



    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", water=" + water +
                ", milk=" + milk +
                ", beans=" + beans +
                ", price=" + price +
                '}';
    }
}
