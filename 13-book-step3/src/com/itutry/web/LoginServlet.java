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
 * @create 2020-06-02_15:57
 */
public class LoginServlet extends HttpServlet {

  private UserService userService = new UserServiceImpl();

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (userService.login(new User(null, username, password, null)) != null) {
      request.getRequestDispatcher("/pages/user/login_success.html").forward(request, response);
    } else {
      System.out.println("用户名或密码错误");
      request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
    }
  }
}
