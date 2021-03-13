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

public class CreateAndDeleteCinemaServlet extends HttpServlet {
    private final CinemaDao cinemaDao = new CinemaDao();
    private final LicenseDao licenseDao = new LicenseDao();
    private final CinemaBeanDao cinemaBeanDao = new CinemaBeanDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        cinemaDao.delete(id);
        List<CinemaBean> beans = cinemaBeanDao.getAll();
        req.setAttribute("list", beans);
        req.getRequestDispatcher("cinemaList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address").toString();
        int rating = Integer.parseInt(req.getParameter("rating"));
        int licenseId = Integer.parseInt(req.getParameter("licenseId"));
        Cinema cinema = new Cinema(address, rating, licenseId);
        cinemaDao.create(cinema);
        List<CinemaBean> beans = cinemaBeanDao.getAll();
        req.setAttribute("list", beans);
        req.getRequestDispatcher("cinemaList.jsp").forward(req, resp);
    }
}
