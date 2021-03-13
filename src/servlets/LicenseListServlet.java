package servlets;

import dao.LicenseDao;
import model.License;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LicenseListServlet extends HttpServlet {
    private LicenseDao licenseDao = new LicenseDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<License> licenses = licenseDao.getAll();
        req.setAttribute("list", licenses);
        req.getRequestDispatcher("licenseList.jsp").forward(req, resp);
    }
}
