package service;

import data.RoomReservationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CancelServlet")
public class CancelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body style=\"background-color:powderblue;\">");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name")!=null) {

            writer.println("welcome " + session.getAttribute("name"));
            int reserveCode = Integer.parseInt(request.getParameter("reserveCode"));
            RoomReservationDao.delete(reserveCode);
            writer.println("Reservation successfully canceled");
            writer.println("<br><a href='logout'>Logout</a>");
            writer.println("</body></html>");
        }else{
            writer.println("Please login first");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
