package pl.sidor.service;

import pl.sidor.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    Book findBook(int id);

    void addBook(Book book);

    void deleteBook(int id);
}
