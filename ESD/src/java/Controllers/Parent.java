/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author t2-sheedy
 */
public class Parent {
    
    //Parent.CheckLoggedIn(request, response);

    public static void CheckLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            //session.invalidate();            
            response.sendRedirect("login.jsp");
        }

    }

}
