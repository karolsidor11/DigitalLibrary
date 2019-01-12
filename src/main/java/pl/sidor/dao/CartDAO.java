package pl.sidor.dao;

import pl.sidor.model.Book;
import pl.sidor.model.Cart;

import java.util.List;

public interface CartDAO {

    List<Book> findAll();

    void addOrder(Book book);

    void removeOrder(Book book);
}
