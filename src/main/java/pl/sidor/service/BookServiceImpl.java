package pl.sidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {


    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.delete(id);
    }
}
