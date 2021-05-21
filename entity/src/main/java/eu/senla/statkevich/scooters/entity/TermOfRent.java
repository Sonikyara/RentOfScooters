package eu.senla.statkevich.scooters.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "term_of_rent")
public class TermOfRent extends AEntityWithTitle {

    @Column(name = "count_of_days")
    private int countOfDays;

    @OneToMany(mappedBy = "termOfRent", fetch = FetchType.LAZY)
    private List<PriceList> priceList;

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

    public List<PriceList> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceList> priceLists) {
        this.priceList = priceLists;
    }

    @Override
    public String toString() {
        return "Term of rent: " +
                super.toString() +
                ", count of days= " + countOfDays;
    }
}
