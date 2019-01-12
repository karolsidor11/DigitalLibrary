package pl.sidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.dao.CartDAO;
import pl.sidor.model.Book;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private CartDAO cartDAO;

    @Autowired
    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    public List<Book> findAll() {
        return cartDAO.findAll();
    }

    @Override
    public void addOrder(Book book) {
        cartDAO.addOrder(book);

    }

    @Override
    public void removeOrder(Book book) {
        cartDAO.removeOrder(book);
    }
}
