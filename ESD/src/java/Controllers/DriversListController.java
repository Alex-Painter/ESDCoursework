/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Driver;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Charlie
 */
public class DriversListController extends HttpServlet {

    public DriversListController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            ArrayList<Driver> drivers = new ArrayList<Driver>();

            Driver driver = new Driver();
            drivers = driver.List();

            request.setAttribute("drivers", drivers);

            getServletContext().getRequestDispatcher("/WEB-INF/driversList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            if (request.getParameter("deletedReg") != null) {
                Object regToDelete = request.getParameter("deletedReg");

                if (regToDelete != null && !"".equals(regToDelete)) {
                    ArrayList<Driver> drivers = new ArrayList<Driver>();
                    Driver driver = new Driver();

                    driver.setRegistration(regToDelete.toString());
                    driver.Delete();
                    driver.setRegistration("");
                    drivers = driver.List();

                    request.setAttribute("drivers", drivers);
                }

            } else if (request.getParameter("newRegistration") != null) {
                String registration = request.getParameter("newRegistration");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                Driver newDriver = new Driver(registration, name, password);

                if (newDriver.WriteToDB()) {
                    ArrayList<Driver> drivers = new ArrayList<Driver>();
                    Driver driver = new Driver("", "", "");
                    drivers = driver.List();

                    request.setAttribute("drivers", drivers);
                }
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/driversList.jsp").forward(request, response);
        }
    }
}
