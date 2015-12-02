<%-- 
    Document   : admin
    Created on : 29-Nov-2015, 20:15:24
    Author     : t2-sheedy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab - Admins</title>

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
                            <a  href="CustomersListController">Customers</a></li><li>
                            <a href="PrepareJobsController">Prepare Jobs</a></li> <li>
                            <a  href="DailyReportController">Daily Report</a></li> <li>
                            <a href="DailyCustomerController">Daily Customers</a></li> <li>
                            <a href="ChangeDistancePriceController">Change Pricing</a></li>
                    </ul> 
                </div> 
            </div>             
        </nav>
        <hr style="margin-top: 0"/>
        
        <div class="row">
            <div class="col-md-12 container">
                <div class="row" style="padding-top:10vh">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div class="panel panel-primary" style="text-align: center;">
                            <div class="panel-heading">
                                <h3 class="panel-title"><big>Menu</big></h3>
                            </div>
                            <div class="panel-body">
                                <div class="btn-group-vertical" style="max-width:100%;width:100%" role="group" >
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="DriversListController">Drivers</a>
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="CustomersListController">Customers</a>
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="PrepareJobsController">Prepare Jobs</a>
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="DailyReportController">Daily Report</a>
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="DailyCustomerController">Daily Customers</a>
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="#">Create Customer Invoice [8] Tom</a>
                                    <a role="button" style="max-width:100%;width:100%" class="btn btn-blank" href="ChangeDistancePriceController">Change Pricing</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>       
            </div>
        </div>


    </body>
</html>
