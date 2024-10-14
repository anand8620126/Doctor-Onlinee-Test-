<%-- 
    Document   : Make_Appointment
    Created on : Dec 28, 2021, 9:47:53 PM
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
        <title>Make Appointment</title>
        <script type="text/javascript">
            function validateForm()
            {
                 var patienttxt=document.forms["makeappointmentform"]["patienttxt"].value;
                 var agetxt=document.forms["makeappointmentform"]["agetxt"].value;
                 var msymtxt=document.forms["makeappointmentform"]["msymtxt"].value;
                 if (patienttxt==null || patienttxt=="")
                {
                  alert("Patient Name must be filled out");
                    return false;
                }
                if (agetxt==null || agetxt=="")
                {
                  alert("Age must be filled out");
                    return false;
                }
                if (msymtxt==null || msymtxt=="")
                {
                  alert("Major symptoms must be filled out");
                    return false;
                }
                }
         </script>
    </head>
    <body>
        <%@include file="UserHeader.jsp" %>
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
                        <h1 class="text-white mb-4">Make Appointment</h1>
                        <form name="makeappointmentform" action="http://localhost:8084/DoctorOnline/DoctorOnlineServlet" onsubmit="return validateForm()">
                            <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                    <select name="userid" class="form-select bg-light border-0" style="height: 55px;">
                                        <%
                    sd.Connect();
                    try
                    {
                    pst=sd.con.prepareStatement("select User_ID, Name from tbUser where User_ID=?");
                    pst.setLong(1,Long.parseLong(session.getAttribute("userid").toString()));
                    rst=pst.executeQuery();
                    while(rst.next())
                    {%>
                    <option value="<%=rst.getString(1)%>"><%=rst.getString(2)%></option>
                    <%
                    }
                    rst.close();
                    }
                    catch(Exception ex)
                    {
                    System.out.println("error in finding user"+ex);
                    }
                    %>
                                    </select>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <select name="drid" class="form-select bg-light border-0" style="height: 55px;">
                                        <%
                    
                    try
                    {
                    pst=sd.con.prepareStatement("select Doctor_ID,Doctor_Name+'-'+Specialization from tbDoctor");
                    rst=pst.executeQuery();
                    while(rst.next())
                    {%>
                    <option value="<%=rst.getString(1)%>"><%=rst.getString(2)%></option>
                    <%
                    }
                    rst.close();
                    }
                    catch(Exception ex)
                    {
                    System.out.println("error in finding doctor"+ex);
                    }
                 sd.Disconnect();
                    %>
                                    </select>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="patienttxt" class="form-control bg-light border-0" placeholder="Patient Name" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="agetxt" class="form-control bg-light border-0" placeholder="Age" style="height: 55px;">
                                </div>
                                    <select name="gender" class="col-12 col-sm-6" class="form-select bg-light border-0" style="height: 55px;">
                                        <option value="Male" selected="selected">Male</option>
                                        <option value="Female">Female</option>
                                    </select>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="msymtxt" class="form-control bg-light border-0" placeholder="Major Symptoms" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="prevtrmtxt" class="form-control bg-light border-0" placeholder="Previous Treatment" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="pdtxt" class="form-control bg-light border-0" placeholder="Problem Description" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="date" name="adtxt" class="form-control bg-light border-0" placeholder="Appointment Date" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="time" id="time1" data-target-input="nearest">
                                        <input type="text" name="attxt"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Appointment Time" data-target="#time1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                 <select name="atypetxt" class="col-12 col-sm-6"  class="form-select bg-light border-0" style="height: 55px;">
                                  
                                        <option value="online" selected="selected">Online</option>
                                        <option value="offline">Offline</option>
                                    </select>                                      

                                <div class="col-12">
                                    <button name="sbtn" value="Save"class="btn btn-dark w-100 py-3" type="submit">Make Appointment</button>
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
