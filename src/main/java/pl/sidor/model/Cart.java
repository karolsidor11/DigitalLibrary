package pl.sidor.model;

import java.util.List;
import java.util.Objects;

public class Cart {

    private List<Book> orders;
    private User user;

    public List<Book> getOrders() {
        return orders;
    }

    public void setOrders(List<Book> orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(orders, cart.orders) && Objects.equals(user, cart.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orders, user);
    }

    @Override
    public String toString() {
        return "Cart{" + "orders=" + orders + ", user=" + user + '}';
    }
}
