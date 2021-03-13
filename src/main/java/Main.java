import dao.CinemaDao;
import dao.LicenseDao;
import model.Cinema;
import model.License;

import java.sql.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        LicenseDao licenseDao = new LicenseDao();
        List<License> licenses = licenseDao.getAll();
        for(License license : licenses){
            System.out.println(license.getReceivingDate());
        }
    }
}
