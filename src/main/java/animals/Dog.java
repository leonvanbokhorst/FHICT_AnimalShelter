package animals;

import java.sql.Timestamp;

public class Dog extends Animal {
    private Timestamp lastWalk;

    public Dog(String name, Gender gender) {
        super(name, gender);
        lastWalk = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + lastWalk.toString();
    }

    public boolean needsWalk() {
        long now = System.currentTimeMillis();

        return now - lastWalk.getTime() > 0;
    }
}
