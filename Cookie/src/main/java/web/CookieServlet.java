package web; /**
 * @author QFY
 * @Description
 * @create 2021-05-21 11:02
 */

import utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //1、创建cookie对象
        Cookie cookie=new Cookie("key1","value1");
        //2、通知客户端保存cookie
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie创建成功！");
    }
    protected void getCookie(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Cookie[] cookies = req.getCookies();
        Cookie iWantCookie= CookieUtils.findCookie("key1",cookies);
        for (Cookie cookie : cookies) {
            //getName返回key，getValue返回value
            resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"] <br/>");


        }
        if (iWantCookie!=null)
            resp.getWriter().write("找到了想要的cookie");

    }
    protected void updateCookie(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        /*
        方案一
        修改cookie的值
        1、先创建一个要修改的同名的cookie对象
        2、在构造器，同时赋于新的cookie值
        3、调用resp.addCookie方法,通知客户端保存修改
         */
//        Cookie cookie = new Cookie("key1", "newValue");
//        resp.addCookie(cookie);
//        resp.getWriter().write("key1的cookie已经修改好");
        /*
        方案二
        先找到要修改的cookie对象
        调用setValue方法赋新值
        调用addCookie方法保存修改
         */
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie!=null){
            cookie.setValue("newValue2");
        }
        resp.addCookie(cookie);
        resp.getWriter().write("key1的cookie已经修改好");
    }
    protected void defaultLife(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);

    }
    protected void deleteNow(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        Cookie cookie = CookieUtils.findCookie("defaultLife", req.getCookies());
        if (cookie!=null){
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("已经删除了");
        }
    }
}
