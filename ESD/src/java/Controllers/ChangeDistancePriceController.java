/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Price;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Charlie
 */
public class ChangeDistancePriceController extends HttpServlet {

    public ChangeDistancePriceController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Parent.CheckLoggedIn(request, response);

        if (request.getParameter("backBtn") != null) {
            response.sendRedirect("/admin.jsp");
        } else {
            ArrayList<Price> prices = new ArrayList<Price>();
            Price price = new Price();
            prices = price.List();

            request.setAttribute("prices", prices);

            getServletContext().getRequestDispatcher("/WEB-INF/changeDistancePrice.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Parent.CheckLoggedIn(request, response);

        Object minDistObj = request.getParameter("minDist");
        Object maxDistObj = request.getParameter("maxDist");
        Object priceAlterObj = request.getParameter("priceAlter");

        String minDistStr = minDistObj.toString();
        String maxDistStr = maxDistObj.toString();
        String priceAlterStr = priceAlterObj.toString();

        int minDist = Integer.parseInt(minDistStr);
        int maxDist = Integer.parseInt(maxDistStr);
        double priceAlter = Double.parseDouble(priceAlterStr);

        Price p = new Price();

        p.ChangeDistancePrice(minDist, maxDist, priceAlter);

        ArrayList<Price> prices = new ArrayList<Price>();
        Price price = new Price();
        prices = price.List();

        request.setAttribute("prices", prices);

        getServletContext().getRequestDispatcher("/WEB-INF/changeDistancePrice.jsp").forward(request, response);
    }
}
