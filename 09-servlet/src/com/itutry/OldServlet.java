package com.itutry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_10:02
 */
public class OldServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

//    response.setStatus(302);
//    response.setHeader("Location", "/09-servlet/new");
    response.sendRedirect("/09-servlet/new");
  }
}
