package com.ekoshmarik.dao;

import com.ekoshmarik.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class JdbcBookDao implements BookDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcBookDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void addBook(final Book book) {

    KeyHolder holder = new GeneratedKeyHolder();

    this.jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(
          "insert into book (author, name) values (?, ?)",
          Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, book.getAuthor());
      ps.setString(2, book.getName());
      return ps;
    }, holder);

    int newBookId = holder.getKey().intValue();
    book.setId(newBookId);

  }

  public void editBook(Book book, String newName) {
    this.jdbcTemplate.update("update book set name = ? where id = ?", newName, book.getId());
  }

  public void removeBook(Book book) {
    final String sql = "delete from book where id = " + book.getId();
    this.jdbcTemplate.update("delete from book where id = ?", book.getId());
  }

  public List<Book> findBookByName(String name) {
    final String sql = "select * from book where name like '%" + name + "%'";
    return this.jdbcTemplate.query(sql, new BookMapper());
  }

  public List<Book> findAllBooks() {
    return this.jdbcTemplate.query("select * from book", new BookMapper());
  }

  private static final class BookMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
      final Book book = new Book();
      book.setId(rs.getInt("id"));
      book.setName(rs.getString("name"));
      book.setAuthor(rs.getString("author"));
      return book;
    }
  }
}
