<%-- 
    Document   : dailyCustomers
    Created on : 30-Nov-2015, 21:23:03
    Author     : h2-standal
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers of today</title>
    </head>
    <body>
        <h1>Customers of today</h1>
        
        <table border="1px">
            <tr>
                <td><b>Name</b></td>
                <td><b>Destination</b></td>
                <td><b>Charged</b></td>
                
            </tr>
            
            <c:forEach items="${iterations}" var="iteration">
                <tr>
                        <td>${customers.get(iteration).getName()}</td>
                        <td>${journeys.get(iteration).getDestination()}</td>
                        <td>${journeys.get(iteration).getJourneyPrice()}</td>
                </tr>      
            </c:forEach>
        </table> 
        <br></br>
        <form method="post" action="DailyCustomerController">
            <input type="submit" value="<- Back" name="backBtn"/>
        </form>
    </body>
</html>
