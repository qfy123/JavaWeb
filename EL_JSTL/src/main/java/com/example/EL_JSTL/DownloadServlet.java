package com.example.EL_JSTL; /**
 * @author QFY
 * @Description
 * @create 2021-05-18 15:15
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取要下载的文件名
        String downloadFilename="2.jpg";
//        2、读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFilename);
        System.out.println("下载的文件类型："+mimeType);
        response.setContentType(mimeType);
        /*
        告诉客户端收到的数据是用于下载的
        Content-Disposition响应头表示收到的数据怎么处理
        attachment意为附件，表示下载用
        filename= 指定下载的文件名
         */
        response.setHeader("Content-Disposition","attachment;filename=2.jpg");
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFilename);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream,outputStream);
//        3、把下载的文件内容回传给客户端
//        4、在回传前，通过响应头告诉客户端返回的数据类型
//        5、告诉客户端收到的数据是用于下载使用（使用响应头）
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
