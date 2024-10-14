<%-- 
    Document   : News_Update
    Created on : Jan 5, 2022, 6:16:41 PM
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
        <title>News Update</title>
    </head>
    <body>
        <%@include file="Admin_Header.jsp" %>
        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        ArrayList aobj;
        %>
        <%
        SQLDemo sd=new SQLDemo();
        aobj=new ArrayList();
        aobj=
        %>
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
        <div class="container">
            <div class="row gx-5">
        <div class="col-lg-6">
                    <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                        <h1 class="text-white mb-4">News Update</h1>
                        <form name="managenews" action="NewsServlet">
                            <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                    <div class="date" id="date1" data-target-input="nearest">
                                        <input type="text" name="newsdtxt"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="News Date" data-target="#date1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="newsttxt" class="form-control bg-light border-0" placeholder="News Title" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="newsdesctxt"class="form-control bg-light border-0" placeholder="News Description" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="statustxt" class="form-control bg-light border-0" placeholder="Status" style="height: 55px;">
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
