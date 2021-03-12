<%--
  Created by IntelliJ IDEA.
  User: 周浩宇
  Date: 2020/12/21
  Time: 16:34
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
    <h2>分组</h2>
    <hr width = 50% align = left size =20 color=green>
    <base href ="<%=basePath%>">
    <title>My JSP 'Addp1.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keywords1,keywords2,keyword3">
    <meta http-equiv="description" content="this is my page">

</head>
<body style="background-color:grey">

<hr>
<form action="" method="post">
    <c:forEach var="a" items="${AD }">
        ${a.id }
        ${a.name }
        ${a.sort }
        <!--{a.Wechat }>-->
        <br>
    </c:forEach>
</form></body>
</html>
