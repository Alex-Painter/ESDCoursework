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
        <title>Alphacab - Drivers</title>

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




















        <div class="row">
            <div class="col-md-12 container">
                <div class="row">
                    <div class="col-md-3">
                    </div>
                    <div class="col-md-6" style="text-align: center;">
                        <h1>Drivers</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">New Driver</h3>
                            </div>
                            <div class="panel-body">
                                <form id="addPara" method="post" action="DriversListController"> 
                                    <div class="form-group">
                                        <label for="name">Driver Name</label>
                                        <input class="form-control" type="text" name="name" id="name"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="registration">Car Registration:</label>
                                        <input class="form-control" type="text" name="newRegistration" id="registration"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Driver Password:</label>
                                        <input class="form-control" type="password" name="password" id="password"/><br>
                                    </div>
                                    <input class="btn btn-blank btn-lg btn-block" type="submit" value="Add Driver"/>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1">
                    </div>
                    <form action="DriversListController" name="myform" method="post">
                        <div class="col-md-6" style="text-align: center;">

                            <input id="deletedReg" name="deletedReg" type="hidden">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th style="text-align:center">Name</th>
                                        <th style="text-align:center">Registration</th>
                                        <th style="text-align:center">Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${drivers}" var="driver">
                                        <tr>
                                            <td>${driver.getName()}</td>
                                            <td>${driver.getRegistration()}</td>
                                            <td>
                                                <button type="button"  class="btn btn-blank-red" value="Delete" name="deleteBtn" onclick="setDelete('${driver.getRegistration()}');">
                                                    <span class="glyphicon glyphicon-remove"/>
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>



                    </form>

                </div>       
            </div>
        </div>


    </body>
</html>