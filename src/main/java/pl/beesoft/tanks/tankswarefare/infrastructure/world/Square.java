package pl.beesoft.tanks.tankswarefare.infrastructure.world;

import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.io.Serializable;

public class Square implements Serializable {

    private Tank enemy;

    public void apply(Tank vehicle) {
        this.enemy = vehicle;
    }


    public Tank getEnemy() {
        return this.enemy;
    }
}
