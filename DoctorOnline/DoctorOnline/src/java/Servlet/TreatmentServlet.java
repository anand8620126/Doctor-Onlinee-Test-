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
@WebServlet(name = "TreatmentSerlet", urlPatterns = {"/TreatmentSerlet"})
public class TreatmentServlet extends HttpServlet {
static String Treatment_ID;
static String treatmentid;
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
            String Appointment_ID=request.getParameter("appid");
           // String Doctor_ID=request.getParameter("doctorid");
            String Treatment_Date=request.getParameter("treatdtxt");
            String Treatment_Cost=request.getParameter("treatctxt");
            String Treatment_Time=request.getParameter("treattimetxt");
            String Treatment_Description=request.getParameter("treatdesctxt");
            String Recommended_Test=request.getParameter("recttxt");
            String Recommended_Precautions=request.getParameter("recprectxt");
            String Button=request.getParameter("sbtn");
            HttpSession session=request.getSession();
            String Doctor_ID=session.getAttribute("doctorid").toString();
            DoctorModel Model=new DoctorModel();
            try
            {
            if(Button.equals("Save"))
            {
            if(Model.InsertTeatment(session.getAttribute("appointmentid").toString(),session.getAttribute("doctorid").toString(),Treatment_Date,Treatment_Cost, Treatment_Time, Treatment_Description,Recommended_Test,Recommended_Precautions)==true)
            {
                RequestDispatcher rd=request.getRequestDispatcher("Doctor_My_Appointments.jsp");
                rd.forward(request, response);
            }
            }
            else
                if(Button.equals("Search"))
                {
                ArrayList aobj=new ArrayList();
                aobj=Model.SearchTreatment(Treatment_ID);
                treatmentid=aobj.get(0).toString();
                request.setAttribute("list",aobj);
                RequestDispatcher rd=request.getRequestDispatcher("UpdateTreatment.jsp");
                rd.include(request, response);
                }
                else
                    if(Button.equals("Update"))
                {
                 RequestDispatcher rd=request.getRequestDispatcher("TreatmentView.jsp");
                rd.forward(request, response);
                }
            else
               if(Button.equals("AddTreatment"))
               {
              // ArrayList aobj=new ArrayList();
               //aobj=Model.addtreatment(Appointment_ID);
               //request.setAttribute("list",aobj);
               //aobj.get(0);
                   session.setAttribute("appointmentid",Appointment_ID);
               RequestDispatcher rd=request.getRequestDispatcher("MakeTreatment.jsp");
               rd.forward(request, response);
               }
               }
            catch(Exception ex)
            {
            System.out.println("error in Treatment Servlet"+ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TreatmentSerlet</title>");            
            out.println("</head>");
            out.println("<body>");
         //   out.println("<h1>Servlet TreatmentSerlet at " + request.getContextPath() + "</h1>");
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
