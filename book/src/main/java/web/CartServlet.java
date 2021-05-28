package web; /**
 * @author QFY
 * @Description
 * @create 2021-05-26 11:25
 */

import com.google.gson.Gson;
import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数 图书id
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        //把图书信息转换成cartitem商品项
        CartItem cartItem=new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.additem方法添加进购物车
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
        //重定向回原来商品所在的地址页面
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取商品编号
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    protected void clean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart!=null)
            cart.clean();
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        int count=WebUtils.parseInt(request.getParameter("count"),1);
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if (cart!=null)
            cart.updateCount(id,count);
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数 图书id
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        //把图书信息转换成cartitem商品项
        CartItem cartItem=new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.additem方法添加进购物车
        Cart cart= (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);


    }
}
