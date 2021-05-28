package com.example.web; /**
 * @author QFY
 * @Description
 * @create 2021-04-30 13:48
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //像map一样存数据
        ServletContext context = getServletContext();
        context.setAttribute("key1","value1");
        System.out.println("context1中获取域数据key1的值是"+context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
