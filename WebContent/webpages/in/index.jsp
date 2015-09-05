<%-- 
    Document   : index
    Created on : 2012-8-22, 13:01:27
    Author     : Icer
--%>

<%@page import="com.itcc.bean.Detail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title></title>
    </head>
    <body>
        <div id="container">
        <span id="title1">收入管理首页</span> <span id="title2"><a href="webpages/in/add.jsp">添加收入</a></span>
        <hr>
        <table border="1">
            <tr>
                <th>收入类别</th>
                <th>收入金额</th>
                <th>收入明细</th>
                <th>收入日期</th>
                <th>操作</th>
            </tr>
            <%!                int showPage = 1;
                int pageNum = 0;
            %>
            <%
                Integer spstr = (Integer) request.getAttribute("showPage");//获取当前所显示的页码
                Integer pnstr = (Integer) request.getAttribute("pageNum");//获取总页数
                if (spstr == null || "".equals(spstr)) {
                    showPage = 1;
                } else {
                    showPage = spstr.intValue();
                }
                //处理总页数
                pageNum = pnstr.intValue();
                System.out.println("showpage:" + showPage);
                System.out.println("pageNum:" + pageNum);
                Detail detail = new Detail();
                ArrayList list = new ArrayList();
                list = (ArrayList) request.getAttribute("list");
                System.out.println(list);
                for (int i = 0; i < list.size(); i++) {
                    detail = (Detail) list.get(i);
                    if (detail != null) {
            %>
            <tr>
                <td>
                    <%=detail.getItem()%>
                </td>
                <td>
                    <%=detail.getMoney()%>
                </td>
                <td>
                    <%=detail.getDate()%>
                </td>
                <td>
                    <a href="./DelIn?id=<%=detail.getId()%>">删除</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <div>
            <a href="./ShowAllIn?showPage=<%=1%>">第一页</a>
            <a href="./ShowAllIn?showPage=<%=showPage + 1%>">下一页</a>
            <a href="./ShowAllIn?showPage=<%=showPage - 1%>">上一页</a>
            <a href="./ShowAllIn?showPage=<%=pageNum%>">最后一页</a>
        </div>
        </div>
    </body>
</html>
