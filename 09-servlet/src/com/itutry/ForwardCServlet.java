package com.itutry;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_09:38
 */
public class ForwardCServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
      request.getRequestDispatcher("/a/b/c.html").forward(request, response);
  }
}
