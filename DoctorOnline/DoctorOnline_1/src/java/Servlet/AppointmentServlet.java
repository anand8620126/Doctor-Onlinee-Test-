/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModelPack.DoctorModel;
import static Servlet.DoctorServlet.Appid;
import javax.servlet.http.HttpSession;
/**
 *
 * @author pc
 */
@WebServlet(name = "DoctorOnlineServlet", urlPatterns = {"/DoctorOnlineServlet"})
public class AppointmentServlet extends HttpServlet {
static String appointmentid;
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
           HttpSession session = request.getSession();
            String Appointment_ID=request.getParameter("appid");
            String User_ID= request.getParameter("userid");
            String Doctor_ID=request.getParameter("drid");
            String Patient_Name=request.getParameter("patienttxt");
            String Age=request.getParameter("agetxt");
            String Gender=request.getParameter("gender");
            String Major_Symptoms=request.getParameter("msymtxt");
            String Previous_Treatment=request.getParameter("prevtrmtxt");
            String Problem_Description=request.getParameter("pdtxt");
            String Appointment_Date=request.getParameter("adtxt");
            String Appointment_time=request.getParameter("attxt");
            String Appointment_Type=request.getParameter("atypetxt");
            String Next_Appointment=request.getParameter("natxt");
            String Radio_AccDec=request.getParameter("acdecradio");
            String Button=request.getParameter("sbtn");
            DoctorModel Model=new DoctorModel();
            try
            {
            if(Button.equals("Save"))
            {
            if(Model.InsertAppointment(User_ID,Doctor_ID,Patient_Name,Age,Gender,Major_Symptoms,Previous_Treatment,Problem_Description,Appointment_Date,Appointment_time,Appointment_Type)==true)
            {
                RequestDispatcher rd=request.getRequestDispatcher("Make_Appointment.jsp");
                rd.forward(request, response);
            }
            }
            else if(Button.equals("Update"))
            {
                if(Model.UpdateAppointment(Appid,User_ID,Patient_Name,Age,Gender,Major_Symptoms,Previous_Treatment,Problem_Description,Appointment_Date,Radio_AccDec,Appointment_time,Appointment_Type,Next_Appointment)==true)
                {
                RequestDispatcher rd=request.getRequestDispatcher("Doctor_Pending_Appointments.jsp");
                rd.forward(request, response);
                }
            }
            else
                if(Button.equals("Search"))
                {
                ArrayList aobj=new ArrayList();
                aobj=Model.SearchAppointment("Patient_Name");
                appointmentid=aobj.get(0).toString();
                request.setAttribute("list",aobj);
                RequestDispatcher rd=request.getRequestDispatcher("Appointmenteditbydoctor.jsp");
                rd.include(request, response);
                }
            else
                            if(Button.equals("Edit"))
                            {
                            ArrayList aobj=new ArrayList();
                            aobj=Model.editAppointment(Appointment_ID);
                            request.setAttribute("list",aobj);
                            Appid=aobj.get(0).toString();
                            RequestDispatcher rd=request.getRequestDispatcher("Appointmenteditbydoctor.jsp");
                            rd.include(request, response);
                            }
            }
            catch(Exception ex)
            {
            System.out.println("error in appointment servlet"+ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoctorOnlineServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet DoctorOnlineServlet at " + request.getContextPath() + "</h1>");
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
