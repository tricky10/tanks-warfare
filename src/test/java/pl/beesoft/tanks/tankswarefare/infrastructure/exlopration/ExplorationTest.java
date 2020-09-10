package pl.beesoft.tanks.tankswarefare.infrastructure.exlopration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.beesoft.tanks.tankswarefare.infrastructure.exploration.Explore;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.VeryHardMap;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;

public class ExplorationTest {
    @Test
    public void shouldMoveToSomePossiblePosition() {
        WorldMap map = new VeryHardMap();
        new Explore().using(map).toPosition(10, 10);
    }

    @Test
    public void shouldMoveToSomeBadPosition() {
        WorldMap map = new VeryHardMap();
        Assertions.catchThrowable(() -> {
            new Explore().using(map).toPosition(513, 514);
        });
    }
}
