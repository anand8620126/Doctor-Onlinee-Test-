<%-- 
    Document   : Doctor_My_Appointments
    Created on : Dec 28, 2021, 4:15:09 PM
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
        <title>My Appointments</title>
    </head>
    <body>
         <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        sd=new SQLDemo();
        %>
       <%@include file="DoctorHeader.jsp" %>
         <table border="5px solid #ccc">
            <tr><th>Appointment ID</th><th>User Name</th><th>Patient Name</th><th>Age</th><th>Gender</th><th>Major Symptoms</th><th>Previous Treatment</th><th>Problem Description</th><th>Appointment Date</th><th>Appointment Status</th><th>Appointment Time</th><th>Appointment Type</th><th>Next Appointment</th></tr>
            <tr>
            <%
            sd.Connect();
            try
            {
            pst=sd.con.prepareStatement("SELECT   dbo.tbAppointment.Appointment_ID, dbo.tbUser.Name, dbo.tbAppointment.Patient_Name, dbo.tbAppointment.Age, dbo.tbAppointment.Gender, dbo.tbAppointment.Major_Symptoms, dbo.tbAppointment.Previous_Treatment ,"+ 
                         "dbo.tbAppointment.Problem_Description, dbo.tbAppointment.Appointment_Date, dbo.tbAppointment.Appointment_Status, dbo.tbAppointment.Appointment_time, dbo.tbAppointment.Appointment_type ,"+ 
                         "dbo.tbAppointment.Next_Appointment "+
            "FROM  dbo.tbAppointment INNER JOIN " +
                         "dbo.tbUser ON dbo.tbAppointment.User_ID = dbo.tbUser.User_ID where Doctor_ID=? and Appointment_Status!='Pending'" );
            pst.setLong(1,Long.parseLong(session.getAttribute("doctorid").toString()));
            rst=pst.executeQuery();
            while(rst.next())
            {%>
            <form name="addtreatform" action="http://localhost:8084/DoctorOnline/TreatmentSerlet">
            <tr>
                <td><input type="text" name="appid" value="<%=rst.getString(1)%>" style="visibility:hidden;">
                    <button type="submit" name="sbtn" value="AddTreatment">Add Treatment</button>
                </td>
           </form>
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
           <%
            }
           rst.close();
            }
            catch(Exception ex)
            {
            System.out.println("error in finding doctor my appointments"+ex);
            }
            %>
        </table>
        <%@include file="Footer.jsp" %>
    </body>
</html>
