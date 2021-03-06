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
import java.sql.Statement;

/**
 *
 * @author t2-sheedy
 */
public class Invoice {

    private int CustomerID;
    private int DemandID;
    private double Price;
    private Boolean Confirmed;

    public Invoice(int CustomerID, int DemandID, double Price) {
        this.CustomerID = CustomerID;
        this.CustomerID = DemandID;
        this.Price = Price;
        this.Confirmed = false;
    }

    public Invoice() {
        this.Confirmed = false;
    }
    
    public Invoice(int CustomerID) {
        this.CustomerID = CustomerID;
        setDetails();
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public double getPrice() {
        return Price;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getDemandID() {
        return DemandID;
    }

    public void setDemandID(int DemandID) {
        this.DemandID = DemandID;
    }

    public Boolean getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(Boolean Confirmed) {
        this.Confirmed = Confirmed;
    }

    public void WriteToDB() {
        Connection con;
        Statement state;

        Properties p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = getInsertQuery();

            state.executeUpdate(query);
            state.close();
            con.close();
        } catch (Exception e) {
        }

    }

    //set object details to database entry
    public void setDetails() {
        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetInvoiceFromCustomerIDQ();
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                int CustomerID = -1;
                int DemandID = 0;
                int Distance = -1;
                double invoicePrice = -1.0;

                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    CustomerID = rs.getInt("CustomerID");
                    Distance = rs.getInt("DemandID");
                    invoicePrice = rs.getDouble("Price");
                    //Price price = new Price(Distance);
                    //invoicePrice = price.getPrice();

                }

                rs.close();

                state.close();

                con.close();

                if (rowCount == 1) {
                    setCustomerID(CustomerID);
                    setDemandID(DemandID);
                    setPrice(invoicePrice);
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr
    }

    public void GetInvoiceFromDemandID(int DemandID) {
        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetInvoiceFromDemandIDQ(DemandID);
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                int customerID = -1;
                int demandID = 0;
                double price = -1.0;

                int rowCount = 0;
                while (rs.next()) {
                    rowCount = rowCount + 1;
                    customerID = rs.getInt("CustomerID");
                    demandID = rs.getInt("DemandID");
                    price = rs.getDouble("Price");

                }
                rs.close();
                state.close();
                con.close();
                if (rowCount == 1) {
                    this.setCustomerID(customerID);
                    this.setDemandID(demandID);
                    this.setPrice(price);
                    //this.setConfirmed(confirmed);
                    //return new Invoice(customerID, demandID, price);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr
        //return null;
    }
    
    public void GetInvoiceFromCustomerID(int CustomerID) {
        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetInvoiceFromCustomerIDQ(CustomerID);
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                int customerID = -1;
                int demandID = 0;
                double price = -1.0;
                Boolean confirmed = false;

                int rowCount = 0;
                while (rs.next()) {
                    rowCount = rowCount + 1;
                    customerID = rs.getInt("CustomerID");
                    demandID = rs.getInt("DemandID");
                    price = rs.getDouble("Price");
                    confirmed = rs.getBoolean("Confirmed");

                }
                rs.close();
                state.close();
                con.close();
                if (rowCount == 1) {
                    this.setCustomerID(customerID);
                    this.setDemandID(demandID);
                    this.setPrice(price);
                    this.setConfirmed(confirmed);
                    //return new Invoice(customerID, demandID, price);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr
        //return null;
    }

    public boolean Update() {
        Connection con;
        Statement state;
        Properties p;
        p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetUpdateQuery();
            
            if (!"".equals(query)) {
                state.executeUpdate(query);
                state.close();
                con.close();
                return true;
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return false;
    }

    private String getInsertQuery() {
        String query = "";

        int customerID = getCustomerID();
        int demandID = getDemandID();
        double price = getPrice();
        Boolean confirmed = getConfirmed();

        query = query + "INSERT INTO Invoices ";
        query = query + " (`CustomerID`, `DemandID`, `Price`, `Confirmed`)";
        query = query + " VALUES";
        query = query + " (" + customerID + "," + demandID + "," + price + ""
                + "," + confirmed + ");";

        return query;
    }

    public String GetUpdateQuery() {
        int customerID = getCustomerID();
        double price = getPrice();
        Boolean confirmed = getConfirmed();

        String query = "";
        query = query + "UPDATE Invoices";
        query = query + " SET Price = " + price + ", Confirmed = " + confirmed + "";
        query = query + " WHERE CustomerID = " + customerID + ";";

        return query;
    }

//public String GetDetailsByDistanceQuery() {
//        int distance = getDistance();
//
//        String query = "SELECT * FROM PriceList WHERE Distance = " + distance + ";";
//
//        return query;
//    }
    public String GetInvoiceFromDemandIDQ(int DemandID) {

        String query = "";
        query = "SELECT * FROM `Invoices` "
                + "WHERE `DemandID` = " + DemandID + ";";

        return query;
    }
    
    public String GetInvoiceFromCustomerIDQ(int CustomerID){
        String query = "";
        query = "SELECT * FROM `Invoices` "
                + "WHERE `CustomerID` = " + CustomerID + ";";

        return query;
    }

    public String GetInvoiceFromCustomerIDQ(){
        String query = "";
        query = "SELECT * FROM `Invoices` "
                + "WHERE CustomerID = " + getCustomerID() + ";";
        
        return query;
    }
}
