package com.itutry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-05-16_10:50
 */
public class ConfigServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("Servlet name: " + getServletConfig().getServletName());
    System.out.println("Init param names: " + getServletConfig().getInitParameterNames());
    System.out.println("Init param username: " + getServletConfig().getInitParameter("username"));
    System.out.println("Init param url: " + getServletConfig().getInitParameter("url"));
    System.out.println("Init param url: " + getServletConfig().getServletContext());

    System.out.println("保存context key1：" + getServletContext().getAttribute("key1"));
  }
}
