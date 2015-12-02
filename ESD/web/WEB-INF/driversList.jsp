
<%-- 
    Document   : driversList
    Created on : 30-Nov-2015, 16:15:27
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function setDelete(reg) {
                if (confirm('Are you sure you want to delete this record?')) {
                    document.getElementById('deletedReg').value = reg;
                    document.myform.submit();
                }
            }
            function showAddForm() {
                document.getElementById('addPara').style.display = "block";
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drivers List</title>

    </head>
    <body>
        <form action="DriversListController" name="myform" method="post">
            <h1>Drivers List</h1>
            <input id="deletedReg" name="deletedReg" type="hidden">
            <table border="1px">
                <tr>
                    <td><b>Name</b></td>
                    <td><b>Registration</b></td>
                </tr>
                <c:forEach items="${drivers}" var="driver">
                    <tr>
                        <td>${driver.getName()}</td>
                        <td>${driver.getRegistration()}</td>
                        <td><input type="button" value="Delete" name="deleteBtn" onclick="setDelete('${driver.getRegistration()}');" style="background-color: red; color: white; font-weight: bold" /></td>
                    </tr>
                </c:forEach>
            </table>
        </form><br><br>

        <h1>Add Driver</h1>
        <input type="submit" value="Add New" name="addDriver" onclick="showAddForm()" />
        <form style="display:none" id="addPara" method="post" action="DriversListController"> 
            Registration: <input type="text" name="newRegistration" id="registration"/><br>
            Name: <input type="text" name="name" id="name"/><br>
            Password: <input type="password" name="password" id="password"/><br>
            <input type="submit" value="Add Driver"/>
        </form>

        <br></br>
        
        <a href="admin.jsp"><- Back</a>
    </body>
</html>