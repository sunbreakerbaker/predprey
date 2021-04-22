package fr.exalow.main.environment.species;

public interface Animal {

    boolean canReproduceWith(Animal animal);

    boolean canEat(Animal animal);

    void eat(Animal animal);

    void reproduce();

    void move();

}
