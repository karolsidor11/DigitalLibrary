package pl.sidor.dao;

import pl.sidor.model.Book;
import pl.sidor.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImit implements BookService {

    private List<Book> bookList = new ArrayList<>();


    @Override
    public List<Book> findByTitle(String title) {

        List<Book> collect = bookList.stream().filter(e -> e.getTitle().equals(title)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public void add(final Book book) {
        bookList.add(book);
    }

    @Override
    public void delete(final Integer id) {
        Book book = bookList.stream().filter(e -> e.getId().equals(id)).findFirst().get();
        bookList.remove(book);

    }

    @Override
    public void update(Book book) {
        Book book2 = bookList.stream().filter(book1 -> book.getId().equals(book.getId())).findFirst().get();
        book2.setAuthor(book.getAuthor());
        book2.setTitle(book.getTitle());
        book2.setPages(book.getPages());
        book2.setIsbn(book.getIsbn());

        bookList.add(book2);
    }
}
