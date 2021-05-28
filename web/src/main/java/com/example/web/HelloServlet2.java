package com.example.web;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author QFY
 * @Description
 * @create 2021-04-29 16:00
 */
public class HelloServlet2 implements Servlet {

    public HelloServlet2() {
        System.out.println("1、构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        /*
//        ServletConfig类的三大作用：
//        1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("Servlet程序的别名是"+servletConfig.getServletName());
//        2、获取初始化参数init-param
        System.out.println("init-param初始化参数username的值是："+servletConfig.getInitParameter("username"));
//        3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
//         */

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * Service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet被访问了");
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();
        if ("GET".equalsIgnoreCase(method)){
            doGet();
        }
        else if ("POST".equalsIgnoreCase(method)){
            doPost();
        }
    }

    public void doGet(){
        System.out.println("get请求");
    }
    public void doPost(){
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4、销毁方法");
    }
}
