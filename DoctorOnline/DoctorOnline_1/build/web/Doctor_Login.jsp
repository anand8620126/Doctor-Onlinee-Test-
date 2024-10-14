
<%-- 
    Document   : Doctor_Login
    Created on : Dec 24, 2021, 4:05:19 PM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Login</title>
        <script type="text/javascript">
            function validateForm()
            {
                 var y=document.forms["drlogin"]["phtxt"].value;
               var x=document.forms["drlogin"]["pwdtxt"].value;
                
        if (y==null || y=="")
                {
                  alert("Phone number must be filled out");
                    return false;
                }        
        if (x==null || x=="")
                {
                  alert("Password must be filled out");
                    return false;
                }
                
            }
         </script>
    </head>
    <body>
       <%@include file="Header.jsp" %>
    <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form action="DoctorServlet" onsubmit="return validateForm()" name="drlogin">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" name="phtxt" class="form-control border-0 bg-light px-4" placeholder="Your Mobile Number" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="password" name="pwdtxt" class="form-control border-0 bg-light px-4" placeholder="Password" style="height: 55px;">
                            </div>
                            
                            <div class="col-12">
                                <input type="submit" name="sbtn" value="Login" class="btn btn-primary w-100 py-3">
                            </div>
                        </div>
                    </form>
                </div>
    </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
