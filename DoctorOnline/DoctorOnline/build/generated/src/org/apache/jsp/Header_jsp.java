package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Doctor Online - Dental Clinic </title>\n");
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
      out.write("        <!-- Spinner Start -->\n");
      out.write("    <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\" style=\"padding-bottom:10px;\">\n");
      out.write("        <div class=\"spinner-grow text-primary m-1\" role=\"status\">\n");
      out.write("            <span class=\"sr-only\">Loading...</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"spinner-grow text-dark m-1\" role=\"status\">\n");
      out.write("            <span class=\"sr-only\">Loading...</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"spinner-grow text-secondary m-1\" role=\"status\">\n");
      out.write("            <span class=\"sr-only\">Loading...</span>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Spinner End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Topbar Start -->\n");
      out.write("    <div class=\"container-fluid bg-light ps-5 pe-0 d-none d-lg-block\">\n");
      out.write("        <div class=\"row gx-0\">\n");
      out.write("            <div class=\"col-md-6 text-center text-lg-start mb-2 mb-lg-0\">\n");
      out.write("                <div class=\"d-inline-flex align-items-center\">\n");
      out.write("                    <small class=\"py-2\"><i class=\"far fa-clock text-primary me-2\"></i>Opening Hours: Mon - Tues : 6.00 am - 10.00 pm, Sunday Closed </small>\n");
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
      out.write("        <a href=\"index.jsp\" class=\"navbar-brand p-0\">\n");
      out.write("            <h1 class=\"m-0 text-primary\"></i>DoctorOnline</h1>\n");
      out.write("        </a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n");
      out.write("            <div class=\"navbar-nav ms-auto py-0\">\n");
      out.write("                <a href=\"index.jsp\" class=\"nav-item nav-link active\">Home</a>\n");
      out.write("                <a href=\"About.jsp\" class=\"nav-item nav-link\">About Project</a>\n");
      out.write("                <div class=\"nav-item dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">User</a>\n");
      out.write("                    <div class=\"dropdown-menu m-0\">\n");
      out.write("                        <a href=\"User_Login.jsp\" class=\"dropdown-item\">User Login</a>\n");
      out.write("                        <a href=\"User_Registration.jsp\" class=\"dropdown-item\">User Registration</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"nav-item dropdown\">\n");
      out.write("                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">Doctor</a>\n");
      out.write("                    <div class=\"dropdown-menu m-0\">\n");
      out.write("                        <a href=\"Doctor_Login.jsp\" class=\"dropdown-item\">Doctor Login</a>\n");
      out.write("                        <a href=\"Doctor_Registration.jsp\" class=\"dropdown-item\">Doctor Registration</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"Contact.jsp\" class=\"nav-item nav-link\">Contact</a>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"button\" class=\"btn text-dark\" data-bs-toggle=\"modal\" data-bs-target=\"#searchModal\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("            <a href=\"User_Registration.jsp\" class=\"btn btn-primary py-2 px-4 ms-3\">Appointment</a>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <!-- Navbar End -->\n");
      out.write(" \n");
      out.write("</body>\n");
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
