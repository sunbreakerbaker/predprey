package fr.exalow.main.manager;

import fr.exalow.main.environment.species.Animal;

import java.util.LinkedList;
import java.util.List;

public class EntityManager {

    private List<Animal> entities = new LinkedList<>();

    public void addEntity(Animal animal) {
        this.entities.add(animal);
    }

    public void removeEntity(Animal animal) {
        this.entities.remove(animal);
    }

    public long getEntityNumber(Animal animal) {
        return this.entities.stream()
                .filter((e) -> e.getClass() == animal.getClass())
                .count();
    }

    public List<Animal> getEntities() {
        return entities;
    }
}
