package eu.senla.statkevich.scooters.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AEntityWithName extends AEntity {
    private String name;

    public AEntityWithName() {
    }

    public AEntityWithName(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", name= " + name;
    }
}
