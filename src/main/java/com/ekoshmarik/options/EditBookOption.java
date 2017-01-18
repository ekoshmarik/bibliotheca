package com.ekoshmarik.options;

import com.ekoshmarik.model.Book;
import com.ekoshmarik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class EditBookOption {

  private final BookService bookService;

  @Autowired
  public EditBookOption(BookService bookService) {
    this.bookService = bookService;
  }

  public void execute() {
    Scanner userInput = new Scanner(System.in);
    Book book;
    String newName = "";

    System.out.print("Enter book name to edit: ");
    String name = userInput.nextLine();

    List<Book> books = bookService.findBookByName(name);
    Collections.sort(books);

    if (books.size() > 1) {
      System.out.println(
          "We have few books with such name. Please choose one by typing a number of the book: ");

      for (int i = 1; i <= books.size(); i++) {
        System.out.println(i + ". " + books.get(i - 1).getAuthor()
            + " '" + books.get(i - 1).getName() + "'");
      }

      System.out.print("Type a number of the book: ");
      Integer bookNumber = new Scanner(System.in).nextInt();
      book = books.get(bookNumber - 1);
      System.out.print("Type a new name of the book: ");
      newName = userInput.nextLine();
      bookService.editBook(book, newName);
      System.out.println(String.format("Book %s was edited. Name was changed to %s.", book, newName));
    } else if (books.size() == 1) {
      book = books.get(0);
      System.out.print("Type a new name of the book: ");
      newName = userInput.nextLine();

      bookService.editBook(book, newName);
      System.out.println(String.format("Book %s was edited. Name was changed to %s.", book, newName));
    } else {
      System.out.println("No book with such name found.");
    }
  }
}
