package work;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "producer",fetch = FetchType.LAZY)
    private List<TypesProducers> typesProducers;

    public Producer() {}

    public Producer(String name) {
        this.name = name;
        typesProducers=new ArrayList<>();
    }

    public int getId() {        return id;    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public List<TypesProducers> getTypesProducers() {        return typesProducers;    }
    public void setTypesProducers(List<TypesProducers> typesProducers) {        this.typesProducers = typesProducers;    }

    @Override
    public String toString() {
        return "Producer: "+
                "id= "+id+
                ", name= "+name;
    }
}
