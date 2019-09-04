package animals;

public class Cat extends Animal {
    private String badHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.badHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + badHabits.toLowerCase();
    }
}
