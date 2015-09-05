/*
 * 显示账户状态（包括：用户名，支出总计，收入总计，总余额）
 */
package com.itcc.servlet;

import com.itcc.bean.StatusBean;
import com.itcc.dao.DetailDao;
import java.io.IOException;
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
public class Status extends HttpServlet {

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
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        ArrayList list = new ArrayList();
        list = detailDao.getStatus(username);
        for(int i=0;i<list.size();i++){
            StatusBean statusBean = new StatusBean();
            statusBean = (StatusBean)list.get(i);
            request.setAttribute("username", statusBean.getUsername());
            request.setAttribute("inmoney", statusBean.getInmoney());
            request.setAttribute("outmoney", statusBean.getOutmoney());
            request.setAttribute("money", statusBean.getMoney());
            request.getRequestDispatcher("status.jsp").forward(request, response);
        }
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
