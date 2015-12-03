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
public class Authenticate {
    public static boolean CheckLoggedIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        
        boolean valid = true;
        
        //if invalid session
        if (session.getAttribute("id") == null) {
            //redirect to login page
            response.sendRedirect("login.jsp");
            
            valid = false;
        }
        
        return valid;
    }
}
