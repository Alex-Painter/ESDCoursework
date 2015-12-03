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
        ArrayList<Journey> journeys;

        java.sql.Date today;
        today = new Date(System.currentTimeMillis());

        Journey j = new Journey();
        ArrayList<Customer> dailyCustomers = new ArrayList<Customer>();
        journeys = j.ListByDate(today);

        try {
            for (Journey journey : journeys) {
                Customer c = new Customer(journey.getCustomerID());
                c = c.GetDetail();
                dailyCustomers.add(c);

                journey.calculatePricing(journey.getDistance());
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        request.setAttribute("customers", dailyCustomers);
        request.setAttribute("journeys", journeys);

        getServletContext().getRequestDispatcher("/WEB-INF/dailyCustomers.jsp").forward(request, response);
    }

}
