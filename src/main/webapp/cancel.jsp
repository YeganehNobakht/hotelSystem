<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>cancle</title>
</head>
<body style="background-color:powderblue;">
<%@ page import="java.io.PrintWriter" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Cancel Form</h1>

<%
    HttpSession session1 = request.getSession(false);
    PrintWriter writer = response.getWriter();
    String name = (String)(session1.getAttribute("name"));
    if (name == null) {
        writer.println("<h1>Please login first</h1>");
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
    else{
        writer.println("<center><h1>Welcome "+session.getAttribute("name")+"</h1>");
%>
<form action="cancel" method="post">
    <br>
    <br>
    <br>
    <label >Reserve code <br></label>
    <input type="number"  name="reserveCode" value="0">
    <br>
    <input type="submit" value="cancel">
    <br>
    <br>
    <br>
    <br><br><a href='logout'>Logout</a>
</form>
<%
        writer.println("</center>");
    }
%>
</body>
</html>














