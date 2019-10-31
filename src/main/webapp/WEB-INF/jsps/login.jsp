<%--
  Created by IntelliJ IDEA.
  User: Changliang Tao
  Date: 2019/10/30
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<form action="/login">
    用户名：<input type="text" name="userName">
    密码：<input type="password" name="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
