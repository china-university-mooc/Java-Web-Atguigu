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
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            String orderId = orderService.createOrder(cart, user.getId());
            req.setAttribute("orderId", orderId);
            req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        }
    }
}
