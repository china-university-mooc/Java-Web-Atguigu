package com.itutry.web;

import com.itutry.pojo.Book;
import com.itutry.pojo.Cart;
import com.itutry.pojo.CartItem;
import com.itutry.service.BookService;
import com.itutry.service.impl.BookServiceImpl;
import com.itutry.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
        }

        resp.sendRedirect(req.getHeader("Referer"));
    }
}
