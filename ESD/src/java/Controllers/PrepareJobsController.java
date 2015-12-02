/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Customer;
import Models.Demand;
import Models.Driver;
import Models.Invoice;
import Models.Journey;
import Models.Price;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author t2-sheedy
 */
public class PrepareJobsController extends HttpServlet {

    public PrepareJobsController() {
        super();
    }
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ///List Demands
        ///List Drivers
        ///Match Demands to Drivers
        Driver driv = new Driver();
        ArrayList<Driver> drivers = new ArrayList<Driver>();//dem.List();
        drivers = driv.List();
        request.setAttribute("drivers", drivers);

        Demand dema = new Demand();
        ArrayList<Demand> demands = new ArrayList<Demand>();//dem.List();
        demands = dema.list();
        request.setAttribute("demands", demands);

        Journey journ = new Journey();
        ArrayList<Journey> journeys = new ArrayList<Journey>();//dem.List();
        journeys = journ.List();
        request.setAttribute("journeys", journeys);

        //request.setAttribute("test", drivers.size());
        getServletContext().getRequestDispatcher("/WEB-INF/preparejobs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Demand dema = new Demand();
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        ArrayList<Demand> demands = new ArrayList<Demand>();
        demands = dema.list();
        for (Demand demand : demands) {
            int demandId = demand.getId();
            String demandIdString = "DemandID" + Integer.toString(demandId);
            String driverReg = request.getParameter(demandIdString);
            request.setAttribute("test2", driverReg);
            if (!"admin".equals(driverReg)) {

                Demand d = new Demand();

                d.setId(demandId);
                d = d.GetDetail();
                String address = d.getAddress();
                String destination = d.getDestination();
                Journey j2 = new Journey();
                int distance = j2.getDistance(address, destination);
                
                String driversRegistration = driverReg;
                Date date = d.getDate();
                Time time = d.getTime();

                Invoice tempInv = new Invoice();
                tempInv.GetInvoiceFromDemandID(demandId);
                int customerID = tempInv.getCustomerID();

                Journey j = new Journey(destination, distance, customerID, driversRegistration, date, time);
                Price tempPrice = new Price();

                int jID = -1;
                try {
                    jID = j.WriteToDB();
                } catch (SQLException ex) {
                    Logger.getLogger(PrepareJobsController.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    tempInv.setPrice(tempPrice.GetPrice(distance));
                    tempInv.setConfirmed(true);
                    tempInv.Update();
                    d.setStatus("Confirmed");
                    invoices.add(tempInv);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        request.setAttribute("invoices", invoices);

        Driver driv = new Driver();
        ArrayList<Driver> drivers = new ArrayList<Driver>();//dem.List();
        drivers = driv.List();
        request.setAttribute("drivers", drivers);

        Demand deman = new Demand();
        ArrayList<Demand> demandss = new ArrayList<Demand>();//dem.List();
        demandss = deman.list();
        request.setAttribute("demands", demandss);

        Journey journ = new Journey();
        ArrayList<Journey> journeys = new ArrayList<Journey>();//dem.List();
        journeys = journ.List();
        request.setAttribute("journeys", journeys);

        //request.setAttribute("test", drivers.size());
        getServletContext().getRequestDispatcher("/WEB-INF/preparejobs.jsp").forward(request, response);
    }

    public static int randInt(int minimum, int maximum) {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        return randomNum;
    }
}
