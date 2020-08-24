package com.itutry.servlet;

import com.itutry.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("path1", "path1");
        cookie.setPath(req.getContextPath() + "/abc");

        resp.addCookie(cookie);
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("key3", "value3");
        cookie.setMaxAge(3600);

        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtil.findCookie(cookies, "key1");
        if (cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("key1的Cookie已经删除");
        }
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("defaultList", "defaultLife");
        cookie.setMaxAge(-1);

        resp.addCookie(cookie);
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("key1", "newValue1");

        resp.addCookie(cookie);
        resp.getWriter().write("key1的Cookie已经修改好");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            // getName():获取Cookie的key(名)
            // getValue():获取Cookie的value(值)
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        Cookie cookie = CookieUtil.findCookie(cookies, "key1");
        if (cookie != null) {
            System.out.println("名为key1的Cookie的值为：" + cookie.getValue());
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        // 2.通知客户端保存Cookie
        resp.addCookie(cookie);


//        Cookie cookie1 = new Cookie("key3", "value3");
//        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie创建成功");
    }
}
