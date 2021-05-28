package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author QFY
 * @Description
 * @create 2021-05-20 16:46
 */
public class ClientBookServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数pageNo和pageSize
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用bookService.page
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3、保存page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数pageNo和pageSize
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min=WebUtils.parseInt(req.getParameter("min"),0);
        int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2、调用bookService.page
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null)
            sb.append("&min=").append(req.getParameter("min"));
        if (req.getParameter("max")!=null)
            sb.append("&max=").append(req.getParameter("max"));
        page.setUrl(sb.toString());
        //3、保存page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}
