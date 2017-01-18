package com.ekoshmarik.options;

import com.ekoshmarik.model.Book;
import com.ekoshmarik.service.BookService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AllBooksOption {

  private final BookService bookService;

  public AllBooksOption(BookService bookService) {
    this.bookService = bookService;
  }

  public void execute() {
    List<Book> books = bookService.findAllBooks();
    Collections.sort(books);
    System.out.println("Books in the bibliotheca: ");
    System.out.println("                                          ");
    if (books.size() > 0) {
      for (int i = 1; i <= books.size(); i++) {
        System.out.println(i + ". " + books.get(i - 1).getAuthor()
            + " '" + books.get(i - 1).getName() + "'");
      }
    } else {
      System.out.println("Library is empty.");
    }
  }
}
