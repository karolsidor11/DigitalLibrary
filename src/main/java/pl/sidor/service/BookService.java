package pl.sidor.service;

import pl.sidor.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findByTitle(String title);

    List<Book> findAll();

    void add(Book book);

    void delete(Integer id);

    void update(Integer id);
}
