/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author h2-standal
 */
public class Price {
    private int ID;
    private int Distance;
    private double Price;

    // <editor-fold desc="Constructor">
    public Price() {

    }

    public Price(int distance) throws SQLException, ClassNotFoundException {
        int max_distance = GetMaxDistance();

        double price = -1.0;

        if (distance > max_distance) {
            distance = max_distance;
        }
        
        this.Distance = distance;
        SetDetails();
    }

    public Price(int priceID, int distance, double price) {
        this.ID = priceID;
        this.Distance = distance;
        this.Price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int GetMaxDistance() throws SQLException, ClassNotFoundException {
        int distance = 0;
        String query = GetMaxDistanceQuery();

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        Class.forName(p.Driver());
        con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
        state = con.createStatement();

        if (query.length() > 0) {
            rs = state.executeQuery(query);

            int rowCount = 0;

            while (rs.next()) {
                rowCount = rowCount + 1;
                distance = rs.getInt("Distance");
                
                if (rowCount == 1) {
                    rs.close();
                    state.close();
                    con.close();
                    return distance;
                }
            }
            
            rs.close();

            if (rowCount == 1) {
                state.close();
                con.close();
                return distance;
            }
        }

        state.close();
        con.close();
        return distance;
    }

    public boolean ChangeDistancePrice(int minDistance, int maxDistance, double priceIncrease) {
        Connection con;
        Statement state;

        Properties p;
        p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetUpdateDistancePriceQuery(minDistance, maxDistance, priceIncrease);

            if (!"".equals(query)) {
                state.executeUpdate(query);

                state.close();
                con.close();

                return true;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        };
        
        return false;
    }
    // </editor-fold>
    // <editor-fold desc="SetDetails">
    //set object details to database entry
    public void SetDetails() {
        if (!"".equals(getDistance())) {
            Connection con;
            Statement state;
            ResultSet rs;

            Properties p;
            p = new Properties();

            try {
                Class.forName(p.Driver());
                con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
                state = con.createStatement();
                String query = GetDetailsByDistanceQuery();
                
                if (query.length() > 0) {
                    rs = state.executeQuery(query);

                    int distance = -1;
                    int priceID = -1;
                    int price = -1;
                    int rowCount = 0;

                    while (rs.next()) {
                        rowCount = rowCount + 1;
                        distance = rs.getInt("PriceListID");
                        priceID = rs.getInt("Distance");
                        price = rs.getInt("Price");
                    }

                    rs.close();
                    state.close();
                    con.close();

                    if (rowCount == 1) {
                        setDistance(distance);
                        setPrice(priceID);
                        setPrice(price);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }//tryerrr
        }
    }
    // </editor-fold>
    // <editor-fold desc="List">
    public ArrayList<Price> List() {
        ArrayList<Price> results = new ArrayList<Price>();

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetListQuery();

            if (!"".equals(query)) {
                rs = state.executeQuery(query);

                int distance = -1;
                int priceID = -1;
                double price = -1;

                while (rs.next()) {
                    distance = rs.getInt("Distance");
                    priceID = rs.getInt("PriceListID");
                    price = rs.getDouble("Price");
                    Price d = new Price(priceID, distance, price);
                    results.add(d);
                }

                rs.close();
                state.close();
                con.close();

                return results;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        };
        
        return results;
    }
    // </editor-fold>
    // <editor-fold desc="DB">
    public String GetMaxDistanceQuery() {
        String query = "SELECT * FROM PriceList ORDER BY Distance DESC;";
        return query;
    }

    public String CalculatePriceQuery(int distance) {
        String query = "SELECT * FROM PriceList WHERE Distance = " + distance + ";";
        return query;
    }

    public String GetListQuery() {
        return "SELECT * FROM PriceList ORDER BY Distance;";
    }

    public String GetUpdateDistancePriceQuery(int minDistance, int maxDistance, double priceIncrease) {
        String query = ""
                + "UPDATE `PriceList`\n"
                + "\n"
                + "SET `Price`=`Price` + " + priceIncrease + "\n"
                + "\n"
                + "WHERE `Distance` >= " + minDistance + " \n"
                + "AND `Distance` <= " + maxDistance + ";";

        return query;
    }

    public String GetDetailsByDistanceQuery() {
        int distance = getDistance();

        String query = "SELECT * FROM PriceList WHERE Distance = " + distance + ";";

        return query;
    }
    // </editor-fold>
}
