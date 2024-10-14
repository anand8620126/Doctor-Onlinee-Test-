<%-- 
    Document   : Appointmenteditbydoctor
    Created on : Jan 17, 2022, 3:50:52 PM
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
        <title>Appointment edit Page</title>
    </head>
    <body>
        <%@include file="DoctorHeader.jsp" %>
          <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        ArrayList aobj;
        %>
        <%
             
            sd=new SQLDemo();
        aobj=(ArrayList)request.getAttribute("list");
      
        %>
    <center>
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
        <div class="container">
         <div class="col-lg-6">
                    <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                        <h1 class="text-white mb-4">Edit Appointment</h1>
                        <form name="makeappointmentform" action="http://localhost:8084/DoctorOnline/DoctorOnlineServlet">
                            <div class="row g-3">
                                 <div class="col-12 col-sm-6">
                                     <select name="userid" class="form-select bg-light border-0 mb-3" style="height: 40px;">
                                <%
                                    String a_userid=aobj.get(1).toString();
                                    sd.Connect();
                                try
                                {
                                 pst=sd.con.prepareStatement("select User_ID,Name from tbUser");
                                 rst=pst.executeQuery();
                                 while(rst.next())
                                 {
                                 String db_userid=rst.getString(1);
                                 if(db_userid.equals(a_userid))
                                 {%>
                                <option value="<%=db_userid%>" selected="selected"><%=rst.getString(2)%></option>     
                                 <%}
                                else
                                 {%>
                                   <option value="<%=db_userid%>"><%=rst.getString(2)%></option>  
                                 <%}
                                 }
                                 rst.close();
                                }
                                catch(Exception ex)
                                {
                                   System.out.println("error in populating user name"+ex);                                    
                                }
                               sd.Disconnect();
                                %>
                            </select>
                                </div>
                                 <div class="col-12 col-sm-6">
                                    <input type="text" name="patienttxt" class="form-control bg-light border-0" value="<%=aobj.get(3).toString()%>" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="agetxt" class="form-control bg-light border-0" value="<%=aobj.get(4).toString()%>" style="height: 55px;">
                                </div>
                                    <select name="gender" class="col-12 col-sm-6"  class="form-select bg-light border-0" style="height: 55px;">
                                        <%
                                            String gender=aobj.get(5).toString();
                                            if(gender.equals("Male"))
                                            {%>
                                            <option value="Male" selected="selected">Male</option>
                                            <%}
                                            else
                                            {%>
                                            <option value="Male">Male</option>
                                            <%}
                                           if(gender.equals("Female"))
                                           {%>
<option value="Female" selected="selected">Female</option>
                                           <%}
                                      else
                                      {%>
 <option value="Female">Female</option>
                                         <%}
                                        %>
                                    </select>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="msymtxt" class="form-control bg-light border-0" value="<%=aobj.get(6).toString()%>" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="prevtrmtxt" class="form-control bg-light border-0" value="<%=aobj.get(7).toString()%>" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="pdtxt" class="form-control bg-light border-0" value="<%=aobj.get(8).toString()%>" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="date" name="adtxt" class="form-control bg-light border-0" value="<%=aobj.get(9).toString()%>" style="height: 55px;">
                                </div>
                                    <div class="col-12 col-sm-6">
                                    <input type="text" name="astxt" class="form-control bg-light border-0" value="<%=aobj.get(10).toString()%>" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="time" id="time1" data-target-input="nearest">
                                        <input type="text" name="attxt"value="<%=aobj.get(11).toString()%>"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                             data-target="#time1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                  <div class="col-12 col-sm-6">
                                    <input type="text" name="atypetxt" class="form-control bg-light border-0" value="<%=aobj.get(12).toString()%>" style="height: 55px;">
                                </div>                                      
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="natxt" value="<%=aobj.get(13).toString()%>" class="form-control bg-light border-0"  style="height: 55px;">
                                </div>
                                <select name="acdecradio" class="col-12 col-sm-6" value="" class="form-select bg-light border-0" style="height: 55px;">
                                  
                                        <option value="Accept" selected="selected">Accept</option>
                                        <option value="Decline">Decline</option>
                                    </select>
                                <div class="col-12">
                                    <button name="sbtn" value="Update"class="btn btn-dark w-100 py-3" type="submit">Update Appointment</button>
                                </div>
                                    
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
        </div>
        </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
