package com.itutry.test;

import com.itutry.pojo.Book;
import com.itutry.pojo.Page;
import com.itutry.service.BookService;
import com.itutry.service.impl.BookServiceImpl;
import org.junit.Test;

public class BookServiceImplTest {

    private final BookService bookService = new BookServiceImpl();

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, Page.PAGE_SIZE);
        System.out.println(page);
    }

}
