<%-- 
    Document   : index
    Created on : 2012-8-23, 10:40:37
    Author     : Icer
--%>

<%@page import="com.itcc.bean.ItemInBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <span id="title1">收入类别管理</span> <span id="title2"><a href="webpages/itemin/add.jsp">添加类别</a></span>
            <table border="1">
                <tr>
                    <th>类别</th>
                    <th>操作</th>
                </tr>

                <%
                    ItemInBean iteminbean = new ItemInBean();
                    ArrayList list = new ArrayList();
                    list = (ArrayList) request.getAttribute("list");
                    for (int i = 0; i < list.size(); i++) {
                        iteminbean = (ItemInBean) list.get(i);
                %>
                <tr>
                    <td>
                        <%= iteminbean.getItem()%>
                    </td>
                    <td>
                        <a href="./DelItemIn?id=<%=iteminbean.getId()%>">删除</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
