/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Norbert
 */
public class JDB 
{
    GUI gui = new GUI();
    
    public static void connect() 
    {
        Connection conn = null;
        try 
        {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Norbert\\Desktop\\sqlite\\car.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (conn != null) 
                {
                    conn.close();
                }
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
   }


    public static void main(String[] args) throws SQLException 
    {
        connect();
        JDB lab = new JDB();

    }
}