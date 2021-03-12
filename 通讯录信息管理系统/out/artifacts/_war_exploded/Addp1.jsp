<%--
  Created by IntelliJ IDEA.
  User: 周浩宇
  Date: 2020/9/13
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><h1>通讯录信息管理系统</h1>
    <h2>增加联系人</h2>
    <hr width = 50% align = left size =20 color=green>
    <base href ="<%=basePath%>">
    <title>My JSP 'Addp1.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keywords1,keywords2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <script type="text/javascript">
        function del() {
            if (confirm("你真的要删除吗？")) {
                var f = document.forms[1];
                f.action = "<%=path%>/servlet/AddpServlet?action=delete&id=${a.id};"
                f.submit();
            } else {
                return;
            }
        }
    </script>
</head>
<body style="background-color:grey">
<form name="f1" id="f1"
      action="<%=path%>/servlet/AddpServlet?action=save" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>phoneNumber</td>
            <td><input type="text" name="phoneNumber" ></td>
        </tr>
        <tr>
            <td>sex</td>
            <td><input type="text" name="sex" ></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td><input type="text" name="QQ" ></td>
        </tr>
        <tr>
            <td>sort</td>
            <td><input type="text" name="sort" ></td>
        </tr>
       <!-- <tr>
            <td>Wechat</td>
            <td><input type="text" name="Wechat" ></td>
        </tr>-->
        <tr>
            <td colspan="2"><input type="submit" value="save"></td>
        </tr>
    </table>
</form>
<hr>
<form action="" method="post">
    <c:forEach var="a" items="${AD }">
        ${a.id }
        ${a.name }
        ${a.phoneNum }
        ${a.sex }
        ${a.QQ }
        <!--{a.Wechat }>-->
        <a href="<%=path%>/servlet/AddpServlet?action=get&id=${a.id}">Edit</a>
        <input type="checkbox" name="ids" value=${a.id }>
        <br>
    </c:forEach>
    <input type="button" value="delete" onclick="del();">
    <a href="<%=path%>/servlet/AddpServlet?action=get1&id=${a.id}">sort</a>
</form></body>
</html>
