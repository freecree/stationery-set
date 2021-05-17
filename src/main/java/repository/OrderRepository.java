package repository;

import exceptions.NotImplementedException;
import models.Order;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
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
