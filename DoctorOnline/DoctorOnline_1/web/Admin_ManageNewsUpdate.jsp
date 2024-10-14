<%-- 
    Document   : Admin_ManageNewsUpdate
    Created on : Dec 30, 2021, 12:13:51 PM
    Author     : Anjali
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Servlet.SQLDemo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage News Update</title>
         <script type="text/javascript">
            function validateform(){
                var newsdtxt=document.forms["managenews"]["newsdtxt"].value;
                var newsttxt=document.forms["managenews"]["newsttxt"].value;
                var newsdesctxt=document.forms["managenews"]["newsdesctxt"].value;
                if(newsdtxt==null||newsdtxt=="")
                {
                    alert("News date must filled out");
                    return false;
                }
                if(newsdesctxt==null||newsdesctxt=="")
                {
                    alert("News description must filled out");
                    return false;
                }
                if(newsttxt==null||newsttxt=="")
                {
                    alert("News Title must filled out");
                    return false;
                }
            }
            </script>
    </head>
    <body>
        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        ArrayList aobj;
        %>
        <%
        sd=new SQLDemo();
        aobj=new ArrayList();
        aobj=(ArrayList)request.getAttribute("list");
        %>
        <%@include file="Admin_Header.jsp" %>
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
        <div class="container">
            <div class="row gx-5">
        <div class="col-lg-6">
                    <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                        <h1 class="text-white mb-4">Manage News</h1>
                        <form name="managenews" action="NewsServlet" onsubmit="return validateform()">
                            <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                    <div class="date" id="date1" data-target-input="nearest">
                                        <input type="text" name="newsdtxt" value="<%=aobj.get(1).toString()%>"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="News Date" data-target="#date1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="newsttxt" value="<%=aobj.get(2).toString()%>" class="form-control bg-light border-0" placeholder="News Title" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="newsdesctxt" value="<%=aobj.get(3).toString()%>" class="form-control bg-light border-0" placeholder="News Description" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="statustxt" value="<%=aobj.get(4).toString()%>" class="form-control bg-light border-0" placeholder="Status" style="height: 55px;">
                                </div>
                                <div class="col-12">
                                    <button name="sbtn" value="Update"class="btn btn-dark w-100 py-3" type="submit">Update</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
              </div>
        </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
