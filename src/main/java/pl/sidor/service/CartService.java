package pl.sidor.service;

import pl.sidor.model.Book;

import java.util.List;

public interface CartService {

    List<Book> findAll();

    void addOrder(Book book);

    void removeOrder(Book book);
}
