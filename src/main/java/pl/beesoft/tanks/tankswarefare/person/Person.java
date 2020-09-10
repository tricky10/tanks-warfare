package pl.beesoft.tanks.tankswarefare.person;

import java.io.Serializable;

public abstract class Person implements Serializable {

    protected String name;
    protected int experience;

    public void improveExperienceBy(int value) {
        this.experience += value;
    }

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
