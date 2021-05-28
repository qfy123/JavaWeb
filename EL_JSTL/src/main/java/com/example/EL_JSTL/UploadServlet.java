package com.example.EL_JSTL; /**
 * @author QFY
 * @Description
 * @create 2021-05-18 11:00
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、先判断上传的数据是否是多端的，只有多段数据才是文件上传的
        if (ServletFileUpload.isMultipartContent(request)){
            //2、创建FileItemFactory实现类
            FileItemFactory factory=new DiskFileItemFactory();
            //3、创建用于解析上传数据的实现类ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            //4、解析上传的数据，得到每一个表单项
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项是普通类型还是上传的文件
                for (FileItem fileItem:list){
                    if (fileItem.isFormField()){//如果为true，就是普通表单项，false就是上传的文件
                        System.out.println("表单项的name属性："+fileItem.getFieldName());
                        System.out.println("表单项的value属性："+fileItem.getString("UTF-8"));
                    }
                    else {
                        System.out.println("表单项的name属性："+fileItem.getFieldName());
                        System.out.println("上传的文件名"+fileItem.getName());
                        fileItem.write(new File("d:\\"+fileItem.getName()));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
