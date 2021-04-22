package fr.exalow.main.environment.area;

import fr.exalow.main.environment.species.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal newAnimal) {

        for (Animal animal : animals) {

            if (newAnimal.canReproduceWith(animal)) {
                animal.reproduce();
                animals.add(newAnimal);
                return;
            }

            if (newAnimal.canEat(animal)) {
                newAnimal.eat(animal);
                animals.remove(animal);
                return;
            }

            if (animal.canEat(newAnimal)) {
                animal.eat(newAnimal);
                return;
            }
        }
        animals.add(newAnimal);
    }

    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public String toString() {
        return animals.toString();
    }
}
