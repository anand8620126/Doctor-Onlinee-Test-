<%-- 
    Document   : Doctor_My_Profile
    Created on : Dec 28, 2021, 8:36:03 PM
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
                 var drnametxt=document.forms["drmyprofile"]["drnametxt"].value;
               var x=document.forms["drmyprofile"]["pwdtxt"].value;
                var addtxt=document.forms["drmyprofile"]["addtxt"].value;
                var citytxt=document.forms["drmyprofile"]["citytxt"].value;
                var phtxt=document.forms["drmyprofile"]["phtxt"].value;
                var qlftxt=document.forms["drmyprofile"]["qlftxt"].value;
                var exptxt=document.forms["drmyprofile"]["exptxt"].value;
                var spctxt=document.forms["drmyprofile"]["spctxt"].value;
                var prevhosntxt=document.forms["drmyprofile"]["prevhosntxt"].value;
                if (drnametxt==null || drnametxt=="")
                {
                  alert("Doctor Name must be filled out");
                    return false;
                }        
        if (x==null || x=="")
                {
                  alert("Password must be filled out");
                    return false;
                }
                if(x.length<8||x.length>15)
                {
                    alert("Password should be in between 8-15 charcters");
                    return false;
                }
                if (addtxt==null || addtxt=="")
                {
                  alert("address must be filled out");
                    return false;
                }
                if (citytxt==null || citytxt=="")
                {
                  alert("city must be filled out");
                    return false;
                }
                if (phtxt==null || phtxt=="")
                {
                  alert("phone number must be filled out");
                    return false;
                }
                if(phtxt.length<10||phtxt.length>10)
                {
                    alert("Check your Phone Number");
                    return false;
                }
                
                if (qlftxt==null || qlftxt=="")
                {
                  alert("qualification must be filled out");
                    return false;
                }
                if (exptxt==null || exptxt=="")
                {
                  alert("Experience must be filled out");
                    return false;
                }
                if (spctxt==null || spctxt=="")
                {
                  alert("Specialization must be filled out");
                    return false;
                }
                if (prevhosntxt==null || prevhosntxt=="")
                {
                  alert("Specialization must be filled out");
                    return false;
                }
            }
         </script>
    </head>
    <body>
        <%@include file="DoctorHeader.jsp" %>
        <center>
        <div class="col-xl-4 col-lg-6 wow slideInUp" data-wow-delay="0.3s">
            <form name="drmyprofile" action="DoctorServlet" onsubmit="return validateform()">
                        <%!
        PreparedStatement pst;
        ResultSet rst;
        SQLDemo sd;
        String a_hospid;
        %>
        <%
        SQLDemo sd=new SQLDemo();
        sd.Connect();
        try
        {
        pst=sd.con.prepareStatement("select * from tbDoctor where Doctor_ID=?");
        pst.setLong(1,Long.parseLong(session.getAttribute("doctorid").toString()));
        rst=pst.executeQuery();
        if(rst.next())
        {
             
            %>
                    <div class="row g-3">
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(2)%>" name="drnametxt"class="form-control border-0 bg-light px-4" placeholder="Doctor Name" style="height: 55px;">
                            </div>
            <div class="col-12">
                                <input type="password" value="<%=rst.getString(3)%>" name="pwdtxt"class="form-control border-0 bg-light px-4" placeholder="Password" style="height: 55px;">
                            </div>
            <div class="col-12">
                                <input type="text" value="<%=rst.getString(4)%>" name="addtxt"class="form-control border-0 bg-light px-4" placeholder="Address" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(5)%>" name="citytxt"class="form-control border-0 bg-light px-4" placeholder="City" style="height: 55px;">
                            </div>
            <div class="col-12">
                                <input type="text" value="<%=rst.getString(6)%>" name="phtxt"class="form-control border-0 bg-light px-4" placeholder="Phone" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(7)%>" name="qlftxt"class="form-control border-0 bg-light px-4" placeholder="Qualification" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(8)%>" name="exptxt"class="form-control border-0 bg-light px-4" placeholder="Experience" style="height: 55px;">
                            </div>
                            <div class="col-12">
                                <input type="text" value="<%=rst.getString(9)%>" name="spctxt"class="form-control border-0 bg-light px-4" placeholder="Specialization" style="height: 55px;">
                            </div>
                            <%
                             a_hospid=rst.getString(10);
                            %>
                            <div class="col-12">
            <input type="text"  value="<%=rst.getString(11)%>" name="prevhosntxt" class="form-control border-0 bg-light px-4" placeholder="Previous Hospital Name" style="height: 55px;">
                            </div> 
                       
        <%
        }
rst.close();
        }
        catch(Exception ex)
        {
        System.out.println("error in populating"+ex);
        }
        %>
        <select name="hospitalid" class="form-select bg-light border-0 mb-3" style="height: 40px;">
                                <%
                                try
                                {
                                 pst=sd.con.prepareStatement("select Hospital_ID,Hospital_Name from tbHospital");
                                 rst=pst.executeQuery();
                                 while(rst.next())
                                 {
                                     
                                 String db_hospid=rst.getString(1);
                                 if(db_hospid.equals(a_hospid))
                                 {%>
                                <option value="<%=db_hospid%>" selected="selected"><%=rst.getString(2)%></option>     
                                 <%}
                                else
                                 {%>
                                   <option value="<%=db_hospid%>"><%=rst.getString(2)%></option>  
                                 <%}
                                 }
                                 rst.close();
                                }
                                catch(Exception ex)
                                {
                                   System.out.println("error in populating hospital name"+ex);                                    
                                }
                                %>
                            </select>
                       
                            <div class="col-12">
                                <input type="submit" name="sbtn" value="Update" class="btn btn-primary w-100 py-3">
                            </div>
                        </div>
                    </form>
                </div>
        </center>
       
                    <%@include file="Footer.jsp" %>
    </body>
</html>
