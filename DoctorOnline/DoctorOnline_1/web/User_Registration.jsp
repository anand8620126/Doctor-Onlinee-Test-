<%-- 
    Document   : User_Registration
    Created on : Dec 24, 2021, 8:44:38 AM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration </title>
        <script type="text/javascript">
            var num;
  function generateotp(){ 
     
 num=Math.random();

document.getElementById("otp").innerHTML=parseInt(num*1000000);
}

            function validateForm()
            {
                var nametxt=document.forms["userreg"]["nametxt"].value;
                var x=document.forms["userreg"]["pwdtxt"].value;
                 var statetxt=document.forms["userreg"]["statetxt"].value;
                var addresstxt=document.forms["userreg"]["addresstxt"].value;
                var citytxt=document.forms["userreg"]["citytxt"].value;
                var phonetxt=document.forms["userreg"]["phonetxt"].value;
                var emailtxt=document.forms["userreg"]["emailtxt"].value;
                var atpos=emailtxt.indexOf("@");
                var dotpos=emailtxt.lastIndexOf(".");
                var otptxt=document.forms["userreg"]["otptxt"].value;
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
                if(x.length<8|| x.length>15)
                {
                    alert("Password length must be between 8-15 charcters");
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
                    alert("State Must be filled out");
                    return false;
                }
                if(!num.equals(otptxt))
                {
                    alert("otp mismatch");
                    return false;
                }
                if(otptxt==null||otptxt==""){
                    alert("Enter Otp");
                    return false;
                }
            }
            
         </script>
    </head>
    <body>
        <%@include file="Header.jsp" %>
    <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form name="userreg" onsubmit="return validateForm()" action="UserServlet">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" name="nametxt"class="form-control border-0 bg-light px-4" placeholder="Your Name" style="height: 55px;" pattern="[a-zA-Z]{2,}">
                            </div>
                            <div class="col-12">
                                <input type="text" name="pwdtxt"class="form-control border-0 bg-light px-4" placeholder="Your Password" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="addresstxt"class="form-control border-0 bg-light px-4" placeholder="Address" style="height: 55px;">
                            </div>
                             <div class="col-12">
                                <input type="text" name="citytxt"class="form-control border-0 bg-light px-4" placeholder="City" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="statetxt"class="form-control border-0 bg-light px-4" placeholder="State" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="number"  name="phonetxt"class="form-control border-0 bg-light px-4" placeholder="Phone" style="height: 55px;" >
                            </div>
                            <div class="col-12">
                                <input type="email" onchange="generateotp()" name="emailtxt"class="form-control border-0 bg-light px-4" placeholder="Email" style="height: 55px;">
                            </div>
                            
                            <div class="col-12">
                                <span id="otp"></span>
                                <input type="text" name="otptxt"class="form-control border-0 bg-light px-4" placeholder="OTP" style="height: 55px;">
                            </div>
                            
                            <div class="col-12" >
                                <input type="submit" name="sbtn" value="Registered" class="btn btn-primary w-100 py-3" >
                            </div>
                        </div>
                    </form><br>
                    <font color="white">   Already registered!! </font><a href="User_Login.jsp">Login Here</a>
                </div>
        </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
