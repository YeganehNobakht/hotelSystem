package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServiceServlet")
public class ServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body style=\"background-color:powderblue;\">");
        HttpSession session = request.getSession(false);
        String uname = (String) session.getAttribute("name");
        //writer.println("<body><html>");
        if (uname!=null) {
            writer.println("welcome " +uname);

            String operation = request.getParameter("operation");
            if (operation.equalsIgnoreCase("reserve"))
                request.getRequestDispatcher("reserveRoom.html").include(request, response);
            else if (operation.equalsIgnoreCase("change_reserve"))
                request.getRequestDispatcher("change.html").include(request, response);
            else if (operation.equalsIgnoreCase("see_reserve"))
                request.getRequestDispatcher("/view").forward(request, response);
            else if (operation.equalsIgnoreCase("cancel_reserve"))
                request.getRequestDispatcher("cancel.html").include(request, response);

        }else {
            writer.println("Please login first");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        writer.println("</html></body>");
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
