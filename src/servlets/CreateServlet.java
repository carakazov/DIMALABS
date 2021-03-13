package servlets;

import beans.CinemaBean;
import dao.CinemaDao;
import dao.LicenseDao;
import model.Cinema;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateServlet extends HttpServlet {
    private final CinemaDao cinemaDao = new CinemaDao();
    private final LicenseDao licenseDao = new LicenseDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address").toString();
        int rating = Integer.parseInt(req.getParameter("rating"));
        int licenseId = Integer.parseInt(req.getParameter("licenseId"));
        Cinema cinema = new Cinema(address, rating, licenseId);
        cinemaDao.create(cinema);
        List<CinemaBean> beans = new ArrayList<>();
        List<Cinema> cinemas = cinemaDao.getAll();
        for(Cinema item : cinemas){
            CinemaBean bean = new CinemaBean(item, licenseDao.read(item.getLicenseId()));
            beans.add(bean);
        }
        req.setAttribute("list", beans);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        cinemaDao.delete(id);
        List<CinemaBean> beans = new ArrayList<>();
        List<Cinema> cinemas = cinemaDao.getAll();
        for(Cinema item : cinemas){
            CinemaBean bean = new CinemaBean(item, licenseDao.read(item.getLicenseId()));
            beans.add(bean);
        }
        req.setAttribute("list", beans);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
