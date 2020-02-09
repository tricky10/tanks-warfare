package pl.beesoft.tanks.tankswarefare.battle;

import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.util.function.Consumer;

/**
 * Algorythm which implements battle mechanism between two vehicles
 */
public interface Battle {

    void battleBetween(Tank tank1, Tank tank2, Consumer<Integer> consumer);

}
