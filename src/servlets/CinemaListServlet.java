package servlets;

import model.CinemaBean;
import model.CinemaBeanDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CinemaListServlet extends HttpServlet {
    private final CinemaBeanDao cinemaBeanDao = new CinemaBeanDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CinemaBean> beans = cinemaBeanDao.getAll();
        req.setAttribute("list", beans);
        req.getRequestDispatcher("cinemaList.jsp").forward(req, resp);
    }

}
