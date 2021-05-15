package service;

import models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    Order getOrderByUserId(int id);
    Order getOrderByProductId(int id);
    void saveOrders(List<Order> orders);
    Order updateOrder(int id);
    void removeOrder(int id);


}
