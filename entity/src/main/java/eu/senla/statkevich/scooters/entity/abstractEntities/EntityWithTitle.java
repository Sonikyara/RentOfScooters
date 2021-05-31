package eu.senla.statkevich.scooters.entity.abstractEntities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityWithTitle extends EntityMain {
    private String title;

    public EntityWithTitle() {
    }

    public EntityWithTitle(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", title= " + title;
    }
}
