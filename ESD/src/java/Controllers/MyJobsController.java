/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Customer;
import Models.Driver;
import Models.Journey;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a2-painter
 */
public class MyJobsController extends HttpServlet {

    public MyJobsController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            HttpSession session = request.getSession();

            Customer tempCustomer = new Customer();
            ArrayList<Customer> customers = new ArrayList<Customer>();

            Journey tempJourney = new Journey();
            tempJourney.setDriversRegistration((String) session.getAttribute("id"));
            ArrayList<Journey> myJourneys = tempJourney.getMyJourneys();

            for (Journey journey : myJourneys) {
                customers.add(tempCustomer.GetCustbyID(journey.getCustomerID()));
            }

            request.setAttribute("journeys", myJourneys);
            request.setAttribute("customers", customers);

            getServletContext().getRequestDispatcher("/WEB-INF/myJobs.jsp").forward(request, response);
        }
    }
}
