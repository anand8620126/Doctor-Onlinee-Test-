<%-- 
    Document   : Doctor_Registration
    Created on : Dec 24, 2021, 2:26:20 PM
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
        <title>Doctor Registration</title>
        <script type="text/javascript">
           var num;
           function generateotp(){ 
     
 num=Math.random();

document.getElementById("otp").innerHTML=parseInt(num*1000000);
}

            function validateForm()
            {
                 var drnametxt=document.forms["doctorreg"]["drnametxt"].value;
               var x=document.forms["doctorreg"]["pwdtxt"].value;
                var addtxt=document.forms["doctorreg"]["addtxt"].value;
                var citytxt=document.forms["doctorreg"]["citytxt"].value;
                var phtxt=document.forms["doctorreg"]["phtxt"].value;
                var qlftxt=document.forms["doctorreg"]["qlftxt"].value;
                var exptxt=document.forms["doctorreg"]["exptxt"].value;
                var spctxt=document.forms["doctorreg"]["spctxt"].value;
                 var otptxt=document.forms["doctorreg"]["otptxt"].value;
                var prevhosntxt=document.forms["doctorreg"]["prevhosntxt"].value;
                if(drnametxt==null||drnametxt=="")
                {
                  alert("Doctor Name must be filled out");
                    return false;
                }   else     
        if (x==null || x=="")
                {
                  alert("Password must be filled out");
                    return false;
                }else
                if(x.length<8||x.length>15)
                {
                    alert("Password should be in between 8-15 charcters");
                    return false;
                }else
                if (addtxt==null || addtxt=="")
                {
                  alert("address must be filled out");
                    return false;
                }else
                if (citytxt==null || citytxt=="")
                {
                  alert("city must be filled out");
                    return false;
                }else
                if (phtxt==null || phtxt=="")
                {
                  alert("phone number must be filled out");
                    return false;
                }else
                if(phtxt.length<10||phtxt.length>10)
                {
                    alert("Check your Phone Number");
                    return false;
                }else
                
                if (qlftxt==null || qlftxt=="")
                {
                  alert("qualification must be filled out");
                    return false;
                }else
                if (exptxt==null || exptxt=="")
                {
                  alert("Experience must be filled out");
                    return false;
                }else
                if (spctxt==null || spctxt=="")
                {
                  alert("Specialization must be filled out");
                    return false;
                }else
                if (prevhosntxt==null || prevhosntxt=="")
                {
                  alert("Specialization must be filled out");
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
         <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        %>
        <%
        SQLDemo sd=new SQLDemo();
        %>
         <%@include file="Header.jsp" %>
   <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form name="doctorreg" onsubmit="return validateForm()" action="DoctorServlet">
                        <div class="row g-3">
                            <div class="col-12">
                                <input type="text" name="drnametxt"class="form-control border-0 bg-light px-4" placeholder="Doctor Name" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="pwdtxt"class="form-control border-0 bg-light px-4" placeholder="Password" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="addtxt"class="form-control border-0 bg-light px-4" placeholder="Address" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="citytxt"class="form-control border-0 bg-light px-4" placeholder="City" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                 
                                <input type="number" onchange="generateotp()" name="phtxt"class="form-control border-0 bg-light px-4" placeholder="Phone" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <font color="white">  <span id="otp"></span></font>
                                <input type="text" name="otptxt"class="form-control border-0 bg-light px-4" placeholder="OTP" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="qlftxt"class="form-control border-0 bg-light px-4" placeholder="Qualification" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="exptxt"class="form-control border-0 bg-light px-4" placeholder="Experience" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" name="spctxt"class="form-control border-0 bg-light px-4" placeholder="Specialization" style="height: 55px;">
                            </div>
                           <select name="hospitalid">
                <%
                    sd.Connect();
                    try
                    {
                    pst=sd.con.prepareStatement("select Hospital_ID,Hospital_Name from tbHospital");
                    rst=pst.executeQuery();
                    while(rst.next())
                    {%>
                    <option value="<%=rst.getString(1)%>"><%=rst.getString(2)%></option>
                    <%
                    }
                    rst.close();
                    }
                    catch(Exception ex)
                    {
                    System.out.println("error in finding hospital"+ex);
                    }
                    %>
            </select>
                            <div class="col-12">
                                <input type="text" name="prevhosntxt"class="form-control border-0 bg-light px-4" placeholder="Previous Hospital Name" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="submit" name="sbtn" value="Registered" class="btn btn-primary w-100 py-3">
                            </div>
                        </div>
                    </form>
                </div>
        </center>
        <%@include file="Footer.jsp" %>
    </body>
</html>
