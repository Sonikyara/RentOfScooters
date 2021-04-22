package work;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="type_producers")
public class TypesProducers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Producer producer;

    @ManyToOne
    @JoinColumn
    private TypeOfScooter scootersType;

    @OneToMany(mappedBy = "seller",fetch = FetchType.LAZY)
    private List<Scooters> typeProducer;

    public TypesProducers() {}

    public int getId() {        return id;    }

    public Producer getProducer() {        return producer;    }
    public void setProducer(Producer producer) {        this.producer = producer;    }

    public TypeOfScooter getScooter() {        return scootersType;    }
    public void setScooter(TypeOfScooter scooter) {        this.scootersType = scooter;    }

    public List<Scooters> getTypeProducer() {        return typeProducer;    }
    public void setTypeProducer(List<Scooters> typeProducer) {        this.typeProducer = typeProducer;    }

    @Override
    public String toString() {
        return "Type-producer: "+
                "id= "+id;
    }
}
