package pl.beesoft.tanks.tankswarefare.tanks;

import pl.beesoft.tanks.tankswarefare.tanks.armor.ArmorType;

class BrithishTank extends Tank {
    BrithishTank() {
        super(90, ArmorType.BRITISH.getMax(), "B-200");
    }
}
