package animals;

import java.sql.Timestamp;

public class Reservor {

    private String name;
    private Timestamp reservedAt;

    public Reservor(String name, Timestamp reservedAt) {
        this.name = name;
        this.reservedAt = reservedAt;
    }

    public String getName() {
        return name;
    }

    public Timestamp getReservedAt() {
        return reservedAt;
    }

}
