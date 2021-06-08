package eu.senla.statkevich.scooters.entity.entities;

import eu.senla.statkevich.scooters.entity.abstractEntities.EntityWithTitle;

import javax.persistence.*;

@Entity
@Table(name = "term_of_rent"
        ,uniqueConstraints = {@UniqueConstraint(columnNames = {"title","count_of_days"},name = "term_uniq")}
)
public class TermOfRent extends EntityWithTitle {

    @Column(name = "count_of_days",nullable = false)
    private int countOfDays;

    public TermOfRent() {
    }

    public TermOfRent(String title, int countOfDays) {
        super(title);
        this.countOfDays = countOfDays;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public void setCountOfDays(int countOfDays) {
        this.countOfDays = countOfDays;
    }

    @Override
    public String toString() {
        return "Term of rent: " +
                super.toString() +
                ", count of days= " + countOfDays;
    }
}
