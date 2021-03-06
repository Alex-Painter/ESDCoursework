<%-- 
    Document   : customersList
    Created on : 30-Nov-2015, 19:36:57
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab - Customers</title>


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



        <script type='text/javascript'>
            function DisplayInvoiceFor(CustomerID) {
                var divID = 'invoiceFor' + CustomerID;
                var invoice = document.getElementById(divID);
                var invoices = document.getElementsByClassName("invoice");

                for (i = 0; i < invoices.length; i++) {
                    if (invoices[i].id !== divID) {
                        invoices[i].style.display = "none";
                    }
                }

                ToggleVisibility(invoice);//.setAttribute("style", "");
            }
            function ToggleVisibility(invoice) {
                if (invoice.getAttribute("style") === "") {
                    invoice.style.display = "none";
                } else {
                    invoice.setAttribute("style", "")
                }
            }
        </script>

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


        <c:forEach items="${customers}" var="customer" varStatus="status">

        </c:forEach>




        <div class="row">
            <div class="col-md-12 container">
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8" style="text-align: center;">
                        <h1>Customers</h1>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th style="text-align:center">ID</th>
                                    <th style="text-align:center">Name</th>
                                    <th style="text-align:center">Address</th>
                                    <th style="text-align:center">Invoice</th>
                                    <!--th style="text-align:center">Invoice</th-->
                                </tr>
                            </thead>
                            <tbody>
                            <fmt:setLocale value="en_GB" />
                            <c:forEach items="${customers}" var="customer" varStatus="status">
                                <tr>
                                    <td>${customer.getID()}</td>
                                    <td>${customer.getName()}</td>
                                    <td>${customer.getAddress()}</td>
                                    <td>

                                        <c:choose>
                                            <c:when test="${isConfirmeds[status.index]}">
                                                <a href="javascript: DisplayInvoiceFor(${customer.getID()});"><span class="glyphicon glyphicon-list" /></a>
                                            </c:when>
                                            <c:otherwise>

                                            </c:otherwise>
                                        </c:choose>                                            
                                    </td>
                                    <!--td><a href="#"><span class="glyphicon glyphicon-align-right"/></a></td-->
                                </tr>
                                <c:choose>
                                    <c:when test="${isConfirmeds[status.index]}">
                                        <tr style='display:none;' id="invoiceFor${customer.getID()}" class="invoice">
                                            <td colspan="4">
                                        <big><strong>Invoice</strong></big><br/>
                                        <strong>Customer Name:</strong> ${customer.getName()}<br/>
                                        <strong>Customer Address:</strong> ${customer.getAddress()}<br/>
                                        <strong>Price:</strong> <fmt:formatNumber value="${noVATs[status.index]}" type="currency" /><br/>
                                        <strong>VAT:</strong> <fmt:formatNumber value="${VATs[status.index]}" type="currency" /><br/>
                                        <strong>Total Price:</strong> <fmt:formatNumber value="${prices[status.index]}" type="currency" />                                                      
                                        </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>

                                    </c:otherwise>
                                </c:choose> 
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>       
            </div>
        </div>


    </body>
</html>