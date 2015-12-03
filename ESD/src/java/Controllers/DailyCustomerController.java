/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author h2-standal
 */
public class DailyCustomerController extends HttpServlet {

    public DailyCustomerController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            ArrayList<Journey> journeys;
            ArrayList<Invoice> invoices = new ArrayList<Invoice>();
            ArrayList<Customer> dailyCustomers = new ArrayList<Customer>();
            
            java.sql.Date today;
            today = new Date(System.currentTimeMillis());

            Journey j = new Journey();
            journeys = j.ListByDate(today);

            try {
                for (Journey journey : journeys) {
                    Customer c = new Customer(journey.getCustomerID());
                    Invoice i = new Invoice(journey.getCustomerID());
                    dailyCustomers.add(c);
                    invoices.add(i);
                    //journey.calculatePricing(journey.getDistance());
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            request.setAttribute("customers", dailyCustomers);
            request.setAttribute("journeys", journeys);
            request.setAttribute("invoices", invoices);

            getServletContext().getRequestDispatcher("/WEB-INF/dailyCustomers.jsp").forward(request, response);
        }
    }
}
