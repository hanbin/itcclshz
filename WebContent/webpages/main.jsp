<%-- 
    Document   : main
    Created on : 2012-8-20, 14:40:21
    Author     : Icer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IT菜菜项目----收支明细管理</title>
    </head>
    <frameset rows="98,*,45" frameborder="yes" border="1" framespacing="0">
        <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
        <frameset cols="15%,*" frameborder="yes" border="0" framespacing="0">
            <frame src="left.jsp" name="leftFrame" id="leftFrame"/> 
            <frame src="center.jsp" name="mainFrame" id="mainFrame" />
        </frameset>
        <frame src="bottom.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
    </frameset>
    <noframes><body>
        </body>
    </noframes>
</html>
