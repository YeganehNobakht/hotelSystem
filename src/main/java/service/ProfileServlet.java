package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");

        HttpSession session = request.getSession(false);
        if (session != null) {
            writer.println("Welcome " + session.getAttribute("name"));
            writer.println("<br><a href='Actions'>Room reservation</a>");
           // request.getRequestDispatcher("/Actions").include(request, response);
        }
        else {
            writer.println("You should be first login.");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }

        writer.println("<br><a href='logout'>Logout</a>");

        writer.println("</body></html>");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
