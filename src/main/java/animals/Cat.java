package animals;

public class Cat extends Animal {
    private String badHabits;
    private static final double MIN_PRICE = 35;
    private static final double MAX_PRICE = 350;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.badHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + badHabits.toLowerCase();
    }

    @Override
    public double getPrice() {
        double price = MAX_PRICE;
        price -= badHabits.length();

        if (price < MIN_PRICE) {
            price = MIN_PRICE;
        }

        return price;
    }
}
