package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "LoginServlet")
public class
LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String nationalCode = request.getParameter("nationalCode");
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(String.valueOf(nationalCode));


        if (name.equalsIgnoreCase("Masoume") && password.equalsIgnoreCase("12345")) {
            if (!matcher.matches()) {
                writer.println("Invalid national code.");
            }else {
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("lastName", lastName);
                session.setAttribute("password", password);
                session.setAttribute("nationalCode", nationalCode);
                request.getRequestDispatcher("/profile").include(request, response);
            }
        } else {
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
