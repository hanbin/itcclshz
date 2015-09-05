<%-- 
    Document   : top
    Created on : 2012-8-20, 14:40:12
    Author     : Icer
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎使用IT菜菜项目--收支管理平台</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    
    <div align="center">
        <h2>IT菜菜--收支管理平台</h2>
    </div>
    <div align="right">
        今天是：<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>
        当前用户：<%= session.getAttribute("username")%>
    </div>
</html>
