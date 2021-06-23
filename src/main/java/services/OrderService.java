package services;

import models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    Order getOrderByCustomerId(int id);
    Order getOrderByProductId(int id);
    void saveOrders(List<Order> orders);
    Order updateOrder(Order order);
    void removeOrder(Order order);


}
