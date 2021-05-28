<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/12
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--set标签：可以往域里保存数据
        scope属性：设置操作哪个域，默认域是pageContext
        var属性：设置key是多少
        value属性：设置value是多少--%>
    <c:set scope="request" var="key1" value="key1value"/>
    ${requestScope.key1}<br/>
    <hr/>
    <%--if标签：做if判断
        test属性：表示判断的条件（使用el表达式输出）--%>
    <c:if test="${12==12}">
        <h1>12等于12</h1>
    </c:if>

    <%--
        choose when otherwise标签：多路判断。跟switch...case...default非常接近
        choose标签开始选择判断
        when标签表示每一种判断情况，test属性表示当前这种判断情况的值
        otherwise标签表示剩下的情况
        如果想在otherwise里面再用when进行多路判断，一定要在里面再套一层choose
    --%>
    <%
        request.setAttribute("height",198);
    %>
    <c:choose>
        <c:when test="${requestScope.height>190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <h2>挺高</h2>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <h2>一般</h2>
        </c:when>
    </c:choose>
    <hr/>
    <%--
        forEach标签:循环
        begin属性：开始索引
        end属性：结束索引
        var属性：表示循环的变量
    --%>
    <c:forEach begin="1" end="10" var="i">
        ${i}
    </c:forEach>
    <hr/>
    <%
        request.setAttribute("arr",new String[]{"123123123","4645486","75476464356","/795+985+2"});
    %>
    <c:forEach items="${requestScope.arr}" var="i"><%--items属性：表示遍历的数据源（要遍历的集合）--%>
        ${i}
    </c:forEach>

</body>
</html>
