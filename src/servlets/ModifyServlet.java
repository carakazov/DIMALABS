package servlets;

import beans.CinemaBean;
import dao.CinemaDao;
import dao.LicenseDao;
import model.Cinema;
import model.License;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModifyServlet extends HttpServlet {
    private final CinemaDao cinemaDao = new CinemaDao();
    private final LicenseDao licenseDao = new LicenseDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("cinemaId"));
        String address = req.getParameter("address");
        int rating = Integer.parseInt(req.getParameter("rating"));
        int licenseId = Integer.parseInt(req.getParameter("licenseId"));
        Cinema cinema = new Cinema(address, rating, licenseId);
        cinema.setId(id);
        cinemaDao.update(cinema);
        List<CinemaBean> cinemaBeans = new ArrayList<>();
        List<Cinema> cinemas = cinemaDao.getAll();
        for (Cinema cin : cinemas){
            License license = licenseDao.read(cinema.getLicenseId());
            CinemaBean cinemaBean = new CinemaBean(cin, license);
            cinemaBeans.add(cinemaBean);
        }
        req.setAttribute("list", cinemaBeans);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cinema cinema = cinemaDao.get(id);
        req.setAttribute("cinema", cinema);
        req.getRequestDispatcher("modifyForm.jsp").forward(req, resp);
    }
}
