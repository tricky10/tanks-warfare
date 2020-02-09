package pl.beesoft.tanks.tankswarefare.tanks;

public class TankFactory {

    private TankFactory() {
    }

    public static Tank of(TankType type) {
        switch (type) {
            case USA:
                return new USATank();
            case FRENCH:
                return new FrenchTank();
            case GERMAN:
                return new GermanTank();
            case BRITISH:
                return new BrithishTank();
        }
        //TODO: add random vehicle to have more fun with unknown speed and defense system
        return new BrithishTank();
    }
}
