package eu.senla.statkevich.scooters.entities;

import eu.senla.statkevich.scooters.abstractions.EntityWithTitle;

import javax.persistence.*;

@Entity
@Table(name = "type_of_scooter")
public class TypeOfScooter extends EntityWithTitle {

    public TypeOfScooter() {
    }

    public TypeOfScooter(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Type of scooter: " +
                super.toString();
    }
}
