<%-- 
    Document   : Admin_ManageHospital
    Created on : Dec 30, 2021, 1:35:22 PM
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
        <title>Manage Hospital</title>
        <script type="text/javascript">
            function validateform(){
                var hospntxt=document.forms["managehospital"]["hospntxt"].value;
                var hospatxt=document.forms["managehospital"]["hospatxt"].value;
                var citytxt=document.forms["managehospital"]["citytxt"].value;
                var rdtxt=document.forms["managehospital"]["rdtxt"].value;
                var desctxt=document.forms["managehospital"]["desctxt"].value;
                var phtxt=document.forms["managehospital"]["phtxt"].value;
                var emailtxt=document.forms["managehospital"]["phtxt"].value;
               
               
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
        %>
        <%
        SQLDemo sd=new SQLDemo();
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
                                    <input type="text" name="hospntxt" class="form-control bg-light border-0" placeholder="Hospital Name" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="hospatxt" class="form-control bg-light border-0" placeholder="Hospital Address" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="citytxt" class="form-control bg-light border-0" placeholder="City" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="date" id="date1" data-target-input="nearest">
                                        <input type="text" name="rdtxt"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Registration Date" data-target="#date1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="desctxt"class="form-control bg-light border-0" placeholder="Description" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="time" id="time1" data-target-input="nearest">
                                        <input type="text" name="timetxt"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Timings" data-target="#time1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="number" name="phtxt" class="form-control bg-light border-0" placeholder="Phone" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="email" name="emailtxt" class="form-control bg-light border-0" placeholder="Email" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="webtxt" class="form-control bg-light border-0" placeholder="Website" style="height: 55px;">
                                </div>
                                <div class="col-12">
                                    <button name="sbtn" value="Registered"class="btn btn-dark w-100 py-3" type="submit">Registered</button>
                                </div>
                                 
                            </div>
                        </form>
                    </div>
                </div>
            </div>
              </div>
        </div>
        <table border="10px solid yellow">
            <tr><th>Hospital ID</th><th>Hospital Name</th><th>Hospital Address</th><th>City</th><th>Registration Date</th><th>Description</th><th>Timings</th><th>Phone</th><th>Email</th><th>Website</th></tr>
        <%
            sd.Connect();
            try
            {
            pst=sd.con.prepareStatement("select * from tbHospital");
            rst=pst.executeQuery();
            while(rst.next())
            {
                %>
        <form name="hospform" action="HospitalServlet">
            <tr>
                <td><input type="text" name="hospitalidtxt" value="<%=rst.getString(1)%>" style="visibility:hidden;">
                    <input type="submit" value="Edit" name="sbtn">
                </td>
        </form>
          <td><%=rst.getString(2)%></td>
          <td><%=  rst.getString(3)%></td>
          <td><%=rst.getString(4)%></td>
          <td><%=rst.getString(5)%></td>
          <td><%=rst.getString(6)%></td>
          <td><%=rst.getString(7)%></td>
          <td><%=rst.getString(8)%></td>
          <td><%=rst.getString(9)%></td>
          <td><%=rst.getString(10)%></td>
        </tr>
               <%
            }
rst.close();
            }
            catch(Exception ex)
            {
               System.out.println("error in hospital  table"+ex);
            }
            sd.Disconnect();
        %>
    </table>

        <%@include file="Footer.jsp" %>
    </body>
</html>
