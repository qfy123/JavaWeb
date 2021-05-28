<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/10
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
        jsp可以声明和java一样的属性、方法、代码块等,声明脚本的格式为<%!声明内容%>
    --%>
<%!
    private Integer id;
    private String name;
    private static Map<String,Object> map;
%>
<%!
    static {
        map=new HashMap<String,Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }
%>
</body>
</html>
