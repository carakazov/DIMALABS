package model;

import dao.CinemaDao;
import dao.LicenseDao;

import java.util.ArrayList;
import java.util.List;

public class CinemaBeanDao {
    private final CinemaDao cinemaDao = new CinemaDao();
    private final LicenseDao licenseDao = new LicenseDao();

    public List<CinemaBean> getAll(){
        List<CinemaBean> beans = new ArrayList<>();
        List<Cinema> cinemas = cinemaDao.getAll();
        for(Cinema cinema : cinemas){
            License license = licenseDao.read(cinema.getLicenseId());
            CinemaBean bean = new CinemaBean(cinema, license);
            beans.add(bean);
        }
        return beans;
    }
}
