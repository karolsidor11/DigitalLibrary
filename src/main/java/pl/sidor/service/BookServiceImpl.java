package pl.sidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.dao.BookDao;
import pl.sidor.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public Book findByTitle(String title) {
        Book byTitle = bookDao.findByTitle(title);
        return byTitle;
    }

    @Override
    public List<Book> findAll() {
        List<Book> all = bookDao.findAll();
        return all;
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
    }

    @Override
    public void update(Integer id) {
        bookDao.update(id);
    }
}
