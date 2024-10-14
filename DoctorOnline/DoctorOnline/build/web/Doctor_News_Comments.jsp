<%-- 
    Document   : Doctor_News_Comments
    Created on : Dec 28, 2021, 5:28:07 PM
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
        <title>News and Comments</title>
        <style type="text/css">
        </style>
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
        SQLDemo sd=new SQLDemo();
        ArrayList aobj=new ArrayList();
        aobj=(ArrayList)request.getAttribute("list");
        %>
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
        <div class="container">
        <div class="row gx-6">
        <div class="col-lg-6">
                    <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                        <h1 class="text-white mb-4">News and Comments</h1>
                        <form name="news_comments" action="News_Comment_Servlet">
                            <div class="row g-3">
                                <div class="col-12 sm-6">
                                <select name="NEWSID" class="form-select bg-light border-0 mb-3" style="height: 40px;">
                                    <option value="<%=aobj.get(0).toString()%>"><%=aobj.get(1).toString()%></option>
                                        </select>
                                </div>
                                <div class="col-12 col-sm-12">
                                    <input type="text" name="commdesctxt" class="form-control bg-light border-0" placeholder="Comment Description" style="height: 55px;">
                                </div>
                                <div class="col-12">
                                    <button name="sbtn" value="Save"class="btn btn-dark w-100 py-3" type="submit">Save</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
     </div>
              </div>
        </div>       
         <div class="col-md-6">
    </div>
        <%@include file="Footer.jsp" %>
    </body>
</html>
