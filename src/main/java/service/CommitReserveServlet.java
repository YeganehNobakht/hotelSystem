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

@WebServlet(name = "CommitReserveServlet")
public class CommitReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body style=\"background-color:powderblue;\">");
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name")!=null) {
            writer.println("Welcome " + session.getAttribute("name") + "<br>");

            int roomCapacity = Integer.parseInt(request.getParameter("Capacity"));
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            String name = (String) request.getSession(false).getAttribute("name");
            String lastName = (String) request.getSession(false).getAttribute("lastName");
            String nationalCode = (String) request.getSession(false).getAttribute("nationalCode");

            RoomReservation roomReservation = new RoomReservation(name, lastName, nationalCode, roomCapacity, startDate, endDate);
            RoomReservationDao roomReservationDao = new RoomReservationDao();
            int maxReserveNumber = 0;
            if (roomReservationDao.getMaxReserveNumber() != null) {
                maxReserveNumber = roomReservationDao.getMaxReserveNumber();
                roomReservation.setReserveCode(maxReserveNumber + 1);
            } else {
                maxReserveNumber = 10001;
                roomReservation.setReserveCode(maxReserveNumber);
            }
            roomReservationDao.save(roomReservation);
            writer.println("Room successfully booked\nYour reservation Code is " + maxReserveNumber);
            writer.println("<br><a href='logout'>Logout</a>");
        }
        else {
            writer.println("Please login first");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        writer.println("</body></html>");
        writer.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
