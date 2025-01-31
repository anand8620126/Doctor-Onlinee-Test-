
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

/**
 *
 * @author pc
 */
@WebServlet(name = "NewsServlet", urlPatterns = {"/NewsServlet"})
public class NewsServlet extends HttpServlet {

static String Newsidtxt;
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
            String newsidtxt=request.getParameter("newsidtxt");
            String News_Date=request.getParameter("newsdtxt");
            String News_Title=request.getParameter("newsttxt");
            String News_Description=request.getParameter("newsdesctxt");
            String Status=request.getParameter("statustxt");
            String Button=request.getParameter("sbtn");
            DoctorModel Model=new DoctorModel();
            try
            {
            if(Button.equals("Save"))
            {
            if(Model.InsertNews(News_Date, News_Title, News_Description)==true)
            {
                RequestDispatcher rd=request.getRequestDispatcher("Admin_Manage_News.jsp");
                rd.forward(request, response);
            }
            }
            else if(Button.equals("Edit"))
            {
                ArrayList aobj=new ArrayList();
               aobj= Model.SearchNews(newsidtxt);
               request.setAttribute("list",aobj);
               Newsidtxt=aobj.get(0).toString();
                RequestDispatcher rd=request.getRequestDispatcher("Admin_ManageNewsUpdate.jsp");
                rd.include(request, response);
            }
            else
                if(Button.equals("Update"))
                {
                if(Model.UpdateNews(Newsidtxt,News_Date, News_Title, News_Description, Status)==true)
                {
                RequestDispatcher rd=request.getRequestDispatcher("Admin_Manage_News.jsp");
                rd.forward(request, response);
                }
                }
            }
            catch(Exception ex)
            {
            System.out.println("error in News Servlet"+ex);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
 //           out.println("<h1>Servlet NewsServlet at " + request.getContextPath() + "</h1>");
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
