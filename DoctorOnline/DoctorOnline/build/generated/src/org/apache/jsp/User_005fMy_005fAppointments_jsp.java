package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Servlet.SQLDemo;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public final class User_005fMy_005fAppointments_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        PreparedStatement pst;
        ResultSet rst;
        ResultSet rst1;
        ResultSet rst2;
        SQLDemo sd;
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/UserHeader.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>My Appointments</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

        sd=new SQLDemo();
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("       <title>Doctor Online - Dental Clinic </title>\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n");
      out.write("    <meta content=\"Free HTML Templates\" name=\"keywords\">\n");
      out.write("    <meta content=\"Free HTML Templates\" name=\"description\">\n");
      out.write("\n");
      out.write("    <!-- Favicon -->\n");
      out.write("    <link href=\"img/favicon.ico\" rel=\"icon\">\n");
      out.write("\n");
      out.write("    <!-- Google Web Fonts -->\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap\" rel=\"stylesheet\"> \n");
      out.write("\n");
      out.write("    <!-- Icon Font Stylesheet -->\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Libraries Stylesheet -->\n");
      out.write("    <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"lib/animate/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"lib/twentytwenty/twentytwenty.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Template Stylesheet -->\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("     <!-- Spinner Start \n");
      out.write("    <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\n");
      out.write("        <div class=\"spinner-grow text-primary m-1\" role=\"status\">\n");
      out.write("            <span class=\"sr-only\">Loading...</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"spinner-grow text-dark m-1\" role=\"status\">\n");
      out.write("            <span class=\"sr-only\">Loading...</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"spinner-grow text-secondary m-1\" role=\"status\">\n");
      out.write("            <span class=\"sr-only\">Loading...</span>\n");
      out.write("        </div>\n");
      out.write("    </div>-->\n");
      out.write("    <!-- Spinner End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Topbar Start -->\n");
      out.write("    <div class=\"container-fluid bg-light ps-5 pe-0 d-none d-lg-block\">\n");
      out.write("        <div class=\"row gx-0\">\n");
      out.write("            <div class=\"col-md-6 text-center text-lg-start mb-2 mb-lg-0\">\n");
      out.write("                <div class=\"d-inline-flex align-items-center\">\n");
      out.write("                    <small class=\"py-2\"><i class=\"far fa-clock text-primary me-2\">\n");
      out.write("                        \n");
      out.write("                        </i>Opening Hours: Mon - Tues : 6.00 am - 10.00 pm, Sunday Closed </small>\n");
      out.write("                </div>\n");
      out.write("                <div style=\"font-family: inherit;color:#D3DA06;font-size: 24px;\">\n");
      out.write("Welcome ");
      out.print(session.getAttribute("name").toString());
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-6 text-center text-lg-end\">\n");
      out.write("                <div class=\"position-relative d-inline-flex align-items-center bg-primary text-white top-shape px-5\">\n");
      out.write("                    <div class=\"me-3 pe-3 border-end py-2\">\n");
      out.write("                        <p class=\"m-0\"><i class=\"fa fa-envelope-open me-2\"></i>info@example.com</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"py-2\">\n");
      out.write("                        <p class=\"m-0\"><i class=\"fa fa-phone-alt me-2\"></i>+012 345 6789</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Topbar End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Navbar Start -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg bg-white navbar-light shadow-sm px-5 py-3 py-lg-0\" style=\"margin-bottom: 15px\">\n");
      out.write("        <a href=\"#\" class=\"navbar-brand p-0\">\n");
      out.write("            <h1 class=\"m-0 text-primary\">Doctor Online</h1>\n");
      out.write("        </a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n");
      out.write("            <div class=\"navbar-nav ms-auto py-0\">\n");
      out.write("                \n");
      out.write("                <a href=\"User_Pending_Appointments.jsp\" class=\"nav-item nav-link\">Pending Appointments</a>\n");
      out.write("                <a href=\"User_My_Appointments.jsp\" class=\"nav-item nav-link\">My Appointments</a>\n");
      out.write("                <a href=\"Make_Appointment.jsp\" class=\"nav-item nav-link\">Make Appointments</a>\n");
      out.write("                <a href=\"User_My_Treatments.jsp\" class=\"nav-item nav-link\">My Treatments</a>\n");
      out.write("                <a href=\"User_My_Profile.jsp\" class=\"nav-item nav-link\">My Profile</a>\n");
      out.write("                <a href=\"User_Change_Password.jsp\" class=\"nav-item nav-link\">Change Password</a>\n");
      out.write("                <a href=\"UserServlet?sbtn=LogOut\" class=\"nav-item nav-link\">Log Out</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <!-- Navbar End -->\n");
      out.write("    <!-- Full Screen Search Start -->\n");
      out.write("    <div class=\"modal fade\" id=\"searchModal\" tabindex=\"-1\">\n");
      out.write("        <div class=\"modal-dialog modal-fullscreen\">\n");
      out.write("            <div class=\"modal-content\" style=\"background: rgba(9, 30, 62, .7);\">\n");
      out.write("                <div class=\"modal-header border-0\">\n");
      out.write("                    <button type=\"button\" class=\"btn bg-white btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body d-flex align-items-center justify-content-center\">\n");
      out.write("                    <div class=\"input-group\" style=\"max-width: 600px;\">\n");
      out.write("                        <input type=\"text\" class=\"form-control bg-transparent border-primary p-3\" placeholder=\"Type search keyword\">\n");
      out.write("                        <button class=\"btn btn-primary px-4\"><i class=\"bi bi-search\"></i></button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Full Screen Search End -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <table border=\"5px solid #ccc\">\n");
      out.write("            <tr><th>Appointment ID</th><th>Doctor Name</th><th>Patient Name</th><th>Age</th><th>Gender</th><th>Major Symptoms</th><th>Previous Treatment</th><th>Problem Description</th><th>Appointment Date</th><th>Appointment Status</th><th>Appointment Time</th><th>Appointment Type</th><th>Next Appointment</th></tr>\n");
      out.write("         ");

         sd.Connect();
         try
         {
         pst=sd.con.prepareStatement("SELECT        dbo.tbAppointment.Appointment_ID, dbo.tbDoctor.Doctor_Name, dbo.tbAppointment.Patient_Name, dbo.tbAppointment.Age, dbo.tbAppointment.Gender, dbo.tbAppointment.Major_Symptoms, "+ 
                         "dbo.tbAppointment.Previous_Treatment, dbo.tbAppointment.Problem_Description, dbo.tbAppointment.Appointment_Date, dbo.tbAppointment.Appointment_Status, dbo.tbAppointment.Appointment_time, "+ 
                         "dbo.tbAppointment.Appointment_type, dbo.tbAppointment.Next_Appointment "+
                      "FROM dbo.tbAppointment INNER JOIN "+
                         "dbo.tbDoctor ON dbo.tbAppointment.Doctor_ID = dbo.tbDoctor.Doctor_ID where User_ID=? and Appointment_Status!='Pending'");
         pst.setLong(1,Long.parseLong(session.getAttribute("userid").toString()));
         rst=pst.executeQuery();
                 while(rst.next())
        {
      out.write("\n");
      out.write("           <td>");
      out.print( rst.getString(1));
      out.write("</td>         <!--  appointment id -->\n");
      out.write("           <td>");
      out.print( rst.getString(2));
      out.write("</td>         <!--  doctor name               -->\n");
      out.write("           <td>");
      out.print( rst.getString(3));
      out.write("</td>       <!--    patient name             -->\n");
      out.write("           <td>");
      out.print( rst.getString(4));
      out.write("</td><!--          age       -->\n");
      out.write("           <td>");
      out.print( rst.getString(5));
      out.write("</td><!--         gender        -->\n");
      out.write("           <td>");
      out.print( rst.getString(6));
      out.write("</td><!--        major symptoms         -->\n");
      out.write("           <td>");
      out.print( rst.getString(7));
      out.write("</td><!--           prev treat      -->\n");
      out.write("           <td>");
      out.print( rst.getString(8));
      out.write("</td><!--   prob desc              -->\n");
      out.write("           <td>");
      out.print( rst.getString(9));
      out.write("</td><!--          app date       -->\n");
      out.write("           <td>");
      out.print( rst.getString(10));
      out.write("</td><!--         app status        -->\n");
      out.write("           <td>");
      out.print( rst.getString(11));
      out.write("</td><!--         app time        -->\n");
      out.write("           <td>");
      out.print( rst.getString(12));
      out.write("</td><!--        app type         -->\n");
      out.write("           <td>");
      out.print( rst.getString(13));
      out.write("</td><!--         next appintment        -->\n");
      out.write("        </tr>\n");
      out.write("                ");
 }
          rst.close();
         }
         catch(Exception ex)
         {
         System.out.print("error in populating appointment data"+ex);
         }
sd.Disconnect();
         
      out.write("\n");
      out.write("       \n");
      out.write("        </table>\n");
      out.write("        ");
      out.write('A');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write(" <div class=\"container-fluid bg-dark text-light py-5 wow fadeInUp\" data-wow-delay=\"0.3s\" style=\"margin-top: 35px;\">\n");
      out.write("        <div class=\"container pt-5\">\n");
      out.write("            <div class=\"row g-5 pt-4\">\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <h3 class=\"text-white mb-4\">Quick Links</h3>\n");
      out.write("                    <div class=\"d-flex flex-column justify-content-start\">\n");
      out.write("                        <a class=\"text-light mb-2\" href=\"index.jsp\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Home</a>\n");
      out.write("                        <a class=\"text-light mb-2\" href=\"About.jsp\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>About Us</a>\n");
      out.write("                        <!--<a class=\"text-light mb-2\" href=\"#\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Our Services</a>-->\n");
      out.write("                        <!--<a class=\"text-light mb-2\" href=\"#\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Latest Blog</a>-->\n");
      out.write("                        <a class=\"text-light\" href=\"Contact.jsp\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Contact Us</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <h3 class=\"text-white mb-4\">Popular Links</h3>\n");
      out.write("                    <div class=\"d-flex flex-column justify-content-start\">\n");
      out.write("                        <a class=\"text-light mb-2\" href=\"index.jsp\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Home</a>\n");
      out.write("                        <a class=\"text-light mb-2\" href=\"About.jsp\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>About Us</a>\n");
      out.write("                       <!-- <a class=\"text-light mb-2\" href=\"#\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Our Services</a>\n");
      out.write("                        <a class=\"text-light mb-2\" href=\"#\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Latest Blog</a>-->\n");
      out.write("                       <a class=\"text-light\" href=\"Contact.jsp\"><i class=\"bi bi-arrow-right text-primary me-2\"></i>Contact Us</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <h3 class=\"text-white mb-4\">Get In Touch</h3>\n");
      out.write("                    <p class=\"mb-2\"><i class=\"bi bi-geo-alt text-primary me-2\"></i>123 Street, New York, USA</p>\n");
      out.write("                    <p class=\"mb-2\"><i class=\"bi bi-envelope-open text-primary me-2\"></i>info@example.com</p>\n");
      out.write("                    <p class=\"mb-0\"><i class=\"bi bi-telephone text-primary me-2\"></i>+012 345 67890</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-6\">\n");
      out.write("                    <h3 class=\"text-white mb-4\">Follow Us</h3>\n");
      out.write("                    <div class=\"d-flex\">\n");
      out.write("                        <a class=\"btn btn-lg btn-primary btn-lg-square rounded me-2\" href=\"#\"><i class=\"fab fa-twitter fw-normal\"></i></a>\n");
      out.write("                        <a class=\"btn btn-lg btn-primary btn-lg-square rounded me-2\" href=\"#\"><i class=\"fab fa-facebook-f fw-normal\"></i></a>\n");
      out.write("                        <a class=\"btn btn-lg btn-primary btn-lg-square rounded me-2\" href=\"#\"><i class=\"fab fa-linkedin-in fw-normal\"></i></a>\n");
      out.write("                        <a class=\"btn btn-lg btn-primary btn-lg-square rounded\" href=\"#\"><i class=\"fab fa-instagram fw-normal\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container-fluid text-light py-4\" style=\"background: #051225;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row g-0\">\n");
      out.write("                <div class=\"col-md-6 text-center text-md-start\">\n");
      out.write("                    <p class=\"mb-md-0\">&copy; <a class=\"text-white border-bottom\" href=\"#\">Anjali Mtittal</a>. All Rights Reserved.</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 text-center text-md-end\">\n");
      out.write("                    <p class=\"mb-0\">Designed by <a class=\"text-white border-bottom\" href=\"https://htmlcodex.com\">HTML Codex</a></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Footer End -->\n");
      out.write(" <!-- Back to Top -->\n");
      out.write("    <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square rounded back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- JavaScript Libraries -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"lib/wow/wow.min.js\"></script>\n");
      out.write("    <script src=\"lib/easing/easing.min.js\"></script>\n");
      out.write("    <script src=\"lib/waypoints/waypoints.min.js\"></script>\n");
      out.write("    <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment.min.js\"></script>\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment-timezone.min.js\"></script>\n");
      out.write("    <script src=\"lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js\"></script>\n");
      out.write("    <script src=\"lib/twentytwenty/jquery.event.move.js\"></script>\n");
      out.write("    <script src=\"lib/twentytwenty/jquery.twentytwenty.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Template Javascript -->\n");
      out.write("    <script src=\"js/main.js\"></script>        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
