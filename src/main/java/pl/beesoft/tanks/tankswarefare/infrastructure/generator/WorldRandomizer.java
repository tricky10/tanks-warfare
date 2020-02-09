package pl.beesoft.tanks.tankswarefare.infrastructure.generator;

import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.util.Optional;

/**
 * Implementation for randomizing if we should add an enemy here
 */
public interface WorldRandomizer {
    Optional<Tank> enemy();

    /**
     * Apply enemies to map suing implemented algorytm
     * @param map
     */
    void apply(WorldMap map);
}
