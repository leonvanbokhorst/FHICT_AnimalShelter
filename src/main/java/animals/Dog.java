package animals;

import java.sql.Timestamp;

public class Dog extends Animal {
    private Timestamp lastWalk;
    private double price;
    private static int dogCount = 0;
    private static final double MIN_PRICE = 50;
    private static final double MAX_PRICE = 500;
    private static final double PRICE_DECREASE = 50;

    public Dog(String name, Gender gender) {
        super(name, gender);

        lastWalk = new Timestamp(System.currentTimeMillis());
        price = calculcatePrice();
    }

    private double calculcatePrice() {
        double price = MAX_PRICE;
        price -= dogCount++ * PRICE_DECREASE;

        if (price < MIN_PRICE) {
            price = MIN_PRICE;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + lastWalk.toString();
    }

    public boolean needsWalk() {
        long now = System.currentTimeMillis();

        return now - lastWalk.getTime() > 86400000;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
