package work;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sum;

    @ManyToOne
    @JoinColumn
    private Users user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_id", referencedColumnName = "id")
    private Rent rent;

    public Payment() {}

    public Payment(int sum, Users user, Rent rent) {
        this.sum = sum;
        this.user = user;
        this.rent = rent;
    }

    public int getId() {        return id;    }

    public int getSum() {        return sum;    }
    public void setSum(int sum) {        this.sum = sum;    }

    public Users getUser() {        return user;    }
    public void setUser(Users user) {        this.user = user;    }

    public Rent getRent() {        return rent;    }
    public void setRent(Rent rent) {        this.rent = rent;    }

    @Override
    public String toString() {
        return "Payment: "+
                ", id= "+id+
                ", sum= "+sum+
                ", from user= "+user.getName()+
                ", rent's id= "+rent.getId();
    }
}
