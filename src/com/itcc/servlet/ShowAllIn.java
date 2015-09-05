/*
 * 显示所有的收入明细
 */
package com.itcc.servlet;

import com.itcc.dao.DetailDao;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Icer
 */
public class ShowAllIn extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DetailDao detailDao = new DetailDao();
        ArrayList list = new ArrayList();
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString().trim();
        String showPage = request.getParameter("showPage");
        int pageNum = detailDao.getPageNum("0");
        int n = 0;//需要显示的页码
        if (Integer.parseInt(showPage) == 0) {
            n = 1;
        } else if (Integer.parseInt(showPage) > pageNum) {
            n = pageNum;
        } else {
            n = Integer.parseInt(showPage);
        }
        list = detailDao.getData_in(n,username);
        System.out.println("showpage:" + showPage);
        System.out.println("pageNum:" + pageNum);
        request.setAttribute("showPage", new Integer(n));
        request.setAttribute("pageNum", new Integer(pageNum));

//        String sql = "select *from detail_tb where inorout='0'";
//        list = detailDao.search(sql);
        System.out.println("list" + list);
        request.setAttribute("list", list);
        request.getRequestDispatcher("webpages/in/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
