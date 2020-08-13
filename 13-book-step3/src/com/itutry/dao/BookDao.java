package com.itutry.dao;

import com.itutry.pojo.Book;

import java.util.List;

public interface BookDao {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    int queryForTotalCount();

    List<Book> queryForPageItems(int pageNo, int pageSize);
}
