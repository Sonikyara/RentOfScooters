package work;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name="phone_number")
    private String phoneNumber;
    private String pass;

    @ManyToOne
    @JoinColumn
    private Roles role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Rent> rent;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Payment> payment;

    public Users() {}

    public Users(String name, String phoneNumber, String pass) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        rent=new ArrayList<>();
        payment=new ArrayList<>();
    }

    public int getId() {        return id;    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public String getPhoneNumber() {        return phoneNumber;    }
    public void setPhoneNumber(String phoneNumber) {        this.phoneNumber = phoneNumber;    }

    public String getPass() {        return pass;    }
    public void setPass(String pass) {        this.pass = pass;    }

    public Roles getRole() {        return role;    }
    public void setRole(Roles role) {        this.role = role;    }

    public List<Rent> getRent() {        return rent;    }
    public void setRent(List<Rent> rent) {        this.rent = rent;    }

    public List<Payment> getPayment() {        return payment;    }
    public void setPayment(List<Payment> payment) {        this.payment = payment;    }

    @Override
    public String toString() {
        return "User: "+
                ", id= "+id+
                ", name= "+name+
                ", phone number= "+phoneNumber+
                ", pass= "+pass;
    }
}
