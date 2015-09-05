<%-- 
    Document   : status
    Created on : 2012-8-23, 15:35:28
    Author     : Icer
--%>

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
            <%
                String username = request.getAttribute("username").toString();
                String inmoney = request.getAttribute("inmoney").toString();
                String outmoney = request.getAttribute("outmoney").toString();
                String money = request.getAttribute("money").toString();
            %>
            <h1>账户状态</h1>
            <table>
                <tr>
                    <td colspan="2">
                        <%=username%>，您的账户信息如下：
                    </td>

                </tr>
                <tr>
                    <td>收入总计</td>
                    <td>
                        <%=inmoney%>
                    </td>
                </tr>
                <tr>
                    <td>支出总计</td>
                    <td>
                        <%=outmoney%>
                    </td>
                </tr>
                <tr>
                    <td>账户总计</td>
                    <td>
                        <%=money%>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="./ShowAllIn?showPage=0">查看收入明细</a>
                    </td>
                    <td>
                        <a href="./ShowAllOut?showPage=0">查看支出明细</a>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
