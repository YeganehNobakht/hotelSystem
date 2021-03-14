package service;

import data.RoomReservationDao;
import model.RoomReservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "ChangeServlet")
public class ChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session!=null) {
            writer.println("<html><body style=\"background-color:powderblue;\">");
            writer.println("welcome " + session.getAttribute("name"));
            int reserveCode = Integer.parseInt(request.getParameter("reserveCode"));
            int roomCapacity = Integer.parseInt(request.getParameter("Capacity"));
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            String name = (String) request.getSession(false).getAttribute("name");
            String lastName = (String) request.getSession(false).getAttribute("lastName");
            String nationalCode = (String) request.getSession(false).getAttribute("nationalCode");

            RoomReservation roomReservation = new RoomReservation(name, lastName, nationalCode, roomCapacity, startDate, endDate, reserveCode);

            RoomReservationDao.update(roomReservation);
            writer.println("Room information successfully changed");
            writer.println("<br><a href='logout'>Logout</a>");
            writer.println("</body></html>");
        }else{
            writer.println("Please login first");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
