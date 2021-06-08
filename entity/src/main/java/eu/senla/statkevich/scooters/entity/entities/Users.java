package eu.senla.statkevich.scooters.entity.entities;

import eu.senla.statkevich.scooters.entity.abstractEntities.EntityWithName;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users extends EntityWithName {

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String pass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Roles role;

    public Users() {
    }

    public Users(String name) {
        super(name);
    }

    public Users(String name, String phoneNumber, String pass) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.pass = pass;
    }

    public Users(String name, String phoneNumber, String pass,Roles role) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        this.role=role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User: " +
                super.toString() +
                ", phone number= " + phoneNumber +
                ", pass= " + pass;
    }
}
