package com.example.web;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * 什么是Servlet
 * 1、Servlet是JavaEE规范之一，规范就是接口
 * 2、Servlet是JavaWeb三大组件之一。三大组件分别是Servlet程序，Filter过滤器，Listener监听器
 * 3、Servlet是运行在服务器上的一个Java小程序，它可以接受客户端发送过来的请求，并响应数据给客户端
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}