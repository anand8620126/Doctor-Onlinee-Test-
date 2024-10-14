<%-- 
    Document   : Update_News_Comment
    Created on : Jan 4, 2022, 12:19:21 PM
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
        <title> update news comment</title>
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
        aobj=new ArrayList();
        aobj=(ArrayList)request.getAttribute("list");
        %>
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
        <div class="container">
        <div class="row gx-5">
        <div class="col-lg-6">
                    <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                        <h1 class="text-white mb-4">News and Comments</h1>
                        <form name="news_comments" action="News_Comment_Servlet">
                            <div class="row g-3">
                                <div class="col-12 col-sm-6">
                                    <select name="newsid" class="form-select bg-light border-0" style="height: 55px;">
                                        <%
                                            String n_newsid=aobj.get(1).toString();
                    sd.Connect();
                    try
                    {
                    pst=sd.con.prepareStatement("select NewsID,News_Title from tbNews");
                    rst=pst.executeQuery();
                    while(rst.next())
                    { 
                                        String db_newsid=rst.getString(1);
                    if(db_newsid.equals(n_newsid))
                    {%>
                    <option value="<%=db_newsid%>" selected="selected"><%=rst.getString(2)%></option>    
                    <%}
                  else
                  {%>
<option value="<%=db_newsid%>"><%=rst.getString(2)%></option>
                  <%}
                                        %>
                    
                    <%
                    }
                    rst.close();
                    }
                    catch(Exception ex)
                    {
                    System.out.println("error in finding news"+ex);
                    }
                    %>
                                    </select>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <select name="drid" class="form-select bg-light border-0" style="height: 55px;">
                                        <%
                    String d_drid=aobj.get(2).toString();
                    try
                    {
                    pst=sd.con.prepareStatement("select Doctor_ID,Doctor_Name from tbDoctor");
                    rst=pst.executeQuery();
                    while(rst.next())
                    {
                        String db_drid=rst.getString(1);
                        if(db_drid.equals("d_drid"))
                        {%>
                        <option value="<%=db_drid%>" selected="selected"><%=rst.getString(2)%></option>    
                        <%}
                        else
                        {%>
                        <option value="<%=db_drid%>"><%=rst.getString(2)%></option>
                        <%}
                                        %>
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
                                    <input type="text"  value="<%=aobj.get(3).toString()%>"name="commdesctxt" class="form-control bg-light border-0" placeholder="Comment Description" style="height: 55px;">
                                </div>
                                <div class="col-12 col-sm-6">
                                    <div class="date" id="date1" data-target-input="nearest">
                                        <input type="text" name="dateofcommtxt" value="<%=aobj.get(4).toString()%>"
                                            class="form-control bg-light border-0 datetimepicker-input"
                                            placeholder="Date Of Comment" data-target="#date1" data-toggle="datetimepicker" style="height: 55px;">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <input type="text" value="<%=aobj.get(5).toString()%>" name="statustxt" class="form-control bg-light border-0" placeholder="Status" style="height: 55px;">
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
