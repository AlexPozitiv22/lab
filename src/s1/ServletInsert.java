package s1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/")
public class ServletInsert extends javax.servlet.http.HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<City> cities = CityDAO.select();
        request.setAttribute("cities", cities);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

