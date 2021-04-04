<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>change</title>
</head>
<body style="background-color:powderblue;">
<%@ page import="java.io.PrintWriter" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Change Form</h1>

<%
    HttpSession session1 = request.getSession(false);
    PrintWriter writer = response.getWriter();
    String nationalCode = (String)(session1.getAttribute("nationalCode"));
    if (nationalCode == null) {
        writer.println("<h1>Please login first</h1>");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
    else{
        writer.println("<center><h1>Welcome "+session.getAttribute("name")+"</h1>");
%>
<br>
<br>
<br>
<form action="change" method="post">
    <br>
    <label>Reserve code<br></label>
    <input type="number" name="reserveCode">
    <br>
    <label>Room capacity <br></label>
    <input type="number" name="Capacity" value="0">
    <br>
    <label>Start date<br></label>
    <input type="date" name="startDate">
    <br>
    <label>End date<br></label>
    <input type="date" name="endDate">
    <br>
    <br>
    <input type="submit" name="check">
</form>
<br>
<br>

<br><br><a href='logout'>Logout</a>
<%
        writer.println("</center>");
    }
%>
</body>
</html>



























