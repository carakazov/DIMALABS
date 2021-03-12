package model;

import java.sql.Date;


public class License {
    private int id;
    private Date receivingDate;

    public License(Date receivingDate){
        this.receivingDate = receivingDate;
    }

    public int getId(){
        return id;
    }

    public Date getReceivingDate(){
        return receivingDate;
    }

    public void setId(int id){
        this.id = id;
    }
}
