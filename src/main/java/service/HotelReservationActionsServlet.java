package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hotelReservationActionsServlet")
public class HotelReservationActionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session.getAttribute("name") != null) {
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>reserveActions</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "<body style=\"background-color:powderblue;\">\n" +
                    "<style>\n" +
                    "    div.relative {\n" +
                    "        position: relative;\n" +
                    "        width: 1320px;\n" +
                    "        height: 1043px;\n" +
                    "    }\n" +
                    "\n" +
                    "    div.message {\n" +
                    "        position: absolute;\n" +
                    "        top: 100px;\n" +
                    "        left: 50px;\n" +
                    "        width: 558px;\n" +
                    "        height: 200px;\n" +
                    "    }\n" +
                    "\n" +
                    "    div.mainimage {\n" +
                    "        position: absolute;\n" +
                    "        top: -40px;\n" +
                    "        left: 700px;\n" +
                    "        width: 558px;\n" +
                    "        height: 961px;\n" +
                    "    }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "\n" +
                    "<div class=\"relative\">\n" +
                    "    <div class=\"message\">\n" +
                    "        <h1>\n" +
                    "            Utility\n" +
                    "        </h1>\n" +
                    "        <br>\n" +
                    "        <form method=\"get\" action=\"service\"><h4>Welcome " + session.getAttribute("name") +
                    " ^_^</h4>\n" +
                    "            <br>\n" +
                    "            <h3>Choose operation:</h3>\n" +
                    "            <br>\n" +
                    "            <input type=\"radio\" name=\"operation\" value=\"reserve\">\n" +
                    "            <label>Reserve room</label><br>\n" +
                    "            <input type=\"radio\" name=\"operation\" value=\"change_reserve\">\n" +
                    "            <label>Changing reservation</label><br>\n" +
                    "            <input type=\"radio\" name=\"operation\" value=\"see_reserve\">\n" +
                    "            <label>See reservations</label><br>\n" +
                    "            <input type=\"radio\" name=\"operation\" value=\"cancel_reserve\">\n" +
                    "            <label>Cancel reservations</label><br><br>\n" +
                    "        </br>\n" +
                    "            <input type=\"submit\" value=\"Confirmation\">\n" +
                    "            <br>\n\n" +
                    "            <br><a href='logout'>Logout</a>\n" +
                    "        </form>\n" +
                    "\n" +
                    "    </div>\n" +
                    "    <div class=\"mainimage\">\n" +
                    "        <img src=\"https://ak-d.tripcdn.com/images/200d1h000001hnx0z3D55_Z_1080_808_R5_D.jpg\" alt=\"\"\n" +
                    "             style=\"width: 558px; height: 761px; object-fit: cover; object-position: 50% 50%;\">\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>\n" +
                    "</body>\n" +
                    "</html>");
        }else{
            writer.println("Please login first");
        request.getRequestDispatcher("index.jsp").include(request, response);}
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
