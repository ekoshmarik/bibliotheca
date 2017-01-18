package com.ekoshmarik.options;

import com.ekoshmarik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component("optionManager")
public class OptionManager {

  private final AddBookOption addBookOption;
  private final AllBooksOption allBooksOption;
  private final EditBookOption editBookOption;
  private final RemoveBookOption removeBookOption;

  @Autowired
  public OptionManager(BookService bookService, AddBookOption addBookOption, AllBooksOption allBooksOption, EditBookOption editBookOption, RemoveBookOption removeBookOption) {
    this.addBookOption = addBookOption;
    this.allBooksOption = allBooksOption;
    this.editBookOption = editBookOption;
    this.removeBookOption = removeBookOption;
  }


  public void execute() throws SQLException {
    displayMenu();
  }

  private void displayMenu() {
    Scanner userInput = new Scanner(System.in);

    System.out.println("                                          ");
    System.out.println("******************************************");
    System.out.println("| BIBLIOTHECA (Console CRUD Application) |");
    System.out.println("******************************************");
    System.out.println("| Choose one of the following options:   |");
    System.out.println("|        1. Add Book                     |");
    System.out.println("|        2. Remove Book                  |");
    System.out.println("|        3. Edit Book                    |");
    System.out.println("|        4. All Books                    |");
    System.out.println("|        5. Exit                         |");
    System.out.println("******************************************");
    System.out.println("                                          ");
    System.out.print("Select an option: ");

    String chosenOption = userInput.next();

    switch (chosenOption) {
      case "1":
        addBookOption.execute();
        displayMenu();
        break;
      case "2":
        removeBookOption.execute();
        displayMenu();
        break;
      case "3":
        editBookOption.execute();
        displayMenu();
        break;
      case "4":
        allBooksOption.execute();
        displayMenu();
        break;
      case "5":
        System.exit(0);
        break;
      default:
        System.out.println("Invalid selection. Type a number from 1 to 5...");
        displayMenu();
        break;
    }
  }
}
