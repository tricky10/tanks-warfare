package pl.beesoft.tanks.tankswarefare.person;

public class PersonBuilder {

    private String name;

    public static final PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Person build() {
        return new CommonPerson(this.name);
    }

}
