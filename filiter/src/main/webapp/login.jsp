<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/27
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是登录页面<br/>
    <form action="http://localhost:8080/filiter/loginServlet" method="get">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit"/>
    </form>
</body>
</html>
