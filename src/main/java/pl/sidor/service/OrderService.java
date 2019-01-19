package pl.sidor.service;

import pl.sidor.model.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    List<Order> showOrder();
}
