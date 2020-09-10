package pl.beesoft.tanks.tankswarefare.tanks;

public enum TankType {
    USA, GERMAN, FRENCH, BRITISH;

    public static TankType from(int position) {
        return values()[position];
    }
}
