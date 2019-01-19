package pl.sidor.model;

import java.util.List;
import java.util.Objects;

public class Order {

    private Integer id;
    private List<Book> bookList;
    private String user;
    private String dateOfReturn;

    public Order() {
    }

    public Order(Integer id, List<Book> bookList, String user, String dateOfReturn) {
        this.id = id;
        this.bookList = bookList;
        this.user = user;
        this.dateOfReturn = dateOfReturn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(bookList, order.bookList) && Objects.equals(user, order.user) && Objects.equals(dateOfReturn, order.dateOfReturn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bookList, user, dateOfReturn);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", bookList=" + bookList + ", user='" + user + '\'' + ", dateOfReturn='" + dateOfReturn + '\'' + '}';
    }
}
