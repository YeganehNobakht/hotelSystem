package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class
LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String nationalCode = request.getParameter("nationalCode");

        if (name.equalsIgnoreCase("Masoume") && password.equalsIgnoreCase("12345")) {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("nationalCode", nationalCode);
            request.getRequestDispatcher("/Actions").include(request, response);
        }
        else {
            writer.println("Error: please try again.");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        writer.println("</html></body>");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
