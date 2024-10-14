<%-- 
    Document   : Failure
    Created on : Jan 31, 2022, 4:55:58 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failure</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>
        
        <%
        if(request.getParameter("type").toString().equals("user"))
        {
        %>
        <h1> User Registration Failed ! Phone Number already exists.</h1>
        <a href="User_Registration.jsp">Back to Registration</a>
        <%
        }
else 
if(request.getParameter("type").toString().equals("doctor"))
{%><h1> Doctor Registration Failed ! Phone Number already exists.</h1>
<a href="Doctor_Registration.jsp">Back to Registration</a>
<%}
else
if(request.getParameter("type").toString().equals("userlogin"))
{%><center><h1> User Login Failed!</h1>
        <a href="User_Login.jsp">Back to User Login</a></center>
  <%}
else if(request.getParameter("type").toString().equals("doctorlogin"))
{%>
<center><h1> Doctor Login Failed!</h1>
    <a href="Doctor_Login.jsp">Back to Doctor Login</a></center>
<%}
  %>     
        <%@include file="Footer.jsp"%>
    </body>
</html>