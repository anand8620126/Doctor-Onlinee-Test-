<%-- 
    Document   : NewsAllComments
    Created on : Jan 20, 2022, 1:36:21 PM
    Author     : Anjali
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Comments</title>
    </head>
    <body>
        <%@include file="DoctorHeader.jsp" %>
       <%!
       ArrayList aobj;
       %>
       <%
       aobj=new ArrayList();
       aobj=(ArrayList)request.getAttribute("list");
       %>
        <table border="5px solid #ccc">
            <tr><th>News Description</th><th>Comments</th><th>Doctor Name</th></tr>
            <%
            for(int count=0;count<aobj.size();count=count+3)
            {
            %>
            <tr>
                <td><%=aobj.get(count).toString()%></td><td><%=aobj.get(count+1).toString()%></td>
                <td><%=aobj.get(count+2).toString()%></td>
            </tr>
            <%
            }%>
        </table>
         <%@include file="Footer.jsp" %>
    </body>
</html>
