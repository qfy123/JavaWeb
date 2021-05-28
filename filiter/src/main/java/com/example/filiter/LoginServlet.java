package com.example.filiter; /**
 * @author QFY
 * @Description
 * @create 2021-05-27 11:09
 */

import sun.plugin.viewer.LifeCycleManager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("wzg168".equals(username) && "123123".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }


}
