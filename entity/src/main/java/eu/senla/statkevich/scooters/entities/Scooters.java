package eu.senla.statkevich.scooters.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "scooters")
public class Scooters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private BigDecimal sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)//(name = "seller_id")
    private Sellers seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "types_producers_id",nullable = false)
    private TypesProducers typeProducer;

    public Scooters() {
    }

    public Scooters(String model, BigDecimal sum, Sellers seller, TypesProducers typeProducer) {
        this.model = model;
        this.sum = sum;
        this.seller = seller;
        this.typeProducer = typeProducer;
    }

    public Long getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }

    public TypesProducers getTypeProducer() {
        return typeProducer;
    }

    public void setTypeProducer(TypesProducers typeProducer) {
        this.typeProducer = typeProducer;
    }

    @Override
    public String toString() {
        return "Scooter: " +
                "number= " + number +
                ", model= " + model +
                ", seller= " + seller.getName() +
                ", id type-producer= " + typeProducer.toString() +
                " ,сумма= " + sum;
    }
}
