package servlets;

import dao.CinemaDao;
import dao.LicenseDao;
import model.Cinema;
import model.CinemaBean;
import model.CinemaBeanDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModifyCinemaServlet extends HttpServlet {
    private final CinemaDao cinemaDao = new CinemaDao();
    private final LicenseDao licenseDao = new LicenseDao();
    private final CinemaBeanDao cinemaBeanDao = new CinemaBeanDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cinema cinema = cinemaDao.get(id);
        req.setAttribute("cinema", cinema);
        req.getRequestDispatcher("modifyCinema.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String address = req.getParameter("address");
        int rating = Integer.parseInt(req.getParameter("rating"));
        int licenseId = Integer.parseInt(req.getParameter("licenseId"));
        Cinema cinema = new Cinema(address, rating, licenseId);
        cinema.setId(id);
        cinemaDao.update(cinema);
        List<CinemaBean> beans = cinemaBeanDao.getAll();
        req.setAttribute("list", beans);
        req.getRequestDispatcher("cinemaList.jsp").forward(req, resp);
    }
}
