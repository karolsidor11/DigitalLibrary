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


    @Before
    public void setup() {
        cartDAO= new CartDaoImpl();
        cartService= new CartServiceImpl(cartDAO);
    }


    @Test
    public void shouldAddBookToCart() {

//        given
        Book book = new Book(1, "Java", "Karol", 22, "isbn22");
//        when
        cartService.addOrder(book);
//         then
        assertEquals(cartDAO.findAll().size(),1);
        assertEquals(cartDAO.findAll().get(0), book);


    }
}
