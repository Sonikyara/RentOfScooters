package eu.senla.statkevich.scooters.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_start")
    private Date dateStart;
    @Column(name="date_end")
    private Date dateEnd;

    @ManyToOne
    @JoinColumn
    private Scooters scooter;

    @ManyToOne
    @JoinColumn
    private Users user;

    @ManyToOne
    @JoinColumn
    private PriceList price;

    @OneToOne(mappedBy="rent",fetch = FetchType.LAZY)
    private Payment payment;

    public Rent() {}

    public Long getId() {        return id;    }

    public Date getDateStart() {        return dateStart;    }
    public void setDateStart(Date dateStart) {        this.dateStart = dateStart;    }

    public Date getDateEnd() {        return dateEnd;    }
    public void setDateEnd(Date dateEnd) {        this.dateEnd = dateEnd;    }

    public Scooters getScooter() {        return scooter;    }
    public void setScooter(Scooters scooter) {        this.scooter = scooter;    }

    public Users getUser() {        return user;    }
    public void setUser(Users user) {        this.user = user;    }

    public PriceList getPrice() {        return price;    }
    public void setPrice(PriceList price) {        this.price = price;    }

    public Payment getPayment() {        return payment;    }
    public void setPayment(Payment payment) {        this.payment = payment;    }

    @Override
    public String toString() {
        return "id: "+id+
                ",scooters- "+scooter.getModel()+
                ",user "+user.getName()+
                ",price №"+price.getId()+
                ",from "+dateStart+
                "-to "+dateEnd;
    }
}
