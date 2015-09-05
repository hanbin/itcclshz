<%-- 
    Document   : changepwd
    Created on : 2012-8-22, 11:29:15
    Author     : Icer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改密码</title>
        <link rel="stylesheet" type="type/css" href="css/style.css" />
        <script>
            function isrepeat(thisform){
                var pwd = thisform.pwd.value;
                var repwd = thisform.repwd.value;
                if(pwd != repwd||pwd==""||pwd==null){
                    alert("两次输入新密码不一致，请重新检查.");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="container">
            <h1>修改密码</h1>
            <form action="./Pwd" method="post" onsubmit="return isrepeat(this);">
                <table border="0">
                    <tr>
                        <td>现有密码：</td>
                        <td>
                            <input type="password" name="currpwd">
                        </td>
                    </tr>
                    <tr>
                        <td>修改密码：</td>
                        <td>
                            <input type="password" name="pwd">
                        </td>
                    </tr>
                    <tr>
                        <td>重复密码：</td>
                        <td>
                            <input type="password" name="repwd">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="确认修改">  
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
