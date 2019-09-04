package animals;

import interfaces.ISellable;

import java.sql.Timestamp;

public abstract class Animal implements ISellable {
    private String name;
    private Gender gender;
    private Reservor reservor;

    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean reserve(String reserverName) {
        if (reservor == null) {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            this.reservor = new Reservor(reserverName, time);
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String reserved = reservor == null ? "Not reserved" : "Reserved by " + reservor.getName();

        return name + ", " + gender + ", " + reserved + ", €" + getPrice();
    }
}
