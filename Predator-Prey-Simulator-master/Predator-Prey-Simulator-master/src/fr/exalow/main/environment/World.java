package fr.exalow.main.environment;

import fr.exalow.main.environment.area.Cell;
import fr.exalow.main.environment.area.Location;
import fr.exalow.main.manager.EntityManager;

public class World {

    private EntityManager manager = new EntityManager();

    private Cell[][] map;
    private int borderX;
    private int borderY;

    public World(int x, int y) {
        this.borderX = x;
        this.borderY = y;
        this.map = new Cell[x][y];
    }

    public void print() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                System.out.print("[" + map[y][x].toString() + "] ");
            }
            System.out.println();
        }
    }

    public int getBorderX() {
        return borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public Cell getCell(Location location) {
        return map[location.getX()][location.getY()];
    }

    public EntityManager getEntityManager() {
        return manager;
    }
}
