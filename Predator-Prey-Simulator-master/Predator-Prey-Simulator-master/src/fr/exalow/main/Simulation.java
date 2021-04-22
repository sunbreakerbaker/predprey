package fr.exalow.main;

import fr.exalow.main.environment.World;
import fr.exalow.main.environment.species.Animal;
import fr.exalow.main.environment.species.Chicken;
import fr.exalow.main.environment.species.Fox;
import fr.exalow.main.environment.species.Viper;

public class Simulation {

    private World world = new World(10, 5);

    public void start() {

        world.getEntityManager().addEntity(new Fox(world));
        world.getEntityManager().addEntity(new Chicken(world));
        world.getEntityManager().addEntity(new Viper(world));

        while (true) {
            for (Animal animal : world.getEntityManager().getEntities()) {
                animal.move();
            }
        }
    }
}
