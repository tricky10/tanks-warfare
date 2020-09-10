package pl.beesoft.tanks.tankswarefare.tanks;

import java.io.Serializable;

/**
 * Vehicle/Tank available for the game
 */
public abstract class Tank implements Serializable {
    protected boolean destroyed = false;

    /**
     * During fight this value will be decreased till some dies - but it will be increased when you win fight
     */
    protected int armor;
    /**
     * During fight this value will be decreased till some dies - cannot move above this value
     */
    //TODO: please implement this feature soon
    protected int maxSpeed;
    protected String name;


    Tank(int maxSpeed, int armor, String name) {
        this.maxSpeed = maxSpeed;
        this.armor = armor;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getArmor() {
        return armor;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void decreaseArmor(int by) {
        this.armor -= by;
        if (this.armor <= 0) {
            this.destroyed = true;
        }
    }


    public boolean isDestroyed() {
        return destroyed;
    }


}
