/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
import ModelPack.DoctorModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
static String userid;
static String name;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Name=request.getParameter("nametxt");
            String Password=request.getParameter("pwdtxt");
            String New_Password=request.getParameter("npwdtxt");
            
            String Address=request.getParameter("addresstxt");
            String City=request.getParameter("citytxt");
            String State=request.getParameter("statetxt");
            String Phone=request.getParameter("phonetxt");
            String Email=request.getParameter("emailtxt");
            String RegistrationDate=request.getParameter("regdtxt");
            String Button=request.getParameter("sbtn");
            DoctorModel Model=new DoctorModel();
            HttpSession session=request.getSession();
            try
            {
            if(Button.equals("Registered"))
            {
                if(Model.InsertUser(Name,Password, Address, City,State, Phone, Email)==true)
                {
                  
                    RequestDispatcher rd=request.getRequestDispatcher("User_Login.jsp");
                    rd.forward(request, response);
                }
                else
                {
                    RequestDispatcher rd=request.getRequestDispatcher("Failure.jsp?type=user");
                    rd.forward(request, response);   
                }
            }
            else
                    if(Button.equals("Search"))
                    {
                       ArrayList aobj=new ArrayList();
                       aobj=Model.SearchUser(Password);
                       userid= aobj.get(0).toString();
                       request.setAttribute("list",aobj);
                      RequestDispatcher rd=request.getRequestDispatcher("Updateuser.jsp");
                      rd.include(request, response); 
                    }
            else
                    if(Button.equals("Update"))
                    {
                        if(Model.UpdateUser(userid,Name,Password, Address, City,State, Phone, Email,RegistrationDate)==true)
                    {
                    RequestDispatcher rd=request.getRequestDispatcher("User_My_Profile.jsp");
                    rd.forward(request, response);
                    }
                    }
            else
                    if(Button.equals("Login"))
                    {
                    if(Model.CheckUser(Email,Password)==true)
                    {
                    ArrayList aobj=new ArrayList();
                    aobj=Model.GetUserDetails(Email, Password);
                    userid=aobj.get(0).toString();
                    name=aobj.get(1).toString();
                    session.setAttribute("userid",userid);
                    session.setAttribute("name",name);
                    RequestDispatcher rd=request.getRequestDispatcher("User_Pending_Appointments.jsp");
                    rd.forward(request, response);
                    }
                    else
                {
                    RequestDispatcher rd=request.getRequestDispatcher("Failure.jsp?type=userlogin");
                    rd.forward(request, response);   
                }
                    }
            else
                    if(Button.equals("LogOut"))
                    {      
                   session.invalidate();
                    RequestDispatcher rd=request.getRequestDispatcher("User_Login.jsp");
                    rd.forward(request, response);
                    }
            else
                if(Button.equals("Change Password"))
                {
                if(Model.ChangePassworduser(Email,New_Password,Password)==true)
                {
                RequestDispatcher rd=request.getRequestDispatcher("User_Login.jsp");
                rd.forward(request, response);
                }               
                }
                }
            catch(Exception ex)
            {
            System.out.println("error in user servlet"+ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
        //    out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
