package pl.beesoft.tanks.tankswarefare.battle;

/**
 * Create simple battle
 */
public class BattleFactory {

    private BattleFactory() {
    }

    public static final Battle simple() {
        return new SimpleBattle();
    }
}
