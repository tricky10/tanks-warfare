package pl.beesoft.tanks.tankswarefare.infrastructure.exploration;

import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;

import java.util.logging.Logger;

/**
 * Exploration of world map
 */
public class Explore {
    private static final Logger log = Logger.getLogger(Explore.class.getName());

    private WorldMap map;

    public Explore using(WorldMap map) {
        this.map = map;
        return this;
    }

    public Explore toPosition(int column, int row) {
        this.map.moveTo(column, row);
        return this;
    }


}
