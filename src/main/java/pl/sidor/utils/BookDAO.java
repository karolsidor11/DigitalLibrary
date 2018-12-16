package pl.sidor.utils;

import pl.sidor.model.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getAllBook();

    void addBook(Book book);

    void deleteBook(int id);

    Book findBook(String title);

}
