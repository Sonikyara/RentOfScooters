package eu.senla.statkevich.scooters.entity.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types_producers"
        ,uniqueConstraints = {@UniqueConstraint(columnNames = {"producer_id","type_of_scooter_id"},name = "types_producers_uniq")}
)
public class TypesProducers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producer_id",nullable = false)
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "type_of_scooter_id",nullable = false)
    private TypeOfScooter scootersType;

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
