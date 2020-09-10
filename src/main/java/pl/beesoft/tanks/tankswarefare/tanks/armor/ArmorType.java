package pl.beesoft.tanks.tankswarefare.tanks.armor;


public enum ArmorType {
    FRENCH(80), BRITISH(80), GERMAN(100), USA(100);

    int max;

    ArmorType(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
