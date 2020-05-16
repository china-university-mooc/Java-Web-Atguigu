package com.itutry;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-05-16_09:54
 */
public class HelloServlet implements Servlet {

  public HelloServlet() {
    System.out.println("构造");
  }

  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    System.out.println("初始化");
  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    System.out.println("Hello Servlet 被访问了");
    final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    final HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    final String method = httpServletRequest.getMethod();
    if ("GET".equals(method)) {
      doGet(httpServletRequest, httpServletResponse);
    } else if ("POST".equals(method)) {
      doPost(httpServletRequest, httpServletResponse);
    }
  }

  private void doGet(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    System.out.println("get请求");
  }

  private void doPost(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    System.out.println("post请求");
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("销毁");
  }
}
