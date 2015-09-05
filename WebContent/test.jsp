<%-- 
    Document   : test
    Created on : 2012-8-22, 8:53:08
    Author     : Icer
--%>

<%@page import="com.itcc.bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itcc.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>测试数据库链接</title>
    </head>
    <body>
        <table>
            <tr>
                <td>username</td>
                <td>password</td>
                <td>email</td>
            </tr>
            <%
                UserDao userDao = new UserDao();
                ArrayList list = userDao.getAllUsers();
                for (int i = 0; i < list.size(); i++) {
                    User user = new User();
                    user = (User) list.get(i);
            %>
            <tr>
                <td><%=user.getUsername()%></td>
                <td><%=user.getPassword()%></td>
                <td><%=user.getEmail()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
