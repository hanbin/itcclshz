<%-- 
    Document   : welcome
    Created on : 2012-8-22, 11:25:18
    Author     : Icer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="container">
            <%
                String tag = request.getParameter("tag");
                if (tag.equals("ok")) {
            %>
            <h3>谢谢您的注册，密码将会在稍后以邮件的方式发送到您预留的邮箱，请注意查收</h3>
            你可以<a href="login.html">返回登录</a><br>
            或者点击<a href="http://itcaicai.com" target="_blank">IT菜菜</a>浏览我们的网站
            <%                } else if (tag.equals("error")) {
            %>
            <h3>帐号或密码已经存在了，请重新输入一个哦……^-^</h3><br>
            <h3><a href='reg.html'>返回重新注册</a></h3>
            或者点击<a href="http://itcaicai.com" target="_blank">IT菜菜</a>浏览我们的网站
            <%                    } else if (tag.equals("ok_pwd")) {
            %>        
            <h3>密码修改成功</h3>
            你可以<a href="login.html">返回登录</a><br>
            <%                } else if (tag.equals("error_pwd")) {
            %> 
            <h3>修改密码失败，可能是您现在密码输错了哦……^-^</h3><br>
            <h3>您可能需要<a href='beg.html'>找回密码</a></h3>
            <h3>或者返回尝试登录<a href='login.html'>登录</a></h3>
            <%                    }
            %>
        </div>
    </body>
</html>
