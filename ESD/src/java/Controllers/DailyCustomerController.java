/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author h2-standal
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class DailyCustomerController extends HttpServlet {
    public DailyCustomerController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Journey> journeys;
        
        java.sql.Date today = new java.sql.Date(1L);
        today = new Date(System.currentTimeMillis());

        Journey j = new Journey();
        ArrayList<Customer> dailyCustomers = new ArrayList<Customer>();
        journeys = j.ListByDate(today);
        ArrayList<Integer> customerIDs = new ArrayList<Integer>();
        
        int index = 0;
        for (Journey journey : journeys) {
            Customer c = new Customer(journey.getCustomerID());
            c = c.GetDetail();
            dailyCustomers.add(c);
            
            customerIDs.add(index);
            journey.calculatePricing(journey.getDistance());
            index++;
        }        
        request.setAttribute("customers", dailyCustomers);
        request.setAttribute("journeys", journeys);
        request.setAttribute("iterations", customerIDs);

        
        getServletContext().getRequestDispatcher("/WEB-INF/dailyCustomers.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("backBtn") != null) {
            response.sendRedirect("http://localhost:8080/ESD/admin.jsp");
        }
    }
    
}


