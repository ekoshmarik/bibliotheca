package com.ekoshmarik.options;

import com.ekoshmarik.model.Book;
import com.ekoshmarik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class RemoveBookOption {

  private final BookService bookService;

  @Autowired
  public RemoveBookOption(BookService bookService) {
    this.bookService = bookService;
  }

  public void execute() {
    Scanner userInput = new Scanner(System.in);
    Book book;

    System.out.print("Enter the book name to remove: ");
    String name = userInput.nextLine();

    List<Book> books = bookService.findBookByName(name);
    Collections.sort(books);

    if (books.size() > 1) {
      System.out.println(
          "We have few books with such name. Please choose one by typing a number of a book: ");

      for (int i = 1; i <= books.size(); i++) {
        System.out.println(i + ". " + books.get(i - 1).getAuthor()
            + " '" + books.get(i - 1).getName() + "'");
      }

      System.out.print("Type a number of the book you want to remove: ");
      Integer bookNumber = userInput.nextInt();
      book = books.get(bookNumber - 1);
      bookService.removeBook(book);
      System.out.println(String.format("Book %s was removed.", book));
    } else if (books.size() == 1) {
      book = books.get(0);
      bookService.removeBook(book);
      System.out.println(String.format("Book %s was removed.", book));
    } else {
      System.out.println("No book with such name found.");
    }
  }
}
