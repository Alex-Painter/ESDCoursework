/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Customer;
import Models.Invoice;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Charlie
 */
public class CustomersListController extends HttpServlet {

    public CustomersListController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            ArrayList<Customer> customers = new ArrayList<Customer>();
            ArrayList<Double> prices = new ArrayList<Double>();
            ArrayList<Boolean> isConfirmeds = new ArrayList<Boolean>();

            ArrayList<Double> noVATs = new ArrayList<Double>();
            ArrayList<Double> VATs = new ArrayList<Double>();

            Customer customer = new Customer();
            customers = customer.List();

            for (Customer cust : customers) {
                Invoice custInv = new Invoice();
                custInv.GetInvoiceFromCustomerID(cust.getID());
                double price = custInv.getPrice();
                double noVAT = price * 0.8;
                double VAT = price * 0.2;

                noVATs.add(noVAT);
                VATs.add(VAT);

                prices.add(price);
                isConfirmeds.add(custInv.getConfirmed());
            }
            request.setAttribute("noVATs", noVATs);
            request.setAttribute("VATs", VATs);

            request.setAttribute("isConfirmeds", isConfirmeds);
            request.setAttribute("customers", customers);
            request.setAttribute("prices", prices);
            getServletContext().getRequestDispatcher("/WEB-INF/customersList.jsp").forward(request, response);
        }
    }

}
