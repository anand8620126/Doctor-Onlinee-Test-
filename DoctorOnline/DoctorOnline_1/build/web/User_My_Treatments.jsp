<%-- 
    Document   : User_My_Treatments
    Created on : Dec 29, 2021, 4:23:29 PM
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
        <title>My Treatments</title>
    </head>
    <body>
        <%@include file="UserHeader.jsp" %>
        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        sd=new SQLDemo();
        %>
       <!-- <form name="reporttreatmentform" action="User_My_Treatments.jsp">
            <b>From Date</b><input type="date" name="fdtxt" value="">
            <b>To Date</b><input type="date" name="tdtxt" value=""><br>
            <input type="submit" value="show" name="sbtn">
        </form>-->
        <table border="5px solid #ccc">
            <tr><th>Appointment ID</th><th>Doctor ID</th><th>Treatment Date</th><th>Treatment Cost</th><th>Treatment Time</th><th>Treatment Description</th><th>Recommended test</th><th>Recommended Precautions</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("select * from tbTreatment where User_ID=?");
                pst.setLong(1, Long.parseLong("userid"));
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
