package pl.beesoft.tanks.tankswarefare.battle;

import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Simple battle implementation
 */
class SimpleBattle implements Battle {
    private static final int MAX_STRENGTH = 10;
    private static final Logger log = Logger.getLogger(Battle.class.getName());

    private Random random = new Random(System.currentTimeMillis());

    /**
     * Battle between tanks - do nt show the result of the armor just who wins and by how many points decreased to have more fun
     *
     * @param tank1
     * @param tank2
     */
    public void battleBetween(Tank tank1, Tank tank2, Consumer<Integer> consumer) {
        log.info(String.format("Battle begins between %s and %s", tank1.getName(), tank2.getName()));

        int tank1Power = random.nextInt(MAX_STRENGTH);
        int tank2Power = random.nextInt(MAX_STRENGTH);

        tank1.decreaseArmor(tank2Power);
        tank2.decreaseArmor(tank1Power);

        log.info(String.format("Battle between %s and %s finished with decreasing %d and %d", tank1.getName(), tank2.getName(), tank2Power, tank1Power));

        log.info(String.format("Battle tank1:%s destroyed:%s", tank1.getName(), tank1.isDestroyed()));
        log.info(String.format("Battle tank2:%s destroyed:%s", tank2.getName(), tank2.isDestroyed()));


        consumer.accept(tank2Power);
    }
}
