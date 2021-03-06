<%-- 
    Document   : login
    Created on : 13-Nov-2015, 15:53:40
    Author     : a2-painter
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab - Log In</title>
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
        <form action="LoginController" method="post">
            <div class="row">
                <div class="col-md-12 container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="page-header" style="text-align: center"><h1>Alphacab</h1></div>
                        </div>
                    </div>
                    <div class="row" style="padding-top:10vh">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <div class="panel panel-primary" style="text-align: center;">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><big>Log In</big></h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Username" type="text" name="registration">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" type="password" name="password">
                                    </div>
                                    <input class="btn btn-blank btn-lg btn-block" value="Go" type="submit" />
                                </div>
                            </div>
                        </div>
                    </div>       
                </div>
            </div>
        </form>
    </body>
</html>
