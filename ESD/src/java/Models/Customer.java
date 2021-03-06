/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author t2-sheedy
 */
public class Customer {

    private String Name;
    private String Address;
    private int ID;

    // <editor-fold desc="Constructor">
    public Customer() {

    }

    public Customer(int id) {
        this.ID = id;
        setDetails();
    }

    public Customer(String name, String address, int id) {
        this.Name = name;
        this.Address = address;
        this.ID = id;
    }

    // </editor-fold>
    // <editor-fold desc="Properties">
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    // </editor-fold>
    // <editor-fold desc="GetDetail">
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
            String query = GetCustomerDetailsQuery();
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                String nam = "";
                String add = "";
                int id = -1;
                int rowCount = 0;

                while (rs.next()) {//if query result, set parameters
                    rowCount = rowCount + 1;
                    nam = rs.getString("Name");
                    add = rs.getString("Address");
                    id = rs.getInt("id");
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) { //if only entry
                    setName(nam);
                    setAddress(add);
                    setID(id);
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr
    }

    public Customer GetCustbyID(int id) {

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = getCustById(id);
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                String nam = "";
                String add = "";
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    nam = rs.getString("Name");
                    add = rs.getString("Address");
                    id = rs.getInt("id");
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) {
                    return new Customer(nam, add, id);
                } else {
                    return new Customer();
                }
            } else {
                return new Customer();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr

        return new Customer();
    }

    public Customer GetDetailByNameAndAddress() {

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetDetailByNameAndAddressQuery();
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                String nam = "";
                String add = "";
                int id = -1;
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    nam = rs.getString("Name");
                    add = rs.getString("Address");
                    id = rs.getInt("id");
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) {
                    return new Customer(nam, add, id);
                } else {
                    return null;
                }
            } else {
                return new Customer();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr

        return new Customer();
    }

    // </editor-fold>
    // <editor-fold desc="List">
    public ArrayList<Customer> List() {

        ArrayList<Customer> results = new ArrayList<Customer>();

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

                String nam = "";
                String add = "";
                int id = -1;

                while (rs.next()) {
                    nam = rs.getString("Name");
                    add = rs.getString("Address");
                    id = rs.getInt("id");
                    Customer d = new Customer(nam, add, id);
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
    // <editor-fold desc="WriteToDB">
    public void WriteToDB() {
        int id = -1;
        try {
            Properties p;
            p = new Properties();
            Class.forName(p.Driver());
            Connection con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            String query = GetWriteToDBQuery();
            PreparedStatement state = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = state.executeUpdate();

            if (affectedRows == 1) {
                ResultSet genKeys = state.getGeneratedKeys();
                if (genKeys.next()) {
                    id = genKeys.getInt(1);
                }
            }
            state.close();
            con.close();
        } catch (Exception e) {
        }
        this.setID(id);
    }

    // </editor-fold>
    // <editor-fold desc="Update">
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
        };
        return false;
    }

    // </editor-fold>
    // <editor-fold desc="Delete">
    public boolean Delete() {

        Connection con;
        Statement state;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetDeleteQuery();

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
    // <editor-fold desc="DB">

    public String getCustById(int id) {

        String query = "";
        query = query + "SELECT * FROM Customer";
        query = query + " WHERE id LIKE " + id + ";";

        return query;
    }

    public String GetListQuery() {

        String nam = getName();
        String add = getAddress();

        if (nam != null) {
        } else {
            nam = "";
        }
        if (add != null) {
        } else {
            add = "";
        }

        String query = "";
        query = query + "SELECT * FROM Customer";
        query = query + " WHERE Name LIKE '%" + nam + "%'";
        query = query + " AND Address LIKE '%" + add + "%';";

        return query;
    }

    public String GetWriteToDBQuery() {

        String nam = getName();
        String add = getAddress();

        if (nam != null) {
        } else {
            nam = "";
        }
        if (add != null) {
        } else {
            add = "";
        }

        String query = "";

        query = query + "INSERT INTO Customer";
        query = query + " (Name, Address)";
        query = query + " VALUES";
        query = query + " ('" + nam + "','" + add + "');";

        return query;
    }

    public String GetUpdateQuery() {

        String nam = getName();
        String add = getAddress();
        int id = getID();

        if (nam != null) {
        } else {
            nam = "";
        }
        if (add != null) {
        } else {
            add = "";
        }

        String query = "";

        query = query + "UPDATE Customer";
        query = query + " SET Name = '" + nam + "', Address = '" + add + "'";
        query = query + " WHERE id = " + id + ";";

        return query;
    }

    public String GetDeleteQuery() {

        String query = "";
        int id = getID();

        if (id > 0) {

            query = query + "DELETE FROM Customer";
            query = query + " WHERE id = " + id + ";";

        }

        return query;
    }

    public String GetCustomerDetailsQuery() {
        int id = getID();

        String query = "SELECT * FROM Customer WHERE id = '" + id + "';";

        return query;
    }

    public String GetDetailByNameAndAddressQuery() {

        String name = getName();
        String addr = getAddress();

        String query = "";

        query = query + "SELECT * FROM Customer";
        query = query + " WHERE Name = '" + name + "' AND Address = '" + addr + "';";

        return query;
    }

    // </editor-fold>
}
