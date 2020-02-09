package pl.beesoft.tanks.tankswarefare.tanks;

import pl.beesoft.tanks.tankswarefare.tanks.armor.ArmorType;

class USATank extends Tank {
    USATank() {
        super(100, ArmorType.USA.getMax(), "T-800");
    }

}
