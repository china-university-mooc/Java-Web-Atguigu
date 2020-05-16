package com.itutry;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-05-16_11:02
 */
public class ContextServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    final ServletContext servletContext = getServletConfig().getServletContext();
    System.out.println("context username: " + servletContext.getInitParameter("username"));
    System.out.println("context password: " + servletContext.getInitParameter("password"));

    System.out.println("工程路径：" + servletContext.getContextPath());
    System.out.println("根绝对路径：" + servletContext.getRealPath("/"));
    System.out.println("/css/1.css绝对路径：" + servletContext.getRealPath("/css/1.css"));

    System.out.println("保存前获取key1：" + servletContext.getAttribute("key1"));
    servletContext.setAttribute("key1", "value1");
    System.out.println("保存后获取key1：" + servletContext.getAttribute("key1"));
  }
}
