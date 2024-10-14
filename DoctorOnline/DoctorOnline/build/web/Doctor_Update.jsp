<%-- 
    Document   : Doctor_Update
    Created on : Jan 24, 2022, 10:30:31 PM
    Author     : Anjali
--%>

<%@page import="Servlet.SQLDemo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Details</title>
        
            
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <%!
        ArrayList aobj;
        
        %>
        <%
            
        ArrayList aobj=new ArrayList();
        aobj=(ArrayList)request.getAttribute("list");
        %>
        
        
        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        sd=new SQLDemo();
        %>
        <table border="5px solid #ccc">
            <tr><th>Doctor Name</th><th>Address</th><th>City</th><th>Phone</th><th>Qualification</th><th>Experience</th><th>Specialization</th><th>Hospital Name</th><th>Previous Hospital Name</th></tr>        
            <tr>
                <%
                sd.Connect();
                try
                {
                pst=sd.con.prepareStatement(" SELECT        dbo.tbDoctor.Doctor_Name, dbo.tbDoctor.Address, dbo.tbDoctor.City, dbo.tbDoctor.Phone, dbo.tbDoctor.Qualification, dbo.tbDoctor.Experience, dbo.tbDoctor.Specialization, dbo.tbHospital.Hospital_Name," 
                         +"dbo.tbDoctor.Previous_Hospital_Name FROM            dbo.tbHospital INNER JOIN"
                        +" dbo.tbDoctor ON dbo.tbHospital.Hospital_ID = dbo.tbDoctor.Hospital_ID where Specialization=?");
                pst.setString(1, request.getParameter("spctxt").toString());
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
