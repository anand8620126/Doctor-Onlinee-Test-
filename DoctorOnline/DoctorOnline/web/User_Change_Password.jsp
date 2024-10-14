<%-- 
    Document   : User_Change_Password
    Created on : Dec 27, 2021, 9:52:44 AM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <script type="text/javascript">
            function validateform()
            {
                var emailtxt=document.forms["userchangepassword"]["emailtxt"].value;
                var pwdtxt=document.forms["userchangepassword"]["pwdtxt"].value;
                var npwdtxt=document.forms["userchangepassword"]["npwdtxt"].value;
                
                var atpos=emailtxt.indexOf("@");
                var dotpos=emailtxt.lastIndexOf(".");
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
                if(pwdtxt==null || pwdtxt=="")
                {
                    alert("Enter Old Password");
                    return false;
                }
                if(npwdtxt==null || npwdtxt=="")
                {
                    alert("Enter New Password");
                    return false;
                }
              
                if(npwdtxt.length<8|| npwdtxt.length>15)
                {
                    alert("Password length must be between 8-15 charcters");
                    return false;
                }
               if(npwdtxt==pwdtxt)
               {
                   alert("Password must be different");
                   return false;
               }
            }
            </script>
    </head>
    <body> 
        <%@include file="UserHeader.jsp" %>
         <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form name="userchangepassword" action="UserServlet" onsubmit="return validateform()">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="email" name="emailtxt"class="form-control border-0 bg-light px-4" placeholder="Your Email" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="password" name="pwdtxt"class="form-control border-0 bg-light px-4" placeholder="Old Password" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="password" name="npwdtxt"class="form-control border-0 bg-light px-4" placeholder="New Password" style="height: 55px;">
                            </div>
                           
                           <div class="col-12">
                                <input type="submit" name="sbtn" value="Change Password" class="btn btn-primary w-100 py-3">
                            </div>
                        </div>
                    </form>
                </div>
        </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
