package pl.beesoft.tanks.tankswarefare.core;

import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;
import pl.beesoft.tanks.tankswarefare.person.Person;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.io.Serializable;

/**
 * States keeps current game state with person vehicle and other equipment - this object is persisted in DB
 */
public interface State extends Serializable {
    Person person();

    Tank vehicle();

    WorldMap worldMap();

    void apply(Person person);

    void apply(Tank tank);

    void apply(WorldMap map);

}
