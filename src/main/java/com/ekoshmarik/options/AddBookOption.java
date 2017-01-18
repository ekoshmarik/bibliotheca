package com.ekoshmarik.options;

import com.ekoshmarik.model.Book;
import com.ekoshmarik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddBookOption {

  private final BookService bookService;

  @Autowired
  public AddBookOption(BookService bookService) {
    this.bookService = bookService;
  }

  public void execute() {
    Scanner userInput = new Scanner(System.in);

    System.out.print("Enter book name: ");
    String name = userInput.nextLine();

    System.out.print("Enter book author: ");
    String author = userInput.nextLine();

    Book book = new Book(name, author);

    bookService.addBook(book);
  }
}
