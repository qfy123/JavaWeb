<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Random
  Date: 2021/5/6
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%--
    jsp的page指令可以修改jsp页面中的一些重要属性或者行为
        language属性：表示jsp翻译后是什么语言文件，暂时只支持java
        contentType属性：表示jsp返回的数据类型
        pageEncoding属性：表示当前jsp页面文件本身的字符集
        import属性：用于导包，导类
        ==========================以下两个属性是给out输出流使用==========================
        autoFlush属性：当out输出流缓冲区满了之后，是否自动刷新缓冲区，默认为true
        buffer属性：设置out缓冲区大小，默认8kb

        errorPage属性：设置jsp页面运行出错时，自动跳转的页面路径
        isErrorPage属性：设置当前jsp页面是否为错误信息页面，默认为false
        session属性：设置访问当前jsp页面，是否会创建HttpSession对象，默认时true
        extends属性：设置jsp翻译出来的java类默认继承谁
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是html数据


</body>
</html>
