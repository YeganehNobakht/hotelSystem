package service;

import data.RoomReservationDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "ReserveCodeFilter2")
public class ReserveCodeFilter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        try {
            int reserveCode=Integer.parseInt(req.getParameter("reserveCode"));
            if (RoomReservationDao.fetchReserveByReserveCode(reserveCode)!=null) {
                Pattern pattern = Pattern.compile("[0-9]{5}");
                Matcher matcher = pattern.matcher(String.valueOf(reserveCode));
                if (matcher.matches()) {
                    chain.doFilter(req, resp);
                } else {
                    writer.println("Invalid Reserve Code");
                    req.getRequestDispatcher("cancel.jsp").include(req, resp);
                }
            }
            else{
                writer.println("Invalid Reserve Code");
                req.getRequestDispatcher("cancel.jsp").include(req, resp);
            }
        }catch (NumberFormatException e){
            writer.println("Invalid Reservation Code, Reservation code must be a number");
            req.getRequestDispatcher("cancel.jsp").include(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
