package pl.beesoft.tanks.tankswarefare.core;

import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;
import pl.beesoft.tanks.tankswarefare.person.Person;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;


public class GameState implements State {


    private Person person;
    private Tank vehicle;
    private WorldMap worldMap;

    private GameState() {
    }

    private GameState(Person person, Tank vehicle, WorldMap worldMap) {
        this.person = person;
        this.vehicle = vehicle;
        this.worldMap = worldMap;
    }

    public static final State newState(Person person, Tank vehicle, WorldMap worldMap) {
        return new GameState(person, vehicle, worldMap);
    }

    public static final State empty() {
        return new GameState();
    }

    @Override
    public Person person() {
        return person;
    }

    @Override
    public Tank vehicle() {
        return vehicle;
    }


    @Override
    public WorldMap worldMap() {
        return worldMap;
    }


    @Override
    public void apply(Person person) {
        this.person = person;
    }

    @Override
    public void apply(Tank tank) {
        this.vehicle = tank;
    }

    @Override
    public void apply(WorldMap map) {
        this.worldMap = map;
    }
}
