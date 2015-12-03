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
        if (Authenticate.CheckLoggedIn(request, response)) {
            ArrayList<Price> prices = new ArrayList<Price>();
            Price price = new Price();
            prices = price.List();

            request.setAttribute("prices", prices);

            getServletContext().getRequestDispatcher("/WEB-INF/changeDistancePrice.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Authenticate.CheckLoggedIn(request, response)) {
            Object minDistObj = request.getParameter("minDist");
            Object maxDistObj = request.getParameter("maxDist");
            Object priceAlterObj = request.getParameter("priceAlter");

            String minDistStr = minDistObj.toString();
            String maxDistStr = maxDistObj.toString();
            String priceAlterStr = priceAlterObj.toString();

            boolean minIsInt = minDistStr.matches("-?\\d+(\\.\\d+)?");
            boolean maxIsInt = maxDistStr.matches("-?\\d+(\\.\\d+)?");
            boolean prAlIsDbl = priceAlterStr.matches("([-]?)[0-9]+(\\.[0-9][0-9]?)?");

            int minDist = 0;
            int maxDist = 999999;
            double priceAlter = 0.0;

            if (prAlIsDbl) {
                if (minIsInt) {
                    minDist = Integer.parseInt(minDistStr);
                }
                if (maxIsInt) {
                    maxDist = Integer.parseInt(maxDistStr);
                }
                
                priceAlter = Double.parseDouble(priceAlterStr);

                Price p = new Price();
                p.ChangeDistancePrice(minDist, maxDist, priceAlter);
            }

            ArrayList<Price> prices = new ArrayList<Price>();
            Price price = new Price();
            prices = price.List();

            request.setAttribute("prices", prices);

            getServletContext().getRequestDispatcher("/WEB-INF/changeDistancePrice.jsp").forward(request, response);
        }
    }
}
