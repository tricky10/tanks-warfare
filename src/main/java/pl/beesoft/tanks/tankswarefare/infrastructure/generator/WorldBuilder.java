package pl.beesoft.tanks.tankswarefare.infrastructure.generator;

import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;

public class WorldBuilder {
    private static WorldRandomizer worldRandomizer = new SimpleWorldRandomizer();
    private WorldBuilder() {
    }

    public static WorldMap randomize(WorldMap map){
        worldRandomizer.apply(map);
        return map;
    }
}
