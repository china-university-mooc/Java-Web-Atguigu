package com.itutry.web;

import com.itutry.pojo.Book;
import com.itutry.service.BookService;
import com.itutry.service.impl.BookServiceImpl;
import com.itutry.utils.ReflectUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private final BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = ReflectUtils.mapToBean(req.getParameterMap(), Book.class);
        bookService.addBook(book);
//        req.getRequestDispatcher("/manager/book?action=list").forward(req, resp);
        // 防止表单重复提交，使用重定向
        resp.sendRedirect(req.getContextPath() + "/manager/book?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
