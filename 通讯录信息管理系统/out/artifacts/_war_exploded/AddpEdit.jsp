<%--
  Created by IntelliJ IDEA.
  User: ???
  Date: 2020/11/5
  Time: 17:10
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
<head>
    <base href ="<%=basePath%>">
    <title>My JSP 'Addp.jsp' starting page</title>
    <h1>更新信息</h1>

</head>
<body style="background-color:rgba(50,100,175,199)">
<form name="f1" id="f1"
      action="<%=path%>/servlet/AddpServlet?action=update" method="post">
    <input type="hidden" name = "id" value="${Addp.id }">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"
                       value="${Addp.name }"></td>
        </tr>
        <tr>
            <td>phoneNumber</td>
            <td><input type="text "name="phoneNumber"value="${Addp.phoneNum }" ></td>
        </tr>
        <tr>
            <td>sex</td>
            <td><input type="text" name="sex"value="${Addp.sex }" ></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td><input type="text" name="QQ" value="${Addp.QQ }"></td>
        </tr>
        <!-- <tr>
             <td>WeChat</td>
             <td><input type="text" name="Wechat"value="{Addp.Wechat }" ></td>
         </tr>-->
        <tr>
            <td colspan="2"><input type="submit" value="update"></td>
        </tr>
    </table>
</form>

</body>
</html>
