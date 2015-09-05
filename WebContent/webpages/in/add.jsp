<%-- 
    Document   : add
    Created on : 2012-8-22, 16:51:45
    Author     : Icer
--%>

<%@page import="com.itcc.bean.ItemInBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itcc.dao.ItemInDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>                                                           
        <script language="javascript" type="text/javascript" src="../../js/WdatePicker.js"></script>
        <script>
            function isNumber(thisform){
                with(thisform){
                    with (money)
                    {
                        if(isNaN(value)){
                            alert(value+"不是数字，请更改");
                            return false;
                        }
                        if(value==""||value==null){
                            alert("金额不能为空");
                            return false;
                        }
                    }
                }
            }  
        </script>
    </head>
    <body>
        <div id="container">
        <h1>添加新的收入信息</h1>
        <form action="../../AddIn" method="post" onsubmit="return isNumber(this);">
            <table >
                <tr>
                    <td>类别</td>
                    <td>
                        <select name="item">
                            <%
                                String item = "";
                                ItemInDao itemInDao = new ItemInDao();
                                String username = session.getAttribute("username").toString().trim();
                                String sql = "select *From item_in_tb where username='"+ username +"'";
                                ArrayList list = new ArrayList();
                                list = itemInDao.search(sql);
                                ItemInBean itemInBean = new ItemInBean();
                                for (int i = 0; i < list.size(); i++) {
                                    itemInBean = (ItemInBean) list.get(i);
                                    item = itemInBean.getItem();
                            %>
                            <option value="<%=item%>"><%=item%></option>
                            <%                                        }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>金额</td>
                    <td>
                        <input id="money" type="number" name="money" required="required">
                    </td>
                </tr>
                <tr>
                    <td>日期</td>
                    <td>
                        <input class="Wdate" type="date" name="date" onclick="WdatePicker()">
                    </td>
                </tr>
                <tr>
                    <td>明细</td>
                    <td>
                        <input type="text" name="detail">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="inout" value="0">
                        <input type="hidden" name="username" value= <%=session.getAttribute("username")%> >
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="确认添加">
                    </td>
                    <td>
                        <input type="reset" value="重填">
                    </td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
