/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mvc.util;

/**
 *
 * @author mahlo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
 public static Connection createConnection()
 {
     Connection con = null;
     String url = "jdbc:mysql://localhost:3306/register"; //MySQL URL and followed by the database name
     String username = "root"; //MySQL username
     String password = "Africa#123"; //MySQL password   
     try 
     {
         try 
         {
            Class.forName("com.mysql.jdbc.Driver"); //loading mysql driver 
         } 
         catch (ClassNotFoundException e)
         {
            e.printStackTrace(System.out);
         } 
         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
         System.out.println("Printing connection object "+con);
     } 
     catch (SQLException e) 
     {
        e.printStackTrace(System.out);
     }
     return con; 
 }
}