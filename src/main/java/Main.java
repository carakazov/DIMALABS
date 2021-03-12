import dao.CinemaDao;
import dao.LicenseDao;
import model.Cinema;
import model.License;

import java.sql.Date;


public class Main {
    public static void main(String[] args) {
        CinemaDao cinemaDao = new CinemaDao();
        LicenseDao licenseDao = new LicenseDao();
        Date date = new Date(0);
        License license = new License(date);
        licenseDao.create(license);
        License createdLicense = licenseDao.read(2);//1
        Cinema cinema = new Cinema("Moscow", 10, createdLicense.getId());
        cinemaDao.create(cinema);
        cinema.setRating(15);
        Cinema readCinema = cinemaDao.get(3);//1
        System.out.println(readCinema.getId());
        System.out.println(readCinema.getRating());
        System.out.println(readCinema.getAddress());
        System.out.println(readCinema.getLicenseId());
        cinemaDao.delete(1);
    }
}
