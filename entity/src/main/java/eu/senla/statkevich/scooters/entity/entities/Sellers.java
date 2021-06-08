package eu.senla.statkevich.scooters.entity.entities;

import eu.senla.statkevich.scooters.entity.abstractions.EntityWithName;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Sellers extends EntityWithName {

    @Column(nullable = false)
    private String adress;

    public Sellers() {
    }

    public Sellers(String name, String adress) {
        super(name);
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Seller: " +
                super.toString() +
                ", adress= " + adress;
    }
}
