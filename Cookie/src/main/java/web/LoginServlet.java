package web; /**
 * @author QFY
 * @Description
 * @create 2021-05-21 16:21
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password = request.getParameter("password");
        if ("qwe123".equals(username)&&"123123".equals(password)){
            Cookie cookie=new Cookie("username",username);
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            System.out.println("success");
        }
        else
            System.out.println("failed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
