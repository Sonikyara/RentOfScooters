package eu.senla.statkevich.scooters.dto;


import java.math.BigDecimal;


public class ScooterDTO {

    private int number;
    private String model;
    private BigDecimal sum;
    private String seller;
    private Long typeProducer;

    public int getNumber() {        return number;    }
    public void setNumber(int number) {        this.number = number;    }

    public String getModel() {        return model;    }
    public void setModel(String model) {        this.model = model;    }

    public BigDecimal getSum() {        return sum;    }
    public void setSum(BigDecimal sum) {        this.sum = sum;    }

    public String getSeller() {        return seller;    }
    public void setSeller(String seller) {        this.seller = seller;    }

    public Long getTypeProducer() {        return typeProducer;    }
    public void setTypeProducer(Long typeProducer) {        this.typeProducer = typeProducer;    }
}
