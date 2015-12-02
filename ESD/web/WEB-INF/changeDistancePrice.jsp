<%-- 
    Document   : changeDistancePrice
    Created on : 02-Dec-2015, 14:47:10
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Distance Price</title>
    </head>
    <body>
        <h1>Change Distance Price</h1>

        <form method="post" action="ChangeDistancePriceController">
            Change prices for journeys between
            <input type="text" placeholder="min" name="minDist" width="25px"> miles and <input type="text" width="15px" placeholder="max" name="maxDist"> miles by £<input type="text" placeholder="price alteration" name="priceAlter">
            <br/><input value="submit dat shit" type="submit"><hr/>




            <table><thead><th>Distance (miles)</th><th>Price (£)</th></thead>
                <tbody>
                    <c:forEach items="${prices}" var="price">
                        <tr>
                            <td>${price.getDistance()}</td>
                            <td>${price.getPrice()}</td>
                        </tr>
                    </c:forEach>
                </tbody></table>
            <br/><br/><br/><br/><br/><br/><br/>

            <a href="admin.jsp"><- Back</a>

        </form>
    </body>
</html>
