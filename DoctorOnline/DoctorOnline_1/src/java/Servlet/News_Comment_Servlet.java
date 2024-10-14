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
import org.apache.catalina.Session;

/**
 *
 * @author pc
 */
@WebServlet(name = "News_Comment_Servlet", urlPatterns = {"/News_Comment_Servlet"})
public class News_Comment_Servlet extends HttpServlet {
static String newscommentid;
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
            String commnewsid=request.getParameter("commnewsid");
            String newscommidtxt=request.getParameter("newscommidtxt");
            String News_ID=request.getParameter("newsid");
            String NEWSID=request.getParameter("NEWSID");
            //String Doctor_ID=request.getParameter("drid");
            String Comments_Description=request.getParameter("commdesctxt");
            String Date_of_Comment=request.getParameter("dateofcommtxt");
            String Status=request.getParameter("statustxt");
            String Button=request.getParameter("sbtn");
            HttpSession session=request.getSession();
            String Doctor_ID=session.getAttribute("doctorid").toString();
            DoctorModel Model=new DoctorModel();
            try
                {
                    if(Button.equals("Save"))
                {
                   if(Model.InsertNewsComment(NEWSID,session.getAttribute("doctorid").toString(),Comments_Description)==true)
                {
                ArrayList aobj=new ArrayList();
                aobj=Model.CommInf(NEWSID,session.getAttribute("doctorid").toString(),Comments_Description);
                request.setAttribute("list",aobj);
                RequestDispatcher rd=request.getRequestDispatcher("NewsAllComments.jsp");
                rd.include(request, response);
                }
                }
            else
                    if(Button.equals("Edit"))
                {
                    ArrayList aobj=new ArrayList();
                    aobj=Model.SearchNewscomment(newscommidtxt);
                    newscommentid=aobj.get(0).toString();
                    request.setAttribute("list",aobj);
                    RequestDispatcher rd=request.getRequestDispatcher("Update_News_Comment.jsp");
                    rd.include(request, response);
                }
            else
                    if(Button.equals("Update"))
                    {
                    if(Model.UpdateNewsComment(newscommentid, News_ID, Doctor_ID,Comments_Description, Date_of_Comment, Status)==true)
                {
                    RequestDispatcher rd=request.getRequestDispatcher("Doctor_Pending_Appointments.jsp");
                    rd.forward(request, response);
                }
                    }
                    else
                        if(Button.equals("addcomm"))
                        {
                            ArrayList aobj=new ArrayList();
                        aobj=Model.SearchNews(commnewsid);
                        request.setAttribute("list",aobj);
                        aobj.get(0);
                        RequestDispatcher rd=request.getRequestDispatcher("Doctor_News_Comments.jsp");
                        rd.include(request, response);
                        
                        }
            }
            catch(Exception ex)
            {
            System.out.println("error in news comment servlet"+ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet News_Comment_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet News_Comment_Servlet at " + request.getContextPath() + "</h1>");
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
