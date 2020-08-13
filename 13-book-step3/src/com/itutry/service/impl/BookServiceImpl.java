package com.itutry.service.impl;

import com.itutry.dao.BookDao;
import com.itutry.dao.impl.BookDaoImpl;
import com.itutry.pojo.Book;
import com.itutry.pojo.Page;
import com.itutry.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        int totalCount = bookDao.queryForTotalCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        int begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }
}
