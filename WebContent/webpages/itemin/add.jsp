<%-- 
    Document   : add
    Created on : 2012-8-23, 11:16:13
    Author     : Icer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../../css/style.css">
    </head>
    <body>
        <div id="container">
            <h1>收入类别添加</h1>
            <form action="../../AddItemIn" method="post">
                <table>
                    <tr>
                        <td>类别</td>
                        <td>
                            <input type="text" name="item">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="确认添加" >
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
