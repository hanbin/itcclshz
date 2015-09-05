/*
 * 收入添加处理
 */
package com.itcc.servlet;

import com.itcc.dao.DetailDao;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icer
 */
public class AddIn extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        Date date = Date.valueOf(request.getParameter("date"));
        double money = Double.parseDouble(request.getParameter("money"));
        String inout = request.getParameter("inout");
        String detail = request.getParameter("detail");
        DetailDao detailDao = new DetailDao();
        String sql = "insert into detail_tb(item,money,indate,inorout,username,detail) values('"+item+"',"+money+",'"+date+"','"+inout+"','"+username+"','"+detail+"')";
        System.out.println("sql:" + sql);
        boolean flag = detailDao.update(sql);
        if(flag){
            response.sendRedirect("./ShowAllIn?showPage=0");
        }else{
            response.sendRedirect("./ShowAllIn?showPage=0");
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
