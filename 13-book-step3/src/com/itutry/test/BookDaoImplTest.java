package com.itutry.test;

import com.itutry.dao.BookDao;
import com.itutry.dao.impl.BookDaoImpl;
import com.itutry.pojo.Book;
import com.itutry.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null, "易筋经", "张三", new BigDecimal(118.99), 999, 99, null);
        int rows = bookDao.addBook(book);
        System.out.println(rows);
        queryBooks();
    }

    @Test
    public void deleteBookById() {
        int rows = bookDao.deleteBookById(22);
        System.out.println(rows);
        queryBooks();
    }

    @Test
    public void updateBook() {
        Book book = new Book(21, "易筋经", "李四", new BigDecimal(118.99), 999, 99, null);
        int rows = bookDao.updateBook(book);
        System.out.println(rows);
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(2);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void queryForTotalCount() {
        int count = bookDao.queryForTotalCount();
        System.out.println(count);
    }

    @Test
    public void queryForPageItems() {
        List<Book> items = bookDao.queryForPageItems(0, Page.PAGE_SIZE);
        items.forEach(System.out::println);
    }
}