package pl.beesoft.tanks.tankswarefare.tanks;

import pl.beesoft.tanks.tankswarefare.tanks.armor.ArmorType;

class FrenchTank extends Tank {
    FrenchTank() {
        super(65, ArmorType.FRENCH.getMax(), "AT-100");
    }
}
