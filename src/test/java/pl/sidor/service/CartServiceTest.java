package pl.sidor.service;

import org.junit.Before;
import org.junit.Test;
import pl.sidor.dao.CartDAO;
import pl.sidor.daoimpl.CartDaoImpl;
import pl.sidor.model.Book;

import static org.junit.Assert.assertEquals;

public class CartServiceTest {

    private CartService cartService;
    private CartDAO cartDAO;
    private Book book;

    @Before
    public void setup() {
        cartDAO = new CartDaoImpl();
        cartService = new CartServiceImpl(cartDAO);
        book = new Book(1, "Java", "Karol", 22, "isbn22");
    }

    @Test
    public void shouldAddBookToCart() {

        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        cartService.addOrder(book1);

        assertEquals(cartDAO.findAll().size(), 1);
        assertEquals(cartDAO.findAll().get(0), book1);

    }

    @Test(expected = AssertionError.class)
    public void addNullBookToCart() {
        cartService.addOrder(null);
        assertEquals(1, cartService.findAll().size());
    }

    @Test
    public void removeBookFromCart() {
        cartService.addOrder(book);
        cartDAO.removeOrder(book);
        assertEquals(0, cartDAO.findAll().size());

    }

    @Test
    public void getAllEmptyCart() {
        cartService.findAll();
        assertEquals(0, cartDAO.findAll().size());
    }

    @Test
    public void getAllCart() {
        cartService.addOrder(book);
        cartService.findAll();

        assertEquals(1, cartDAO.findAll().size());
    }
}
