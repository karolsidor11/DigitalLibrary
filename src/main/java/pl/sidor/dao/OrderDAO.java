package pl.sidor.dao;

import pl.sidor.model.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(Order order);

    List<Order> showOrder();

}
