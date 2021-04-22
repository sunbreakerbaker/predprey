package fr.exalow.main.entities;

import fr.exalow.main.environment.area.Location;

public interface Entity {

    void setLocation(Location location);

    Location getLocation();

}
