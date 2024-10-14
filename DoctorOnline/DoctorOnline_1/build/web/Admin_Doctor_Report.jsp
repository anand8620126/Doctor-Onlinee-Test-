<%-- 
    Document   : Admin_Doctor_Report
    Created on : Dec 29, 2021, 5:59:41 PM
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
        <title>Doctor Report</title>
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
       <!-- <form name="reportdrform" action="Admin_Doctor_Report.jsp">
            <font color="white"> <b>From Date</b></font><input type="date" name="fdtxt" value="">
            <b><font color="white">To Date</font></b><input type="date" name="tdtxt" value=""><br>
            <input type="submit" value="show" name="sbtn" >
        </form>-->
        <table border="5px solid #ccc">
            <tr><th>Doctor Name</th><th>Password</th><th>Address</th><th>City</th><th>Phone</th><th>Qualification</th><th>Experience</th><th>Specialization</th><th>Hospital ID</th><th>Previous Hospital Name</th><th>Registration Date</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("select * from tbDoctor");
               
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
