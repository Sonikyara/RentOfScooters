package eu.senla.statkevich.scooters.entity.abstractEntities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityWithName extends EntityMain {
    private String name;

    public EntityWithName() {
    }

    public EntityWithName(String name) {
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
