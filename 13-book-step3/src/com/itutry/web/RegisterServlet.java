package com.itutry.web;

import com.itutry.pojo.User;
import com.itutry.service.UserService;
import com.itutry.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_15:33
 */
public class RegisterServlet extends HttpServlet {

  private UserService userService = new UserServiceImpl();

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
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
        request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
      }
    } else {
      System.out.println("验证码[" + code + "]错误");
      request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
    }
  }
}
