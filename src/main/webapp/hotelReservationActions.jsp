<!DOCTYPE html>

<html>
<link rel="stylesheet" href="styles/firstpagestyle.css">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>reserveActions</title>

    <style>
        div.relative {
            position: relative;
            width: 1320px;
            height: 1043px;
        }

        div.message {
            position: absolute;
            top: 100px;
            left: 50px;
            width: 558px;
            height: 200px;
        }

        div.mainimage {
            position: absolute;
            top: -40px;
            left: 700px;
            width: 558px;
            height: 961px;
        }
    </style>
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

<div class="relative">
    <div class="message">
        <h1>
            Utility
        </h1>
        <br>
        <form method="get" action="service">
            <br>
            <h3>Choose operation:</h3>
            <br>
            <input type="radio" name="operation" value="Reservea">
            <label>Reserve room</label><br>
            <input type="radio" name="operation" value="Changing reservation">
            <label>Changing reservation</label><br>
            <input type="radio" name="operation" value="See reservations">
            <label>See reservations</label><br>
            <input type="radio" name="operation" value="Cancel reservations">
            <label>Cancel reservations</label><br><br>
        </br>
            <input type="submit" value="Confirmation">
        </form>

    </div>
    <div class="mainimage">
        <img src="https://ak-d.tripcdn.com/images/200d1h000001hnx0z3D55_Z_1080_808_R5_D.jpg" alt=""
             style="width: 558px; height: 761px; object-fit: cover; object-position: 50% 50%;">
    </div>
</div>

<%
        writer.println("</center>");
    }
%>
</body>
</html>




















<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>reserveActions</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<body style="background-color:powderblue;">

</head>


</body>
</html>
</body>
</html>