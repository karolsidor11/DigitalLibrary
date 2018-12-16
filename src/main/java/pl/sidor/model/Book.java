package pl.sidor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotEmpty(message = "Wprowadź tytuł książki !")
    private String title;

    @Column
    @NotEmpty(message = "Wprowadź autora książki !")
    private String author;

    @Column
    @NotNull(message = "Wprowadź ilość stron !")
    private int pages;

    @Column
    @NotEmpty(message = "Wprowadź numer ISBN !")
    private String ISBN;

    public Book() {
    }

    public Book(String title, String author, int pages, String ISBN) {

        this.title = title;
        this.author = author;
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", pages=" + pages + ", ISBN='" + ISBN + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, author, pages, ISBN);
    }
}
