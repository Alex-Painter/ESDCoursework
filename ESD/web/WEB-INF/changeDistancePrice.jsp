<%-- 
    Document   : changeDistancePrice
    Created on : 02-Dec-2015, 14:47:10
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Distance Price</title>



        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <style>

            .btn-blank {
                background-color: white;
                border-color: #dbdbdb;
            }
            .btn-blank:hover {
                background-color: #f0f0f0;
            }
            .btn-blank-red {
                background-color: transparent;
                border-color: transparent;
            }
            .btn-blank-red:hover {
                background-color: #ebb0b0;
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




        <form method="post" action="ChangeDistancePriceController">




            <div class="row">
                <div class="col-md-12 container">
                    <div class="row">
                        <div class="col-md-4">
                        </div>
                        <div class="col-md-4" style="text-align: center;">
                            <h1>Distance Prices</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Alter Prices</h3>
                                </div>
                                <div class="panel-body">
                                    Change prices for journeys between
                                    <div class="input-group">
                                        <input type="text" placeholder="Minimum" name="minDist" class="form-control"><span class="input-group-addon">miles</span>
                                    </div>
                                    and
                                    <div class="input-group">
                                        <input type="text" placeholder="Maximum" name="maxDist" class="form-control"><span class="input-group-addon">miles</span>
                                    </div>
                                    by
                                    <div class="input-group">
                                        <span class="input-group-addon">£</span>
                                        <input type="text" placeholder="Amount" name="priceAlter" class="form-control">
                                    </div>
                                    <br/>
                                    <input class="btn btn-blank btn-lg btn-block" type="submit" value="Submit"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                        </div>
                        <div class="col-md-4" style="text-align: center;">

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th style="text-align: center;">Distance</th>
                                        <th style="text-align: center;">Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${prices}" var="price">
                                        <tr>
                                            <td>${price.getDistance()} miles</td>
                                            <fmt:setLocale value="en_GB" />
                                            <td><fmt:formatNumber value="${price.getPrice()}" type="currency" /></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>       
                </div>
            </div>



        </form>
    </body>
</html>
