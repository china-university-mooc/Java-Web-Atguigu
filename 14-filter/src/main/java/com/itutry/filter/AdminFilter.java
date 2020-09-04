package com.itutry.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1.构造器 AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.初始化 init(FilterConfig filterConfig)");
        System.out.println("filter-name: " + filterConfig.getFilterName());
        System.out.println("username: " + filterConfig.getInitParameter("username"));
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁 destroy()");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.拦截 doFilter()");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        // 如果等于null,说明还没有登录
        if (null == user) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
