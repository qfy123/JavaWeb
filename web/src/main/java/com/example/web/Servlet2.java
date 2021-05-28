package com.example.web; /**
 * @author QFY
 * @Description
 * @create 2021-04-30 16:34
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        //查看前一个servlet程序是否带来了转发参数
        Object key = request.getAttribute("key");

        System.out.println("处理s2的业务");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
