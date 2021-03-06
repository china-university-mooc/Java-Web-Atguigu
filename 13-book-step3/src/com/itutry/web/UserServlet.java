package com.itutry.web;

import com.google.gson.Gson;
import com.itutry.pojo.User;
import com.itutry.service.UserService;
import com.itutry.service.impl.UserServiceImpl;
import com.itutry.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private final UserService userService = new UserServiceImpl();

    /**
     * 处理注册的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = WebUtils.mapToBean(request.getParameterMap(), User.class);

        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token != null && token.equalsIgnoreCase(code)) {
            if (!userService.existUsername(username)) {
                userService.register(user);
                user = userService.login(user);
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            } else {
                System.out.println("用户名[" + username + "]已存在");
                registError(request, response, username, email, "用户名已存在！");
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            registError(request, response, username, email, "验证码错误！");
        }
    }

    private void registError(HttpServletRequest request, HttpServletResponse response, String username, String email, String errMsg) throws ServletException, IOException {
        request.setAttribute("errMsg", errMsg);
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
    }

    /**
     * 处理登录的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = WebUtils.mapToBean(request.getParameterMap(), User.class);
        user = userService.login(user);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            System.out.println("用户名或密码错误");
            request.setAttribute("username", username);
            request.setAttribute("errMsg", "用户名或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        boolean existUsername = userService.existUsername(username);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existUsername", existUsername);

        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(resultMap));
    }
}
