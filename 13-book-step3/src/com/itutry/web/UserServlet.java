package com.itutry.web;

import com.itutry.pojo.User;
import com.itutry.service.UserService;
import com.itutry.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            login(request, response);
        } else if ("regist".equals(action)) {
            regist(request, response);
        }
    }

    /**
     * 处理注册的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (code.equalsIgnoreCase("abcd")) {
            if (!userService.existUserName(username)) {
                User user = new User(null, username, password, email);
                userService.register(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            } else {
                System.out.println("用户名[" + username + "]已存在");
                registError(request, response, username, email, "用户名已存在！");
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            registError(request, response, username, email, "验证码错误！");
        }
    }

    private void registError(HttpServletRequest request, HttpServletResponse response, String username, String email, String errMsg) throws ServletException, IOException {
        request.setAttribute("errMsg", errMsg);
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
    }

    /**
     * 处理登录的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userService.login(new User(null, username, password, null)) != null) {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            System.out.println("用户名或密码错误");
            request.setAttribute("username", username);
            request.setAttribute("errMsg", "用户名或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }
}
