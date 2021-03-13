package beans;

import model.Cinema;
import model.License;

import java.sql.Date;

public class CinemaBean {
    private int cinemaId;
    private String address;
    private int rating;
    private Date licenseReceivingDate;

    public CinemaBean(){}
    public CinemaBean(Cinema cinema, License license){
        cinemaId = cinema.getId();
        address = cinema.getAddress();
        rating = cinema.getRating();
        licenseReceivingDate = license.getReceivingDate();
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public String getAddress() {
        return address;
    }

    public int getRating() {
        return rating;
    }

    public Date getLicenseReceivingDate() {
        return licenseReceivingDate;
    }
}
