package service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServiceServlet")
public class ServiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        //writer.println("<body><html>");
        writer.println("welcome "+request.getSession(false).getAttribute("name"));

       // int roomCapacity = Integer.parseInt(request.getParameter("Capacity"));
       // Date startDate = Date.valueOf(request.getParameter("startDate"));
       // Date endDate = Date.valueOf(request.getParameter("endDate"));

        String operation = request.getParameter("operation");
        if (operation.equalsIgnoreCase("reserve"))
            request.getRequestDispatcher("reserveRoom.html").include(request,response);
        else if (operation.equalsIgnoreCase("change_reserve"))
            request.getRequestDispatcher("/change").forward(request,response);
        else if (operation.equalsIgnoreCase("see_reserve"))
            request.getRequestDispatcher("/view").forward(request,response);
        else if (operation.equalsIgnoreCase("cancel_reserve"))
            request.getRequestDispatcher("/cancel").forward(request,response);

       // writer.println("</html></body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
