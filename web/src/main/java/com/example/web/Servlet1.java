package com.example.web;
 /**
 * @author QFY
 * @Description
 * @create 2021-04-30 16:34
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        //设置传递参数
        request.setAttribute("key","柜台1的章");
        //指向下一个servlet程序(请求转发必须要以斜杠/打头，斜杠表示:http://ip:port/工程名/,映射到IDEA代码的web目录)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/s2");
        //前往下一个servlet程序
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
