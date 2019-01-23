package pl.sidor.daoimpl;

import org.springframework.stereotype.Repository;
import pl.sidor.dao.CartDAO;
import pl.sidor.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDAO {

    private List<Book> bookList = new ArrayList<>();


    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public void addOrder(Book book) {
        if(book!=null){
            bookList.add(book);
        }

    }

    @Override
    public void removeOrder(Book book) {
        bookList.remove(book);
    }
}
