/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Driver;
import Models.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
public class DailyReportController extends HttpServlet {

    public DailyReportController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            java.sql.Date today = new java.sql.Date(1L);
            today = new Date(System.currentTimeMillis());

            ArrayList<Journey> journeys;
            int turnover = 0;
            Journey j = new Journey();
            journeys = j.ListByDate(today);

            //for each journey, add invoice price
            for (Journey journey : journeys) {
                Invoice i = new Invoice(journey.getCustomerID());
                turnover += i.getPrice();
            }

            request.setAttribute("customersServed", journeys.size());
            request.setAttribute("turnover", turnover);

            getServletContext().getRequestDispatcher("/WEB-INF/dailyReport.jsp").forward(request, response);
        }
    }
}
