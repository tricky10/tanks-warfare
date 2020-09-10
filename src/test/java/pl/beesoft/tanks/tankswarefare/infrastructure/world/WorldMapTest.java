package pl.beesoft.tanks.tankswarefare.infrastructure.world;

import org.junit.jupiter.api.Test;
import pl.beesoft.tanks.tankswarefare.infrastructure.generator.WorldBuilder;

public class WorldMapTest {
    @Test
    public void shouldCreateRandomizedMap() {
        WorldMap map = new VeryHardMap();
        WorldBuilder.randomize(map);
    }
}
