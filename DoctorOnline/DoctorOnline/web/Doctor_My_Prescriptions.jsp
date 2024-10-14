<%-- 
    Document   : Doctor_My_Prescriptions
    Created on : Dec 28, 2021, 4:17:16 PM
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
        <title>My Prescriptions</title>
    </head>
    <body>
        <%@include file="DoctorHeader.jsp" %>
         <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        sd=new SQLDemo();
        %>
   <!--     <form name="reportmyappointmentform" action="Doctor_My_Prescriptions.jsp">
            <b>From Date</b><input type="date" name="fdtxt" value="">
            <b>To Date</b><input type="date" name="tdtxt" value=""><br>
            <input type="submit" value="show" name="sbtn">
        </form>-->
        <table border="5px solid #ccc">
            <tr><th>Appointment ID</th><th>Doctor Name</th><th>Treatment Date</th><th>Treatment Cost</th><th>Treatment Time</th><th>Treatment Description</th><th>Recommended Test</th><th>Recommended Precautions</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("SELECT        dbo.tbAppointment.Appointment_ID, dbo.tbDoctor.Doctor_Name, dbo.tbTreatment.Treatment_Date, dbo.tbTreatment.Treatment_Cost, dbo.tbTreatment.Treatment_Time, dbo.tbTreatment.Treatment_Description," 
                         +"dbo.tbTreatment.Recommended_Test, dbo.tbTreatment.Recommended_Precautions "
+"FROM            dbo.tbAppointment INNER JOIN "
                        +" dbo.tbDoctor ON dbo.tbAppointment.Doctor_ID = dbo.tbDoctor.Doctor_ID INNER JOIN "
                        +" dbo.tbTreatment ON dbo.tbAppointment.Appointment_ID = dbo.tbTreatment.Appointment_ID AND dbo.tbDoctor.Doctor_ID = dbo.tbTreatment.Doctor_ID where Doctor_ID=?");
                
                pst.setLong(1,Long.parseLong(session.getAttribute("doctorid").toString()));
                rst=pst.executeQuery();
                while(rst.next())
                {
                    %>
               <td><%=rst.getString(1)%></td>
               <td><%=rst.getString(2)%></td>
               <td><%=rst.getString(3)%></td>
               <td><%=rst.getString(4)%></td>
               <td><%=rst.getString(5)%></td>
               <td><%=rst.getString(6)%></td>
               <td><%=rst.getString(7)%></td>
               <td><%=rst.getString(8)%></td>
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
