package service;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

@WebFilter(filterName = "ReserveDateFilter")
public class ReserveDateFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
         resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
         Date startDate = Date.valueOf(req.getParameter("startDate"));
         Date endDate = Date.valueOf(req.getParameter("endDate"));

        Calendar cal = Calendar.getInstance();
        cal.roll(Calendar.DATE, -1);

        if (startDate.before(cal.getTime())) {
            //  myDate must be yesterday or earlier
            writer.println("Invalid start date");
            req.getRequestDispatcher("reserveRoom.html").include(req,resp);
        }
         else {
            //  myDate must be today or later
             if (endDate.after(startDate)) {
                 chain.doFilter(req, resp);
             } else {
                 writer.println("Invalid date");
                 req.getRequestDispatcher("reserveRoom.html").include(req, resp);
             }
         }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
