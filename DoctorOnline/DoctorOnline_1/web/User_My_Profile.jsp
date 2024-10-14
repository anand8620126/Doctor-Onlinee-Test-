<%-- 
    Document   : User_My_Profile
    Created on : Dec 29, 2021, 4:47:51 PM
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
        <title>My Profile</title>
        <script type="text/javascript">
            function validateForm()
            {
                 var nametxt=document.forms["userprofile"]["nametxt"].value;
                  var statetxt=document.forms["userprofile"]["statetxt"].value;
               var x=document.forms["userprofile"]["pwdtxt"].value;
                var addresstxt=document.forms["userprofile"]["addresstxt"].value;
                var citytxt=document.forms["userprofile"]["citytxt"].value;
                var phonetxt=document.forms["userprofile"]["phonetxt"].value;
                var emailtxt=document.forms["userprofile"]["emailtxt"].value;
                 var atpos=emailtxt.indexOf("@");
                var dotpos=emailtxt.lastIndexOf(".");
                
        if (nametxt==null || nametxt=="")
                {
                  alert(" Name must be filled out");
                    return false;
                }        
        if (x==null || x=="")
                {
                  alert("Password must be filled out");
                    return false;
                }
                if (addresstxt==null || addresstxt=="")
                {
                  alert("address must be filled out");
                    return false;
                }
                if (citytxt==null || citytxt=="")
                {
                  alert("city must be filled out");
                    return false;
                }
                if (phonetxt==null || phonetxt=="")
                {
                  alert("phone number must be filled out");
                    return false;
                }
                if(emailtxt==null || emailtxt=="")
                {
                    alert("Email must filled out");
                    return false;
                }
                if (atpos<1 || dotpos<atpos+2 || dotpos+2>=emailtxt.length)
                { 
                    alert("Not a valid e-mail address");
                    return false;  
                }
                if(phonetxt.length<10||phonetxt.length>10)
                {
                    alert("Check your Phone Number");
                    return false;
                }
                if(statetxt==null||statetxt=="")
                {
                    alert("State must be filled out");
                    return false;
                }
            }
            
         </script>
    </head>
    <body>
     <!--  Copy user registration form here
     run select * from tbuser where userid=sessionn value on the top and populate
     all values in textboxes and use update button down there to call servlet for update-->
         <%@include file="UserHeader.jsp" %>
    <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form name="userprofile" action="UserServlet" onsubmit="return validateForm()">
                        
                        <%!
                        PreparedStatement pst;
                        ResultSet rst;
                        SQLDemo sd;
                        %>
                        <%
                        sd=new SQLDemo();
                        sd.Connect();
                        try
                        {     
                         pst=sd.con.prepareStatement("select * from tbUser where User_ID=?");
                         pst.setLong(1,Long.parseLong(session.getAttribute("userid").toString()));
                         rst=pst.executeQuery();
                         if(rst.next())
                         {%>
                          <div class="row g-3">
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(2)%>" name="nametxt"class="form-control border-0 bg-light px-4" placeholder="Your Name" style="height: 55px;"pattern="[a-zA-Z]{2,}">
                            </div>
                          <div class="col-12">
                                <input type="text" value="<%=rst.getString(3)%>" name="pwdtxt"class="form-control border-0 bg-light px-4" placeholder="Your Password" style="height: 55px;">
                            </div>
                          <div class="col-12">
                                <input type="text" value="<%=rst.getString(4)%>" name="addresstxt"class="form-control border-0 bg-light px-4" placeholder="Address" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(5)%>" name="citytxt"class="form-control border-0 bg-light px-4" placeholder="City" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(6)%>" name="statetxt"class="form-control border-0 bg-light px-4" placeholder="State" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="number" value="<%=rst.getString(7)%>" name="phonetxt"class="form-control border-0 bg-light px-4" placeholder="Phone" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="email" value="<%=rst.getString(8)%>" name="emailtxt"class="form-control border-0 bg-light px-4" placeholder="Email" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(9)%>" name="regdtxt"class="form-control border-0 bg-light px-4" placeholder="Registration Date" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="submit" name="sbtn" value="Update" class="btn btn-primary w-100 py-3">
                            </div>
                            </div>
                            <%
                         }
                         rst.close();
                        }      
                         catch(Exception ex)
                         {
                         System.out.println("error in populating userprofile data"+ex);
                         }
                        sd.Disconnect();
                        %>
                    </form>
                </div>
        </center>
        <%@include file="Footer.jsp"%>
    </body>
</html>
