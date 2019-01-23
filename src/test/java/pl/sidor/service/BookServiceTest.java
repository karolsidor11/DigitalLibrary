package pl.sidor.service;

import org.junit.Before;
import org.junit.Test;
import pl.sidor.dao.BookDaoImit;
import pl.sidor.model.Book;
import pl.sidor.tests.BookServiceMock;

import static org.junit.Assert.assertEquals;

public class BookServiceTest {

    private BookServiceMock bookServiceMock;
    private BookDaoImit bookDaoImit;
    private Book book;

    @Before
    public void before() {
        bookServiceMock = new BookServiceMock();
        bookDaoImit = new BookDaoImit();

    }

    @Test
    public void shouldAddBookToCart() {

        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        bookDaoImit.add(book1);

        assertEquals(1, bookDaoImit.findAll().size());
        assertEquals("Java", book1.getTitle());

    }

    @Test
    public void shouldReturnAllListBook() {
        assertEquals(0, bookDaoImit.findAll().size());
    }

    @Test
    public void shouldRemoveBookFromList() {
        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        Book book2 = new Book(2, "Java", "Karol", 29, "isbn22");
        bookDaoImit.add(book1);
        bookDaoImit.add(book2);

        bookDaoImit.delete(1);
        assertEquals(1, bookDaoImit.findAll().size());
    }

    @Test
    public void shouldFindAllBooks() {
        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        Book book2 = new Book(2, "Java", "Karol", 29, "isbn22");
        Book book3 = new Book(3, "Java", "Karol", 29, "isbn22");
        bookDaoImit.add(book1);
        bookDaoImit.add(book2);
        bookDaoImit.add(book3);

        assertEquals(3, bookDaoImit.findAll().size());
    }

    @Test
    public void shouldFindByTitle() {
        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        bookDaoImit.add(book1);

        assertEquals(book1, bookDaoImit.findByTitle("Java").get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldBookWhenTitleIsEmpty() {
        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        bookDaoImit.add(book1);

        assertEquals(book1, bookDaoImit.findByTitle("").get(0));
    }

    @Test
    public void shouldUpdateBook() {
        Book book1 = new Book(1, "Java", "Karol", 22, "isbn22");
        bookDaoImit.add(book1);

        book1.setPages(25);
        bookDaoImit.update(book1);

        assertEquals(25, bookDaoImit.findByTitle("Java").get(0).getPages());


    }

}
