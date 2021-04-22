package work;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="type_of_scooter")
public class TypeOfScooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @OneToMany(mappedBy = "scootersType",fetch = FetchType.LAZY)
    private List<TypesProducers> typesProducers;

    public TypeOfScooter() {}

    public TypeOfScooter(String title) {
        this.title = title;
        typesProducers=new ArrayList<>();
    }

    public int getId() {        return id;    }

    public String getTitle() {        return title;    }
    public void setTitle(String title) {        this.title = title;    }

    public List<TypesProducers> getTypesProducers() {        return typesProducers;    }
    public void setTypesProducers(List<TypesProducers> typesProducers) {        this.typesProducers = typesProducers;    }

    @Override
    public String toString() {
        return "Type of scooter: "+
                "id= "+id+
                ", title= "+title;
    }
}
