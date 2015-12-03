/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Driver;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author a2-painter
 */
public class LoginController extends HttpServlet {

    public LoginController() {
        //super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Get login details
        String registration = request.getParameter("registration");
        String password = request.getParameter("password");

        //create driver object from details
        Driver driv;
        driv = new Driver();
        driv.setRegistration(registration);
        driv.setPassword(password);

        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(20 * 60); //20 lots of 60 seconds = 20 minutes

        if (driv.LogIn()) {

            Driver driverDetails = new Driver(registration);
            session.setAttribute("id", registration);
            session.setAttribute("name", driverDetails.getName());
            response.sendRedirect("admin.jsp");

        } else {

            session.setAttribute("error", "Log In Failed");
            response.sendRedirect("error.jsp");

        }
    }
}
