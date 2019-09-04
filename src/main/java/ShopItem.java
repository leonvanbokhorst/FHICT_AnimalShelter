import interfaces.ISellable;

public class ShopItem implements ISellable {
    private String name;
    private double price;

    protected ShopItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return name + ", €" + price;
    }
}
