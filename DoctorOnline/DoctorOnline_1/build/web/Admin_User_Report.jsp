<%-- 
    Document   : Admin_User_Report
    Created on : Dec 29, 2021, 5:44:47 PM
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
        <title>User Report</title>
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
      <!--  <form name="reportuserform" action="Admin_User_Report.jsp">
            <b><font color="white">From Date</font></b><input type="date" name="fdtxt" value="">
            <b><font color="white">To Date</font></b><input type="date" name="tdtxt" value=""><br>
            <input type="submit" value="show" name="sbtn">
        </form>-->
        <table border="5px solid #ccc">
            <tr><th>Name</th><th>Password</th><th>Address</th><th>City</th><th>Phone</th><th>Email</th><th>Registration Date</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("select * from tbUser" );
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
