package com.ekoshmarik.model;

public class Book implements Comparable<Book> {

  private Integer id;

  private String name;

  private String author;

  public Book() {

  }

  public Book(String name, String author) {
    this.name = name;
    this.author = author;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;

    Book book = (Book) o;

    if (!id.equals(book.id)) return false;
    if (!name.equals(book.name)) return false;
    return author.equals(book.author);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + author.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "{" +
        " name: '" + name + '\'' + "," +
        " author: '" + author + '\'' +
        " }";
  }

  public int compareTo(Book o) {
    return this.name.compareTo(o.getName());
  }
}
