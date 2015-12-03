<%-- 
    Document   : success.jsp
    Created on : 13-Nov-2015, 16:13:50
    Author     : a2-painter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab - Prepare Jobs</title>




        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <style>

            .btn-blank {
                background-color: white;
                border-color: #0084b4;
            }
            .btn-blank:hover {
                                background-color: #0084b4;
                                color: white;
                border-color: #0084b4;
            }
        </style>

    </head>
    <body>
        <nav class="navbar" id="top" role="banner" style="margin-bottom: 0px; border-width:0px">
            <div class="container-fluid">
                <div class="navbar-header">                    
                    <a href="admin.jsp" class="navbar-brand">Alphacab</a><!--p class="navbar-text">[Logged In User]</p-->
                </div> 
                <div id="bs-navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">

                    </ul> 
                    <ul class="nav navbar-nav navbar-right"> 
                        <li><a href="DriversListController">Drivers</a></li> <li>
                            <a href="CustomersListController">Customers</a></li><li>
                            <a href="PrepareJobsController">Prepare Jobs</a></li> <li>
                            <a href="DailyReportController">Daily Report</a></li> <li>
                            <a href="DailyCustomerController">Daily Customers</a></li> <li>
                            <a href="ChangeDistancePriceController">Change Pricing</a></li>
                    </ul> 
                </div> 
            </div>             
        </nav>
        <hr style="margin-top: 0"/>

        <form action="PrepareJobsController" method="post">


            <div class="row">
                <div class="col-md-12 container">
                    <div class="row">
                        <div class="col-md-2">
                        </div>
                        <div class="col-md-8" style="text-align: center;">
                            <h1>Jobs</h1>

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th style="text-align: center">ID</th>
                                        <th style="text-align: center">Name</th>
                                        <th style="text-align: center">Address</th>
                                        <th style="text-align: center">Destination</th>
                                        <th style="text-align: center">Date</th>
                                        <th style="text-align: center">Time</th>
                                        <th style="text-align: center;width:12%">Driver</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${demands}" var="demand">
                                        <tr>
                                            <td>${demand.getId()}</td><td><input type="hidden" name="CustomerName${demand.getId()}" value="${demand.getName()}">${demand.getName()}</td><td><input type="hidden" name="CustomerAddress${demand.getId()}" value="${demand.getAddress()}">${demand.getAddress()}</td><td>${demand.getDestination()}</td><td>${demand.getDate()}</td><td>${demand.getTime()}</td>
                                            <td>
                                                <select style="width:100%" class="form-control" name="DemandID${demand.getId()}">
                                                    <c:forEach items="${drivers}" var="driver">
                                                        <option value="${driver.getRegistration()}">
                                                            ${driver.getName()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <input type="submit" class="btn btn-blank btn-lg btn-block" value="Submit">
                            <br/><br/><br/>
                        </div>
                    </div>       
                </div>
            </div>
        </form>
    </body>
</html>
