<%-- 
    Document   : Admin_Comments_Report
    Created on : Dec 2023, 6:39:53 PM
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
        <title>Comments Report</title>
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
      <!--  <form name="reportcommentform" action="Admin_Comments_Report.jsp">
            <b>From Date</b><input type="date" name="fdtxt" value="">
            <b>To Date</b><input type="date" name="tdtxt" value=""><br>
            <input type="submit" value="show" name="sbtn">
        </form>-->
        <table border="5px solid #ccc">
            <tr><th>News ID</th><th>Doctor ID</th><th>Comments Description</th><th>Date of Comment</th><th>Status</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("select * from tbNews_Comment");
                
                rst=pst.executeQuery();
                while(rst.next())
                {
                    %>
               <td><%=rst.getString(2)%></td>
               <td><%=rst.getString(3)%></td>
               <td><%=rst.getString(4)%></td>
               <td><%=rst.getString(5)%></td>
               <td><%=rst.getString(6)%></td>
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
