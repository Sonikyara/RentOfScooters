package eu.senla.statkevich.scooters.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AEntity() {}

    public Long getId() {        return id;    }

    public void setId(Long id) {        this.id = id;    }

    @Override
    public String toString() {
        return "id= "+id;
    }
}
