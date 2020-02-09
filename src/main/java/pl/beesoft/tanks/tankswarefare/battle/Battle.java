package pl.beesoft.tanks.tankswarefare.battle;

import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.util.function.Consumer;

public interface Battle {

    void battleBetween(Tank tank1, Tank tank2, Consumer<Integer> consumer);

}
