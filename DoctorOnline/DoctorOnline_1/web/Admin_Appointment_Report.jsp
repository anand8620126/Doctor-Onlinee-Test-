<%-- 
    Document   : Admin_Appointment_Report
    Created on : Feb 2, 2022, 9:06:40 PM
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
        <title>Admin Appointment Report</title>
    </head>
    <body>
        
        <%@include file="Admin_Header.jsp" %>
        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        sd=new SQLDemo();
        %>
        <table border="5px solid #ccc">
            <tr><th>User</th><th>Doctor</th><th>Patient Name</th><th>Age</th><th>Gender</th><th>Major Symptoms</th><th>Previous Treatment</th><th>Problem Description</th><th>Appointment Date</th><th>Appointment Status</th><th>Appointment Time</th><th>Appointment Type</th><th>Next Appointment</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("select * from tbAppointment");
               
                rst=pst.executeQuery();
                while(rst.next())
                {
                    %>
               <td><%=rst.getString(2)%></td>
               <td><%=rst.getString(3)%></td>
               <td><%=rst.getString(4)%></td>
               <td><%=rst.getString(5)%></td>
               <td><%=rst.getString(6)%></td>
               <td><%=rst.getString(7)%></td>
               <td><%=rst.getString(8)%></td>
               <td><%=rst.getString(9)%></td>
               <td><%=rst.getString(10)%></td>
               <td><%=rst.getString(11)%></td>
               <td><%=rst.getString(12)%></td>
                <td><%=rst.getString(13)%></td>
            </tr>
                <%}
                rst.close();
                }
                catch(Exception ex)
                {
                System.out.println("error in report"+ex);
                }
                sd.Disconnect();
                %>
            
        </table>
        <%@include file="Footer.jsp" %>
    </body>
</html>
