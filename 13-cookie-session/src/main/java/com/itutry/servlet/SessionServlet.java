package com.itutry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void createOrGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        boolean isNew = session.isNew();
        String sessionId = session.getId();

        resp.getWriter().println("Session的Id是：" + sessionId + "<br/>");
        resp.getWriter().println("这个Session是新的吗：" + isNew);
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");

        resp.getWriter().write("往Session域中存储了数据！");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object value = req.getSession().getAttribute("key1");

        resp.getWriter().write("从Session域中取出key1的值为：" + value);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("Session的默认超时时间为：" + maxInactiveInterval);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setMaxInactiveInterval(3);

        resp.getWriter().write("设置该Session为3秒超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        resp.getWriter().write("设置该Session为立即超时（无效）");
    }
}
