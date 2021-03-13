package servlets;

import dao.LicenseDao;
import model.License;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class CreateAndDeleteLicenseServlet extends HttpServlet {
    private final LicenseDao licenseDao = new LicenseDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        licenseDao.delete(id);
        List<License> licenses = licenseDao.getAll();
        req.setAttribute("list", licenses);
        req.getRequestDispatcher("licenseList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateStr = req.getParameter("date");
        Date date = Date.valueOf(dateStr);
        License license = new License(date);
        licenseDao.create(license);
        List<License> licenses = licenseDao.getAll();
        req.setAttribute("list", licenses);
        req.getRequestDispatcher("licenseList.jsp").forward(req, resp);
    }
}
