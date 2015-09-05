<%-- 
    Document   : left
    Created on : 2012-8-20, 14:39:44
    Author     : Icer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
    </head>
    <body>
        <div>
            <ul><span id="title">管理菜单</span></ul>
            <ul align="left">收支管理</ul>
            <div align="center">
                <ul><a href="../ShowAllIn?showPage=0"target="mainFrame">收入管理</a></ul>
                <ul><a href="../ShowAllOut?showPage=0" target="mainFrame">支出管理</a></ul>
            </div>
            <ul align="left">分类管理</ul>
            <div align="center">
                <ul><a href="../ItemIn" target="mainFrame">收入分类</a></ul>
                <ul><a href="../ItemOut" target="mainFrame">支出分类</a></ul>
            </div>
            <ul><a href="../Status" target="mainFrame">账户状态</a></ul>
            <ul><a href="../changepwd.jsp" target="mainFrame">修改密码</a></ul>
            <ul><a href="../Quit">退出系统</a></ul>
        </div>
            
    </body>
</html>
