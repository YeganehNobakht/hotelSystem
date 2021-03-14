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

@WebServlet(name = "ViewReservationServlet")
public class ViewReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session!=null) {
            writer.println("<html><body style=\"background-color:powderblue;\">");
            writer.println("welcome " + session.getAttribute("name"));
            String nationalCode = (String) request.getSession(false).getAttribute("nationalCode");
            writer.println(RoomReservationDao.fetchRoomReserve(nationalCode));
            writer.println("<br><a href='logout'>Logout</a>");
            writer.println("</body></html>");
        }else{
            writer.println("Please login first");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
