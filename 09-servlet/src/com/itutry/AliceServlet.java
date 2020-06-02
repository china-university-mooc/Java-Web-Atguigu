package com.itutry;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_09:23
 */
public class AliceServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    System.out.println("Alice查看参数: " + request.getParameter("username"));

    request.setAttribute("key", "Alice的章");

    RequestDispatcher dispatcher = request.getRequestDispatcher("/bob");
    dispatcher.forward(request, response);
  }
}
