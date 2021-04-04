<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>reserve</title>
</head>
<body style="background-color:powderblue;">
<%@ page import="java.io.PrintWriter" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Reserve Form</h1>

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
<form action="reserveCommit" method="post">
    <br>
    <br>
    <br>
    <label >Room capacity <br></label>
    <input type="number"  name="Capacity" value="0">
    <br>
    <label>Start date<br></label>
    <input type="date" name="startDate">
    <br>
    <label>End date<br></label>
    <input type="date" name="endDate">
    <br>
    <input type="submit" value="reserve">
    <br><br><a href='logout'>Logout</a>
</form>
    <%
        writer.println("</center>");
    }
    %>
</body>
</html>







