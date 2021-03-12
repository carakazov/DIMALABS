package model;

public class Cinema {
    private int id;
    private String address;
    private int rating;
    private int licenseId;

    public Cinema(String address, int rating, int licenseId){
        this.address = address;
        this.rating = rating;
        this.licenseId = licenseId;
    }

    public int getId(){
        return id;
    }

    public String getAddress(){
        return address;
    }

    public int getRating(){
        return rating;
    }

    public int getLicenseId(){
        return licenseId;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }
}