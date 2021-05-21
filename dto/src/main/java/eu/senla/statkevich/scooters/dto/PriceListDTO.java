package eu.senla.statkevich.scooters.dto;

import java.math.BigDecimal;

public class PriceListDTO {
    private Long id;
    private BigDecimal price;
    private String scooter;
    private int scooter_number;
    private String termOfRent;

    public PriceListDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScooter_number() {
        return scooter_number;
    }

    public void setScooter_number(int scooter_number) {
        this.scooter_number = scooter_number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getScooter() {
        return scooter;
    }

    public void setScooter(String scooter) {
        this.scooter = scooter;
    }

    public String getTermOfRent() {
        return termOfRent;
    }

    public void setTermOfRent(String termOfRent) {
        this.termOfRent = termOfRent;
    }
}
