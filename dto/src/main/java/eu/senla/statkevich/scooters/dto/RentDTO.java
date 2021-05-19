package eu.senla.statkevich.scooters.dto;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

public class RentDTO {
    private Long id;
    //private int scooter_number;
    private String scooter_model;
    private String user_name;
    //private BigDecimal price;
   // @NotBlank
    private String termOfRent;
   // @NotBlank
   private Date dateStart;
    //private Date dateStart;
    private Date dateEnd;

    public RentDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

//    public int getScooter_number() {
//        return scooter_number;
//    }
//
//    public void setScooter_number(int scooter_number) {
//        this.scooter_number = scooter_number;
//    }

    public String getScooter_model() {
        return scooter_model;
    }

    public void setScooter_model(String scooter_model) {
        this.scooter_model = scooter_model;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTermOfRent() {
        return termOfRent;
    }

    public void setTermOfRent(String priceList_termOfRent) {
        this.termOfRent = priceList_termOfRent;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "id=" + id +
                ", scooter_model='" + scooter_model+
                ", user_name='" + user_name +
                ", termOfRent='" + termOfRent +
                ", dateStart=" + dateStart ;
    }

    //    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }


}
