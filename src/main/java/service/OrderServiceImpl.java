package service;

import exceptions.NotImplementedException;
import exceptions.OrderNotFountException;
import models.Order;
import repository.OrderRepository;

import java.util.List;

import static java.util.Optional.of;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.getAllOrders();
    }
    public Order getOrderByCustomerId(int id) {
        return of(id)
            .map(s -> getOrders().stream()
                    .filter(order -> order.getId() == s)
                    .findAny()
                    .orElseThrow(OrderNotFountException::new)
            ).orElseThrow(OrderNotFountException::new);
    }
    public Order getOrderByProductId(int id) {
        return of(id)
                .map(s -> getOrders().stream()
                        .filter(order -> order.getId() == s)
                        .findAny()
                        .orElseThrow(OrderNotFountException::new)
                ).orElseThrow(OrderNotFountException::new);
    }
    public void saveOrders(List<Order> orders) {
        for(Order order : orders) {
            orderRepository.save(order);
        }
    }
    public Order updateOrder(int id) {
        throw new NotImplementedException();
    }
    public void removeOrder(int id) {
        orderRepository.remove(id);
    }

}
