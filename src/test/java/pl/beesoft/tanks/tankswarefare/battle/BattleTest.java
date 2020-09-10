package pl.beesoft.tanks.tankswarefare.battle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;
import pl.beesoft.tanks.tankswarefare.tanks.TankFactory;
import pl.beesoft.tanks.tankswarefare.tanks.TankType;

import java.util.Random;

public class BattleTest {
    private Random random = new Random(System.currentTimeMillis());

    @Test
    public void shouldDoBattleUntilEnemyFound() {
        Tank tank1 = TankFactory.of(TankType.USA);
        Tank tank2 = TankFactory.of(TankType.FRENCH);

        BattleFactory.simple().battleBetween(tank1, tank2,integer -> {

        });

        //One fight should not destroey any of them
        Assertions.assertThat(tank1.isDestroyed()).isFalse();
        Assertions.assertThat(tank2.isDestroyed()).isFalse();

    }

    @Test
    public void shouldBattleTillOneDestroyed() {
        Tank tank1 = TankFactory.of(TankType.USA);
        Tank tank2 = TankFactory.of(TankType.FRENCH);

        do {
            BattleFactory.simple().battleBetween(tank1, tank2,integer -> {

            });
        } while (!tank1.isDestroyed() && !tank2.isDestroyed());
        //Only one of them should be destroyed
        Assertions.assertThat(tank1.isDestroyed()).isNotEqualTo(tank2.isDestroyed());

    }

}
