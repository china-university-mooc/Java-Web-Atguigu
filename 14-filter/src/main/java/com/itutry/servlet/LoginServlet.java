package com.itutry.servlet;

import com.itutry.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if ("jerry".equals(username) && "12345".equals(password)) {
            req.getSession().setAttribute("user", new User(username, password));
        }

        resp.sendRedirect(req.getHeader("Referer"));
    }
}
