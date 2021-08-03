package eu.senla.statkevich.scooters.entities;

import eu.senla.statkevich.scooters.abstractions.EntityWithName;

import javax.persistence.*;

@Entity
@Table(name = "producer")
public class Producer extends EntityWithName {

    public Producer() {
    }

    public Producer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Producer: " +
                super.toString();
    }
}
