package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author QFY
 * @Description
 * @create 2021-04-30 15:39
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getRequestURI:获取请求的资源路径
        System.out.println("URI==>"+req.getRequestURI());
        //getRequestURL:获取请求的统一资源定位符（绝对路径）
        System.out.println("URL==>"+req.getRequestURL());
        //getRemoteHost:获取客户端ip地址
        System.out.println("客户端ip地址==>"+req.getRemoteHost());
        //getHeader:获取请求头
        System.out.println("请求头User-Agent==>"+req.getHeader("User-Agent"));
        //getMethod:获取请求的方式
        System.out.println("请求方式==>"+req.getMethod());
    }
}
