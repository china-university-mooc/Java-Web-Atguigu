package com.itutry.servlet;

import com.google.gson.Gson;
import com.itutry.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("javaScriptAjax()方法调用了");

        Person person = new Person(1, "李白");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        resp.getWriter().write(jsonStr);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax()方法调用了");

        Person person = new Person(1, "李白");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        resp.getWriter().write(jsonStr);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize()方法调用了");
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        Person person = new Person(1, "李白");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(person);
        resp.getWriter().write(jsonStr);
    }
}
