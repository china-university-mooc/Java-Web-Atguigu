package com.itutry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_09:23
 */
public class BobServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    System.out.println("Bob查看参数: " + request.getParameter("username"));
    System.out.println("Bob查看Alice的章：" + request.getAttribute("key"));
    System.out.println("Bob处理自己的事情");
  }
}
