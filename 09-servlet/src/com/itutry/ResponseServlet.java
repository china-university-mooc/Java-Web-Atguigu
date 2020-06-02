package com.itutry;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itutry
 * @create 2020-06-02_09:49
 */
public class ResponseServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
//    response.setCharacterEncoding("UTF-8");
//    response.setHeader("Content-Type", "text/html; charset=UTF-8");

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter writer = response.getWriter();
    writer.write("我真帅");
  }
}
