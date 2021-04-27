package eu.senla.statkevich.scooters.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AEntityWithTitle extends AEntity{
    private String title;

    public AEntityWithTitle() {    }

    public AEntityWithTitle(String title) {
        super();
        this.title = title;    }

    public String getTitle() {        return title;    }
    public void setTitle(String title) {        this.title = title;    }

    @Override
    public String toString() {
        return super.toString()+
                ", title= "+title;
    }
}
