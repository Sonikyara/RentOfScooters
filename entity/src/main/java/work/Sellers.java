package work;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="sellers")
public class Sellers extends AEntityWithName{

    private String adress;

    @OneToMany(mappedBy = "seller",fetch = FetchType.LAZY)
    private List<Scooters> scooters;

    public Sellers() {}

    public Sellers(String name, String adress) {
        super(name);
        this.adress = adress;
    }

    public String getAdress() {        return adress;    }
    public void setAdress(String adress) {        this.adress = adress;    }

    public List<Scooters> getScooters() {        return scooters;    }
    public void setScooters(List<Scooters> scooters) {        this.scooters = scooters;    }

    @Override
    public String toString() {
        return "Seller: "+
                super.toString()+
                ", adress= "+adress;
    }
}
