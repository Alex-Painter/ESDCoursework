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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class DailyReportController extends HttpServlet {

    public DailyReportController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        java.sql.Date today = new java.sql.Date(1L);
        today = new Date(System.currentTimeMillis());

        ArrayList<Journey> journeys;
        int turnover = 0;
        Journey j = new Journey();
        journeys = j.ListByDate(today);

        try {

            for (Journey journey : journeys) {
                journey.calculatePricing(journey.getDistance());
                turnover += journey.getJourneyPrice();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DailyReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DailyReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("customersServed", journeys.size());
        request.setAttribute("turnover", turnover);

        getServletContext().getRequestDispatcher("/WEB-INF/dailyReport.jsp").forward(request, response);
    }

}
