<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String base=request.getScheme()
    +"://"
    +request.getServerName()
    +":"
    +request.getServerPort()
    +request.getContextPath()
    +"/";
    pageContext.setAttribute("base",base);
%>

<base href="<%=base%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/jquery-1.7.2.js"></script>