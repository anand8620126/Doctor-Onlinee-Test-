<%-- 
    Document   : Admin_Manage_News
    Created on : Dec 2023, 11:32:05 AM
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
        <title>Manage News</title>
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
        <%@include file="Admin_Header.jsp" %>
        <%!
        PreparedStatement pst;
        ResultSet rst;
        %>
        <%
        SQLDemo sd=new SQLDemo();
        %>
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
        
        <table border="5px solid yellow">
            <tr><th>News ID</th><th>News Date</th><th>News Title</th><th>News Description</th><th>Status</th></tr>
        <%
            sd.Connect();
            try
            {
            pst=sd.con.prepareStatement("select * from tbNews");
            rst=pst.executeQuery();
            while(rst.next())
            {
                %>
        <form name="newsform" action="NewsServlet">
            <tr>
                <td><input type="text" name="newsidtxt" value="<%=rst.getString(1)%>" style="visibility:hidden;">
                    <input type="submit" value="Edit" name="sbtn">
                </td>
        </form>
          <td><%=rst.getString(2)%></td>
          <td><%=  rst.getString(3)%></td>
            <td><%=rst.getString(4)%></td>
              <td><%=rst.getString(5)%></td>
        </tr>
               <%
            }
rst.close();
            }
            catch(Exception ex)
            {
               System.out.println("error in news  table"+ex);
            }
            sd.Disconnect();
        %>
    </table>
        
        <%@include file="Footer.jsp" %>
    </body>
</html>
