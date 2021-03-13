package model;

import java.sql.Date;

public class CinemaBean {
    private int id;
    private String address;
    private int rating;
    private int licenseId;
    private Date receivingDate;

    public CinemaBean(Cinema cinema, License license) {
        id = cinema.getId();
        address = cinema.getAddress();
        rating = cinema.getRating();
        licenseId = license.getId();
        receivingDate = license.getReceivingDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }
}
