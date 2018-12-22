package pl.sidor.dao;

import pl.sidor.model.Book;

import java.util.List;

public interface BookDao {
    Book findByTitle(String title);

    List<Book> findAll();
}
