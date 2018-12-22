package pl.sidor.model;

public class Book {

    private Integer id;
    private String title;
    private String author;
    private int pages;
    private String isbn;


    public Book(Integer id, String title, String author, int pages, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", pages=" + pages + ", isbn='" + isbn + '\'' + '}';
    }
}
