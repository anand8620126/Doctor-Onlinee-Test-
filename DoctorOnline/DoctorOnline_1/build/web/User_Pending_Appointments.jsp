<%-- 
    Document   : User_Pending_Appointments
    Created on : Dec 28, 2021, 9:26:59 PM
    Author     : Anjali
--%>

<%@page import="Servlet.SQLDemo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pending Appointments</title>
    </head>
    <body>
       <%!
        PreparedStatement pst;
        ResultSet rst;
        ResultSet rst1;
        ResultSet rst2;
        SQLDemo sd;
        %>
        <%
        sd=new SQLDemo();
        %>
        <%@include file="UserHeader.jsp" %>
        <h1>Pending Appointments</h1>
        <table border="5px solid #ccc">
            <tr><th>Appointment ID</th><th>Doctor Name</th><th>Patient Name</th><th>Age</th><th>Gender</th><th>Major Symptoms</th><th>Previous Treatment</th><th>Problem Description</th><th>Appointment Date</th><th>Appointment Status</th><th>Appointment Time</th><th>Appointment Type</th><th>Next Appointment</th></tr>
         <%
         sd.Connect();
         try
         {
         pst=sd.con.prepareStatement("SELECT        dbo.tbAppointment.Appointment_ID, dbo.tbDoctor.Doctor_Name, dbo.tbAppointment.Patient_Name, dbo.tbAppointment.Age, dbo.tbAppointment.Gender, dbo.tbAppointment.Major_Symptoms, "+ 
                         "dbo.tbAppointment.Previous_Treatment, dbo.tbAppointment.Problem_Description, dbo.tbAppointment.Appointment_Date, dbo.tbAppointment.Appointment_Status, dbo.tbAppointment.Appointment_time, "+ 
                         "dbo.tbAppointment.Appointment_type, dbo.tbAppointment.Next_Appointment "+
                      "FROM dbo.tbAppointment INNER JOIN "+
                         "dbo.tbDoctor ON dbo.tbAppointment.Doctor_ID = dbo.tbDoctor.Doctor_ID where User_ID=? and Appointment_Status='Pending'");
          pst.setLong(1,Long.parseLong(session.getAttribute("userid").toString()));
         rst=pst.executeQuery();
         while(rst.next())
        {%>
           <td><%= rst.getString(1)%></td>
           <td><%= rst.getString(2)%></td>
           <td><%= rst.getString(3)%></td>
           <td><%= rst.getString(4)%></td>
           <td><%= rst.getString(5)%></td>
           <td><%= rst.getString(6)%></td>
           <td><%= rst.getString(7)%></td>
           <td><%= rst.getString(8)%></td>
           <td><%= rst.getString(9)%></td>
           <td><%= rst.getString(10)%></td>
           <td><%= rst.getString(11)%></td>
           <td><%= rst.getString(12)%></td>
           <td><%= rst.getString(13)%></td>
       
        </tr>
                <% }
          rst.close();
         }
         catch(Exception ex)
         {
         System.out.print("error in populating appointment data"+ex);
         }
sd.Disconnect();
         %>
        </table>
            <%@include file="Footer.jsp" %>
    </body>
</html>
