package com.itutry.web;

import com.itutry.pojo.Cart;
import com.itutry.pojo.User;
import com.itutry.service.OrderService;
import com.itutry.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private final OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
        } else {
            String orderId = orderService.createOrder(cart, user.getId());
            req.getSession().setAttribute("orderId", orderId);
            resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }
}
