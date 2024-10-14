/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ModelPack.DoctorModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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
@WebServlet(name = "DoctorServlet", urlPatterns = {"/DoctorServlet"})
public class DoctorServlet extends HttpServlet {
static String doctorid;
static String drname;
static String Appid;
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
            String Doctor_Name=request.getParameter("drnametxt");
            String Password=request.getParameter("pwdtxt");
            String New_Password=request.getParameter("npwdtxt");
            String Address=request.getParameter("addtxt");
            String City=request.getParameter("citytxt");
            String Phone=request.getParameter("phtxt");
            String Qualification=request.getParameter("qlftxt");
            String Experience=request.getParameter("exptxt");
            String Specialization=request.getParameter("spctxt");
            String Hospital_ID=request.getParameter("hospitalid");
            String Previous_Hospital_Name=request.getParameter("prevhosntxt");
            String Button=request.getParameter("sbtn");
            DoctorModel Model=new DoctorModel();
            HttpSession session=request.getSession();
               try
               {
               if(Button.equals("Registered"))
               {
                   if(Model.InsertDoctor(Doctor_Name,Password, Address, City, Phone,Qualification,Experience,Specialization, Hospital_ID,Previous_Hospital_Name)==true)
                   {
                       
                       RequestDispatcher rd=request.getRequestDispatcher("Doctor_Login.jsp");
                       rd.forward(request, response);
                   }
                   else
                   {
                      RequestDispatcher rd=request.getRequestDispatcher("Failure.jsp?type=doctor");
                       rd.forward(request, response); 
                   }
               }
               else
                       if(Button.equals("Search"))
                       {
                          
                       ArrayList aobj=new ArrayList();
                       aobj=Model.SearchDoctor(Specialization);
                       request.setAttribute("list",aobj);
                       RequestDispatcher rd=request.getRequestDispatcher("Doctor_Update.jsp");
                       rd.include(request, response);
                       }
               else
                        if(Button.equals("Update"))
                        {
                        if(Model.UpdateDoctor(doctorid,Doctor_Name,Password, Address, City, Phone,Qualification,Experience,Specialization, Hospital_ID,Previous_Hospital_Name)==true)
                        {
                        RequestDispatcher rd=request.getRequestDispatcher("Doctor_My_Profile.jsp");
                        rd.forward(request, response);
                        }
                        }
               else
                        if(Button.equals("Login"))
                        {
                        if(Model.CheckDoctor(Phone,Password)==true)
                        {
                            ArrayList aobj=new ArrayList();
                            aobj=Model.getdrname(Phone,Password);
                           doctorid= aobj.get(0).toString();
                            drname=aobj.get(1).toString();
                        session.setAttribute("drname",drname);
                        session.setAttribute("doctorid", doctorid);
                        RequestDispatcher rd=request.getRequestDispatcher("Doctor_Pending_Appointments.jsp");
                        rd.forward(request, response);
                        }
                        else
                {
                    RequestDispatcher rd=request.getRequestDispatcher("Failure.jsp?type=doctorlogin");
                    rd.forward(request, response);   
                }
                        }
                        else
                            if(Button.equals("LogOut"))
                            {
                        session.invalidate();
                        RequestDispatcher rd=request.getRequestDispatcher("Doctor_Login.jsp");
                        rd.forward(request, response);
                            }
                        else  
                        if(Button.equals("Change Password"))
                        {
                        if(Model.ChangePassworddoctor(Phone,New_Password,Password)==true)
                        {
                        RequestDispatcher rd=request.getRequestDispatcher("Doctor_Login.jsp");
                        rd.forward(request, response);
                        }
                        }
               }
               catch(Exception ex)
               {
               System.out.println("error in doctorservlet"+ex);
               }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoctorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
          //  out.println("<h1>Servlet DoctorServlet at " + request.getContextPath() + "</h1>");
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
