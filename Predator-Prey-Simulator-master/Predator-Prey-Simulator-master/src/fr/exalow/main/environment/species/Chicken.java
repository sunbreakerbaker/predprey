package fr.exalow.main.environment.species;

import fr.exalow.main.entities.Entity;
import fr.exalow.main.entities.Sex;
import fr.exalow.main.environment.World;
import fr.exalow.main.environment.area.Location;
import fr.exalow.main.utils.Util;

import java.util.Random;

public class Chicken implements Entity, Animal {

    private Random rdm = new Random();
    private World world;
    private Location location;
    private Sex sex;

    public Chicken(World world) {
        this.world = world;
        this.sex = Sex.values()[rdm.nextInt(1)];
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
        world.getCell(this.location).removeAnimal(this);
        world.getCell(location).addAnimal(this);

    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public boolean canReproduceWith(Animal animal) {
        return animal instanceof Chicken && this.sex != ((Chicken) animal).getSex();
    }

    @Override
    public boolean canEat(Animal animal) {
        return animal instanceof Viper;
    }

    @Override
    public void eat(Animal animal) {
        if (canEat(animal)) {
            this.world.getEntityManager().removeEntity(animal);
        }
    }

    @Override
    public void reproduce() {
        this.world.getEntityManager().addEntity(new Chicken(world));
    }

    @Override
    public void move() {

        if (location == null) {
            this.world.getEntityManager().addEntity(this);
            this.setLocation(new Location(rdm.nextInt(world.getBorderX()), rdm.nextInt(world.getBorderY())));
            return;
        }

        do {
            location = new Location(location.getX() + Util.randInt(1, -1), location.getY() + Util.randInt(1, -1));
        } while (location.getX() > world.getBorderX() || location.getY() > world.getBorderY());

        this.setLocation(location);
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Chicken{" +
//                ", location=" + location.toString() +
                ", sex=" + sex +
                '}';
    }
}
