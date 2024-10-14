<%-- 
    Document   : Admin_ManageHospitalUpdate
    Created on : Dec 30, 2021, 2:10:22 PM
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
        <title>Manage Hospital Update</title>
        <script type="text/javascript">
            function validateform(){
                var hospntxt=document.forms["managehospital"]["hospntxt"].value;
                var hospatxt=document.forms["managehospital"]["hospatxt"].value;
                var citytxt=document.forms["managehospital"]["citytxt"].value;
                var rdtxt=document.forms["managehospital"]["rdtxt"].value;
                var desctxt=document.forms["managehospital"]["desctxt"].value;
                var phtxt=document.forms["managehospital"]["phtxt"].value;
                if(hospntxt==null||hospntxt=="")
                {
                    alert("Hospital name must be filled");
                    return false;
                }
                if(hospatxt==null||hospatxt=="")
                {
                    alert("Hospital Address must be filled");
                    return false;
                }
                if(citytxt==null||citytxt=="")
                {
                    alert("city must be filled");
                    return false;
                }
                if(rdtxt==null||rdtxt=="")
                {
                    alert("Registration Date must be filled");
                    return false;
                }
                if(desctxt==null||desctxt=="")
                {
                    alert("Description of Hospital must be filled");
                    return false;
                }
                if(phtxt==null||phtxt=="")
                {
                    alert("Phone number must be filled");
                    return false;
                }
                
                if(phtxt.length<10||phtxt.length>10){
                    alert("Incorrect Phone Number");
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
                        <h1 class="text-white mb-4">Manage Hospital</h1>
                        <form name="managehospital" action="HospitalServlet" onsubmit="return validateform()">
                            <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                    <input type="text" value="<%=aobj.get(1).toString()%>" name="hospntxt" class="form-control bg-light border-0" placeholder="Hospital Name" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" value="<%=aobj.get(2).toString()%>" name="hospatxt" class="form-control bg-light border-0" placeholder="Hospital Address" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="citytxt" value="<%=aobj.get(3).toString()%>" class="form-control bg-light border-0" placeholder="City" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="date" id="date1" data-target-input="nearest">
                                        <input type="text" name="rdtxt" value="<%=aobj.get(4).toString()%>"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Registration Date" data-target="#date1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                
                                <div class="col-12 col-sm-6">
                                    <input type="text" value="<%=aobj.get(5).toString()%>" name="desctxt"class="form-control bg-light border-0" placeholder="Description" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="time" id="time1" data-target-input="nearest">
                                        <input type="text" name="timetxt" value="<%=aobj.get(6).toString()%>"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Timings" data-target="#time1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="phtxt" value="<%=aobj.get(7).toString()%>" class="form-control bg-light border-0" placeholder="Phone" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="email" name="emailtxt" value="<%=aobj.get(8).toString()%>" class="form-control bg-light border-0" placeholder="Email" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="webtxt" value="<%=aobj.get(9).toString()%>" class="form-control bg-light border-0" placeholder="Website" style="height: 55px;">
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
