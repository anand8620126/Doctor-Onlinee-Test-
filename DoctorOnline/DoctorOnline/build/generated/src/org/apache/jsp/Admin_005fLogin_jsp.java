package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_005fLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html> \n");
      out.write("<html> \n");
      out.write("    <head> \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n");
      out.write("        <title>Admin Login</title>\n");
      out.write("                  \n");
      out.write("        <style type=\"text/css\">\n");
      out.write("       body {\n");
      out.write("    background: #222D32;\n");
      out.write("    font-family: 'Roboto', sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-box {\n");
      out.write("    margin-top: 75px;\n");
      out.write("    height: auto;\n");
      out.write("    background: #1A2226;\n");
      out.write("    text-align: center;\n");
      out.write("    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-key {\n");
      out.write("    height: 100px;\n");
      out.write("    font-size: 80px;\n");
      out.write("    line-height: 100px;\n");
      out.write("    background: -webkit-linear-gradient(#27EF9F, #0DB8DE);\n");
      out.write("    -webkit-background-clip: text;\n");
      out.write("    -webkit-text-fill-color: transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-title {\n");
      out.write("    margin-top: 15px;\n");
      out.write("    text-align: center;\n");
      out.write("    font-size: 30px;\n");
      out.write("    letter-spacing: 2px;\n");
      out.write("    margin-top: 15px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    color: #ECF0F5;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-form {\n");
      out.write("    margin-top: 25px;\n");
      out.write("    text-align: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=text] {\n");
      out.write("    background-color: #1A2226;\n");
      out.write("    border: none;\n");
      out.write("    border-bottom: 2px solid #0DB8DE;\n");
      out.write("    border-top: 0px;\n");
      out.write("    border-radius: 0px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    outline: 0;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("    padding-left: 0px;\n");
      out.write("    color: #ECF0F5;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=password] {\n");
      out.write("    background-color: #1A2226;\n");
      out.write("    border: none;\n");
      out.write("    border-bottom: 2px solid #0DB8DE;\n");
      out.write("    border-top: 0px;\n");
      out.write("    border-radius: 0px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    outline: 0;\n");
      out.write("    padding-left: 0px;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("    color: #ECF0F5;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-group {\n");
      out.write("    margin-bottom: 40px;\n");
      out.write("    outline: 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-control:focus {\n");
      out.write("    border-color: inherit;\n");
      out.write("    -webkit-box-shadow: none;\n");
      out.write("    box-shadow: none;\n");
      out.write("    border-bottom: 2px solid #0DB8DE;\n");
      out.write("    outline: 0;\n");
      out.write("    background-color: #1A2226;\n");
      out.write("    color: #ECF0F5;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input:focus {\n");
      out.write("    outline: none;\n");
      out.write("    box-shadow: 0 0 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("label {\n");
      out.write("    margin-bottom: 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-control-label {\n");
      out.write("    font-size: 10px;\n");
      out.write("    color: #6C6C6C;\n");
      out.write("    font-weight: bold;\n");
      out.write("    letter-spacing: 1px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn-outline-primary {\n");
      out.write("    border-color: #0DB8DE;\n");
      out.write("    color: #0DB8DE;\n");
      out.write("    border-radius: 0px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    letter-spacing: 1px;\n");
      out.write("    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);\n");
      out.write("}\n");
      out.write("\n");
      out.write(".btn-outline-primary:hover {\n");
      out.write("    background-color: #0DB8DE;\n");
      out.write("    right: 0px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-btm {\n");
      out.write("    float: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-button {\n");
      out.write("    padding-right: 0px;\n");
      out.write("    text-align: right;\n");
      out.write("    margin-bottom: 25px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".login-text {\n");
      out.write("    text-align: left;\n");
      out.write("    padding-left: 0px;\n");
      out.write("    color: #A2A4A4;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".loginbttm {\n");
      out.write("    padding: 0px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-3 col-md-2\"></div>\n");
      out.write("            <div class=\"col-lg-6 col-md-8 login-box\">\n");
      out.write("                <div class=\"col-lg-12 login-key\"> \n");
      out.write("                    <i class=\"fa fa-key\" aria-hidden=\"true\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-12 login-title\"> \n");
      out.write("                    ADMIN PANEL\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-lg-12 login-form\">\n");
      out.write("                    <div class=\"col-lg-12 login-form\">\n");
      out.write("                        <form name=\"adminloginform\" action=\"AdminServlet\" >\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"form-control-label\">Admin Name</label>\n");
      out.write("                                <input type=\"text\" name=\"adminnametxt\"class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"form-control-label\">PASSWORD</label>\n");
      out.write("                                <input type=\"password\" name=\"pwdtxt\" class=\"form-control\" i>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-12 loginbttm\">\n");
      out.write("                                <div class=\"col-lg-6 login-btm login-text\">\n");
      out.write("                                    <!-- Error Message -->\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 login-btm login-button\">\n");
      out.write("                                    <button type=\"submit\" name=\"sbtn\" value=\"Login\" class=\"btn btn-outline-primary\">LOGIN</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-3 col-md-2\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
