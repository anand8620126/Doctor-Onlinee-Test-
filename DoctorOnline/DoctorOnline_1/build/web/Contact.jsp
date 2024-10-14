<%-- 
    Document   : Contact
    Created on : Dec 28, 2021, 11:43:05 AM
    Author     : Anjali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <script type="text/javascript">
            function validateform(){
                var nametxt=document.forms["contactform"]["nametxt"].value;
                var subtxt=document.forms["contactform"]["subtxt"].value;
                var emailtxt=document.forms["contactform"]["emailtxt"].value;
                var atpos=emailtxt.indexOf("@");
                var dotpos=emailtxt.lastIndexOf(".");
                if (nametxt==null || nametxt=="")
                {
                  alert(" Name must be filled out");
                    return false;
                }  
                if (emailtxt==null || emailtxt=="")
                {
                  alert(" Email must be filled out");
                    return false;
                }  
                if (subtxt==null || subtxt=="")
                {
                  alert(" Subject must be filled out");
                    return false;
                }  
                 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=emailtxt.length)
                { 
                    alert("Not a valid e-mail address");
                    return false;  
                }
            }
            </script>
    </head>
    <body>
        <%@include file="Header.jsp" %>
    <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
                    <form name="contactform" action="ContactServlet" onsubmit="return validateform()">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" name="nametxt" class="form-control border-0 bg-light px-4" placeholder="Your Name" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="email" name="emailtxt"class="form-control border-0 bg-light px-4" placeholder="Your Email" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="subtxt" class="form-control border-0 bg-light px-4" placeholder="Subject" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <textarea class="form-control border-0 bg-light px-4 py-3" name="msgtxt"rows="5" placeholder="Message"></textarea>
                            </div>
                            <div class="col-12">
                                <input type="submit" value="Send Message" class="btn btn-primary w-100 py-3" name="sbtn">
                            </div>
                        </div>
                    </form>
                </div>
    </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
