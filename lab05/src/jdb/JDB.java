/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Norbert
 */
public class JDB 
{
  
    private Connection connect() 
    {
        // SQLite connection string
        
        String url = "jdbc:sqlite:C:\\Users\\Norbert\\Desktop\\sqlite\\cars.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    /** 
     * select all rows in the warehouses table
     */
    public ArrayList<String> selectCars()
    {
        ArrayList<String> result = new ArrayList<String>();
        
        String sql = "SELECT Id, Manufacturer, Model FROM Cars";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))
        {
            // loop through the result set
            while (rs.next()) 
            {
                result.add(rs.getString("Id"));
                result.add(rs.getString("Manufacturer"));
                result.add(rs.getString("Model"));
            }
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return result;
    }
    
    public ArrayList<String> selectCustomers()
    {
        ArrayList<String> result = new ArrayList<String>();
        
        String sql = "SELECT Id, FirstName, LastName FROM Customers";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))
        {
            // loop through the result set
            while (rs.next()) 
            {
                result.add(rs.getString("Id"));
                result.add(rs.getString("FirstName"));
                result.add(rs.getString("LastName"));
            }
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return result;
    }
        
    public ArrayList<String> selectOrders()
    {
        ArrayList<String> result = new ArrayList<String>();
        
        String sql = "SELECT Id, ItemId, CustomerId, StartDate, EndDate, Price FROM Reservations";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))
        {
            // loop through the result set
            while (rs.next()) 
            {
                result.add(rs.getString("Id"));
                result.add(rs.getString("ItemId"));
                result.add(rs.getString("CustomerId"));
                result.add(rs.getString("StartDate"));
                result.add(rs.getString("EndDate"));
                result.add(rs.getString("Price"));
            }
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return result;
    }
   
    public ArrayList<String> selectUserOrder(int id)
    {
        ArrayList<String> result = new ArrayList<String>();
        String sql = "SELECT Id, ItemId, CustomerId, StartDate, EndDate, Price FROM Reservations where CustomerId is ?";


    try (Connection conn = this.connect();
         PreparedStatement pstmt  = conn.prepareStatement(sql)){

        // set the value
        pstmt.setInt(1,id);
        //
        ResultSet rs  = pstmt.executeQuery();

        // loop through the result set
        while (rs.next()) 
        {
            result.add(rs.getString("Id"));
            result.add(rs.getString("ItemId"));
            result.add(rs.getString("CustomerId"));
            result.add(rs.getString("StartDate"));
            result.add(rs.getString("EndDate"));
            result.add(rs.getString("Price"));
        }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return result;
    }

    public void addCustomer(String name, String lastname) 
    {
        String sql = "INSERT INTO Customers(FirstName,LastName) VALUES(?,?)";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) 
            {
                pstmt.setString(1, name);
                pstmt.setString(2, lastname);
                pstmt.executeUpdate();
            } 
            catch (SQLException e) 
            {
                System.out.println(e.getMessage());
            }
    }
    
    public void deleteCustomer(int id) 
    {
        String sql = "DELETE FROM Customers WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}