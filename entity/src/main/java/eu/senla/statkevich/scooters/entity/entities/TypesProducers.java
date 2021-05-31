package eu.senla.statkevich.scooters.entity.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types_producers")
public class TypesProducers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "type_of_scooter_id")
    private TypeOfScooter scootersType;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    private List<Scooters> typeProducer;

    public TypesProducers() {
    }

    public Long getId() {
        return id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public TypeOfScooter getScooter() {
        return scootersType;
    }

    public void setScooter(TypeOfScooter scooter) {
        this.scootersType = scooter;
    }

    public List<Scooters> getTypeProducer() {
        return typeProducer;
    }

    public void setTypeProducer(List<Scooters> typeProducer) {
        this.typeProducer = typeProducer;
    }

    public TypeOfScooter getScootersType() {
        return scootersType;
    }

    public void setScootersType(TypeOfScooter scootersType) {
        this.scootersType = scootersType;
    }

    @Override
    public String toString() {
        return "Type-producer: " +
                "id= " + id;
    }
}
