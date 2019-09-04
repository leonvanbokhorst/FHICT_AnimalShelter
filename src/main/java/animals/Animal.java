package animals;

import java.sql.Timestamp;

public class Animal {
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
            Reservor reservor = new Reservor(reserverName, time);
            this.reservor = reservor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = reservor == null ? "Not reserved" : "Reserved by " + reservor.getName();

        return name + ", " + gender + ", " + reserved;
    }
}
