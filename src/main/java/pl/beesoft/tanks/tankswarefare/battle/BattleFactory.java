package pl.beesoft.tanks.tankswarefare.battle;

public class BattleFactory {

    private BattleFactory() {
    }

    public static final Battle simple() {
        return new SimpleBattle();
    }
}
