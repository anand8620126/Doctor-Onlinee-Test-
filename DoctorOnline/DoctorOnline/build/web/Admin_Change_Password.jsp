<%-- 
    Document   : Admin_Change_Password
    Created on : Dec 28, 2021, 9:59:40 AM
    Author     : Anjali 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function validateform()
            {
                var nametxt=document.forms["adminchangepassword"]["adminnametxt"].value;
                var pwdtxt=document.forms["adminchangepassword"]["pwdtxt"].value;
                var npwdtxt=document.forms["adminchangepassword"]["npwdtxt"].value;
               
                
                if(nametxt==null || nametxt=="")
                {
                    alert("Name must filled out");
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
                if(npwdtxt==pwdtxt)
                {
                    alert("password should be different");
                    return false;
                }
                if(npwdtxt.length<8|| npwdtxt.length>15)
                {
                    alert("Password length must be between 8-15 charcters");
                    return false;
                }
                
            }
            </script>
    </head>
    <body>
        <%@include file="Admin_Header.jsp" %>
         <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form name="adminchangepassword" action="AdminServlet" onsubmit="return validateform()">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" name="adminnametxt"class="form-control border-0 bg-light px-4" placeholder="Your Name" style="height: 55px;">
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
