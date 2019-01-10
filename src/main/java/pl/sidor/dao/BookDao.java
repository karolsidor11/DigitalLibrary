package pl.sidor.dao;

import pl.sidor.model.Book;

import java.util.List;

public interface BookDao {

    List<Book> findByTitle(String title);

    List<Book> findAll();

    void add(Book book);

    void delete(Integer id);

    void update(Integer id);

}
