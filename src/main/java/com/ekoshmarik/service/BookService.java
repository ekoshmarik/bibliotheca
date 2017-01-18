package com.ekoshmarik.service;

import com.ekoshmarik.dao.BookDao;
import com.ekoshmarik.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

  private final BookDao jdbcBookDao;

  @Autowired
  public BookService(BookDao jdbcBookDao) {
    this.jdbcBookDao = jdbcBookDao;
  }

  @Transactional
  public void addBook(Book book) {
    this.jdbcBookDao.addBook(book);
  }

  @Transactional
  public void editBook(Book book, String newName) {
    this.jdbcBookDao.editBook(book, newName);
  }

  @Transactional
  public void removeBook(Book book) {
    this.jdbcBookDao.removeBook(book);
  }

  @Transactional(readOnly = true)
  public List<Book> findBookByName(String name) {
    return this.jdbcBookDao.findBookByName(name);
  }

  @Transactional(readOnly = true)
  public List<Book> findAllBooks() {
    return this.jdbcBookDao.findAllBooks();
  }
}
