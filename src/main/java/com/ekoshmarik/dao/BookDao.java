package com.ekoshmarik.dao;

import com.ekoshmarik.model.Book;

import java.util.List;

public interface BookDao {

  void addBook(final Book book);

  void editBook(Book book, String newName);

  void removeBook(Book book);

  List<Book> findBookByName(String name);

  List<Book> findAllBooks();
}
