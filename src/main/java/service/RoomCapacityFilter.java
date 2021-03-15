package service;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "RoomCapacityFilter")
public class RoomCapacityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            int capacity = Integer.parseInt(req.getParameter("Capacity"));
            PrintWriter out = resp.getWriter();
            Pattern pattern = Pattern.compile("[1,2,3,4]");
            int roomCapacity = Integer.parseInt(req.getParameter("Capacity"));
            if (roomCapacity != 0) {
                Matcher matcher = pattern.matcher(String.valueOf(capacity));
                if (matcher != null)
                    if (matcher.matches()) {
                        chain.doFilter(req, resp);
                    } else {
                        out.println("Invalid Capacity:");
                        req.getRequestDispatcher("reserveRoom.html").include(req, resp);
                    }
            } else {
                out.println("Please select room capacity");
                req.getRequestDispatcher("reserveRoom.html").include(req, resp);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
