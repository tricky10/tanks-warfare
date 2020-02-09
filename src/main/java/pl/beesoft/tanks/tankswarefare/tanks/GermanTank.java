package pl.beesoft.tanks.tankswarefare.tanks;

import pl.beesoft.tanks.tankswarefare.tanks.armor.ArmorType;

class GermanTank extends Tank {
    GermanTank() {
        super(80, ArmorType.GERMAN.getMax(), "Tiger-4");
    }
}
