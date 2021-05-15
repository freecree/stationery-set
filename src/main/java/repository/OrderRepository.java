package repository;

import exceptions.NotImplementedException;
import models.Order;

import java.util.Collections;
import java.util.List;

public class OrderRepository {

    public List<Order> getAllOrders() {
        return Collections.emptyList();
    }
    public void save(Order order) {
        throw new NotImplementedException();
    }
    public Order update(int id) {
        throw new NotImplementedException();
    }
    public void remove(int id) {
        throw new NotImplementedException();
    }
}
