<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/12
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","值");

    %>
    表达式脚本输出key值是:<%=request.getAttribute("key")%><br/>
    EL表达式输出key值是：${key}
</body>
</html>
