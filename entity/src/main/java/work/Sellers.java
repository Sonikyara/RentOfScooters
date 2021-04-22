package work;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="sellers")
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String adress;

    @OneToMany(mappedBy = "seller",fetch = FetchType.LAZY)
    private List<Scooters> scooters;

    public Sellers() {}

    public Sellers(String title, String adress) {
        this.name = title;
        this.adress = adress;
    }

    public int getId() {        return id;    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public String getAdress() {        return adress;    }
    public void setAdress(String adress) {        this.adress = adress;    }

    public List<Scooters> getScooters() {        return scooters;    }
    public void setScooters(List<Scooters> scooters) {        this.scooters = scooters;    }

    @Override
    public String toString() {
        return "Seller: "+
                "id= "+id+
                ", name= "+name+
                ", adress= "+adress;
    }
}
