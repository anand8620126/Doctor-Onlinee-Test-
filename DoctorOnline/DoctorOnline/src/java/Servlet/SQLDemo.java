/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HITACHI
 */

    public class SQLDemo {
    public Connection con;
    PreparedStatement pst;
    ResultSet rst;
    public void Connect()
    {
        try
        {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //con=DriverManager.getConnection("jdbc:odbc:java6pm");
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DoctorOnline;integratedSecurity=true;"); 
            System.out.println("connected");
        }
        catch(Exception ex)
        {
            System.out.print("error in connection"+ex);
        }
    }
    public void Disconnect()
    {
        try
        {
            con.close();
           System.out.println("disconnected");
        }
        catch(Exception ex)
        {
           System.out.println("error in disconnection"+ex);
        }
    }
    
    public static void main(String[]a)
    {
        SQLDemo obj=new SQLDemo();
        obj.Connect();
         obj.Disconnect();
    }
    }



    

