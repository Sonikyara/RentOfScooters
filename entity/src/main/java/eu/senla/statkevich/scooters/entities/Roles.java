package eu.senla.statkevich.scooters.entities;

import eu.senla.statkevich.scooters.abstractions.EntityWithTitle;

import javax.persistence.*;

@Entity
@Table(name = "roles"
        ,uniqueConstraints = {@UniqueConstraint(columnNames = "title",name = "roles_uniq")}
)
public class Roles extends EntityWithTitle {

    public Roles() {
    }

    public Roles(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Role: " + super.toString();
    }
}
