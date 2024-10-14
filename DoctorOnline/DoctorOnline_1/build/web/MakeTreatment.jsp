<%-- 
    Document   : MakeTreatment
    Created on : Jan 21, 2022, 1:52:58 PM
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
        <title>Add Treatment</title>
    </head>
    <body>
        <%@include file="DoctorHeader.jsp" %>
        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        SQLDemo sd=new SQLDemo();
        %>
        <center>
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
        <div class="container">
         <div class="col-lg-6">
                    <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                        <h1 class="text-white mb-4">Add Treatment</h1>
                        <form name="addtreatmentform" action="http://localhost:8084/DoctorOnline/TreatmentSerlet">
                            <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                <input type="date" name="treatdtxt" class="form-control bg-light border-0" placeholder="Treatment Date" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                <input type="text" name="treatctxt" class="form-control bg-light border-0" placeholder="Treatment Cost" style="height: 55px;">
                                </div>
                                         <div class="col-12 col-sm-6">
                                    <div class="time" id="time1" data-target-input="nearest">
                                        <input type="text" name="treattimetxt"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Treatment Time" data-target="#time1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="treatdesctxt" class="form-control bg-light border-0" placeholder="Treatment Description" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="recttxt" class="form-control bg-light border-0" placeholder="Recommended Test" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="recprectxt" class="form-control bg-light border-0" placeholder="Recommended Precautions" style="height: 55px;">
                                </div>
                                <div class="col-12">
                                    <button name="sbtn" value="Save"class="btn btn-dark w-100 py-3" type="submit">Add Treatment</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
        </div>
        </div>
        </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
