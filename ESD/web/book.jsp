<%-- 
    Document   : book
    Created on : 29-Nov-2015, 19:41:21
    Author     : a2-painter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function disable() {
                if (document.getElementById('asap').checked) {
                    document.getElementById('hour').disabled = true;
                    document.getElementById('minute').disabled = true;
                    document.getElementById('day').disabled = true;
                    document.getElementById('month').disabled = true;
                    document.getElementById('year').disabled = true;
                } else {
                    document.getElementById('hour').disabled = false;
                    document.getElementById('minute').disabled = false;
                    document.getElementById('day').disabled = false;
                    document.getElementById('month').disabled = false;
                    document.getElementById('year').disabled = false;
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

        <form action="BookingController" method="post" name="booking_form">
            <div class="row">
                <div class="col-md-12 container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="page-header" style="text-align: center"><h1>Request A Taxi</h1></div>
                        </div>
                    </div>
                    <div class="row" style="padding-top:10vh">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                            <div class="panel panel-primary" style="text-align: center;">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><big>Request Form</big></h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Your name" type="text" name="name">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Your pickup location" type="text" name="address">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Your destination" type="text" name="destination">
                                    </div>

                                    <br/>
                                    <div class="form-group">
                                        <label>ASAP?</label>&nbsp;&nbsp;<input type="checkbox" id="asap" onclick="disable();" name="asap">
                                    </div>

                                    <div class="form-inline">
                                        on
                                        <div class="form-group">
                                            <input class="form-control" type="text" id="day" maxlength="2" placeholder="DD" size="2" name="day"> /
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" id="month" maxlength="2" placeholder="MM" size="2" name="month"> /
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" id="year" maxlength="4" placeholder="YYYY" size="4" name="year">
                                        </div>
                                    </div>
                                    <br/>
                                    <div class="form-inline">
                                        at
                                        <div class="form-group">
                                            <input class="form-control" type="text" id="hour" maxlength="2" placeholder="HH" size="2" name="hour">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" id="minute" maxlength="2" placeholder="MM" size="2" name="minute">
                                        </div>
                                    </div>
                                    <br/>
                                    <input type="submit" class="btn btn-blank btn-lg btn-block" value="Submit Request" />
                                </div>
                            </div>
                        </div>
                    </div>       
                </div>
            </div>
        </form>
    </body>
</html>
