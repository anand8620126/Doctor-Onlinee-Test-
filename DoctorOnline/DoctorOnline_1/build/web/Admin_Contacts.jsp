<%-- 
    Document   : Admin_Contacts
    Created on : Feb 2, 2022, 9:46:23 PM
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
        <title>Contacts</title>
    </head>
    <body>
        <%@include file="Admin_Header.jsp"%>
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
            <tr><th>Name</th><th>Email</th><th>Subjects</th><th>Description</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement("select * from tbContact");
               
                rst=pst.executeQuery();
                while(rst.next())
                {
                    %>
               <td><%=rst.getString(1)%></td>
               <td><%=rst.getString(2)%></td>
               <td><%=rst.getString(3)%></td>
               <td><%=rst.getString(4)%></td>
               
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
