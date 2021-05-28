<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/12
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    EL获取四个特定域的属性<br/>
    pageScope-------pageContext域<br/>
    requestScope----request域<br/>
    sessionScope----session域<br/>
    applicationScope----ServletContext域<br/>
<%
    pageContext.setAttribute("key1","pageContext1");
    pageContext.setAttribute("key2","pageContext2");
    request.setAttribute("key1","request");
    session.setAttribute("key1","session");
    application.setAttribute("key1","application");
%>
${requestScope.key2}
</body>
</html>
