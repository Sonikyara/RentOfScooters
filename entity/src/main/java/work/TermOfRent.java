package work;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="term_of_rent")
public class TermOfRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(name="count_of_days")
    private int countOfDays;

    @OneToMany(mappedBy = "termOfRent",fetch = FetchType.LAZY)
    private List<PriceList> priceList;

    public TermOfRent() {}

    public TermOfRent(String title, int countOfDays) {
        this.title = title;
        this.countOfDays = countOfDays;
    }

    public int getId() {        return id;    }

    public String getTitle() {        return title;    }
    public void setTitle(String title) {        this.title = title;    }

    public int getCountOfDays() {        return countOfDays;    }
    public void setCountOfDays(int countOfDays) {        this.countOfDays = countOfDays;    }

    public List<PriceList> getPriceList() {        return priceList;    }
    public void setPriceList(List<PriceList> priceLists) {        this.priceList = priceLists;    }

    @Override
    public String toString() {
        return "Term of rent: "+
                "id= "+id+
                ", title= "+title+
                ", count of days= "+countOfDays;
    }
}
