package services;

import exceptions.NotImplementedException;
import exceptions.OrderNotFountException;
import lombok.RequiredArgsConstructor;
import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderByCustomerId(int id) {
        return of(id)
            .map(s -> getOrders().stream()
                .filter(order -> order.getCustomer().getId() == s)
                .findAny()
                .orElseThrow(OrderNotFountException::new)
            ).orElseThrow(OrderNotFountException::new);
    }
    public Order getOrderByProductId(int id) {
        return of(id)
            .map(s -> getOrders().stream()
                    .filter(order -> order.getProduct().getId() == s)
                    .findAny()
                    .orElseThrow(OrderNotFountException::new)
            ).orElseThrow(OrderNotFountException::new);
    }
    public void saveOrders(List<Order> orders) {
        for(Order order : orders) {
            orderRepository.save(order);
        }
    }
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
    public void removeOrder(Order order) {
        orderRepository.delete(order);
    }

}
