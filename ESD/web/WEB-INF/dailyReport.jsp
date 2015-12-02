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
        <title>Today's Customers</title>
    </head>
    <body>
        <h1>Daily customers</h1>
        Number of customers served today: ${customersServed} 
        Today's turnover: ${turnover}
    </body>
</html>