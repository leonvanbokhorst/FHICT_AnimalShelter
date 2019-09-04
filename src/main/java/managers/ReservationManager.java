package managers;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Gender;

import java.util.LinkedList;
import java.util.List;

public class ReservationManager {
    private List<Animal> animals = new LinkedList<Animal>();

    public void newCat(String name, Gender gender, String badHabits) {
        Cat cat = new Cat(name, gender, badHabits);
        animals.add(cat);
    }

    public void newDog(String name, Gender gender) {
        Dog dog = new Dog(name, gender);
        animals.add(dog);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
