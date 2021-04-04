<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>
<%@ page import="data.RoomReservationDao" %>
<%@ page import="model.RoomReservation" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Reserve List</h1>

<%
    HttpSession session1 = request.getSession(false);
    PrintWriter writer = response.getWriter();
    String nationalCode = (String)(session1.getAttribute("nationalCode"));
    if (nationalCode == null) {
        writer.println("<h1>Please login first</h1>");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
    else{
        writer.println("<h1>Welcome "+session.getAttribute("name")+"</h1>");
        List<RoomReservation> list= RoomReservationDao.fetchRoomReserve(nationalCode);
        request.setAttribute("list",list);
%>


    <table border="1" width="90%">
        <tr><th>roomNumber</th><th>name</th><th>lastName</th><th>nationalCode</th>
            <th>capacity</th><th>startDate</th><th>endDate</th><th>reserveCode</th></tr>
        <c:forEach items="${list}" var="u">
            <tr><td>${u.roomNumber}</td><td>${u.name}</td><td>${u.lastName}</td>
                <td>${u.nationalCode}</td><td>${u.capacity}</td><td>${u.startDate}</td>
                <td>${u.endDate}</td><td>${u.reserveCode}</td></tr>
        </c:forEach>
    </table>
    <br><a href='logout'>Logout</a>
<%
    }
%>
</body>
</html>