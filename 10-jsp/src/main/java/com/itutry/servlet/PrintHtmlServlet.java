package com.itutry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintHtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        <!DOCTYPE html>
//        <html lang="en">
//        <head>
//            <meta charset="UTF-8">
//            <title>Title</title>
//        </head>
//        <body>
//             这是html页面数据
//             </body>
//        </html>
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"en\">");
        writer.println("<head>");
        writer.println("    <meta charset=\"UTF-8\">");
        writer.println("    <title>Title</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("    这是html页面数据");
        writer.println("    </body>");
        writer.println("</html>");

    }
}
