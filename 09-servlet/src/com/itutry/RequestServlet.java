package com.itutry;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_08:44
 */
public class RequestServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("URI => " + request.getRequestURI());
    System.out.println("URL => " + request.getRequestURL());
    System.out.println("客户端IP地址 => " + request.getRemoteHost());

    System.out.println("请求头User-Agent => " + request.getHeader("User-Agent"));
    System.out.println("请求方式 => " + request.getMethod());

    System.out.println("username => " + request.getParameter("username"));
    System.out.println("password => " + request.getParameter("password"));
    System.out.println("one hobby => " + request.getParameter("hobby"));
    System.out.println("all hobby => " + Arrays.toString(request.getParameterValues("hobby")));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    System.out.println("username => " + req.getParameter("username"));
    System.out.println("password =>"
        + " " + req.getParameter("password"));
    System.out.println("one hobby => " + req.getParameter("hobby"));
    System.out.println("all hobby => " + Arrays.toString(req.getParameterValues("hobby")));
  }
}
