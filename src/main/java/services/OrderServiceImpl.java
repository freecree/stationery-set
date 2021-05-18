package services;

import exceptions.NotImplementedException;
import exceptions.OrderNotFountException;
import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

import static java.util.Optional.of;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
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
                        //.filter(order -> productService.getProductById(order.getId()).getId() == s)
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
    public Order updateOrder(int id) {
        throw new NotImplementedException();
    }
    public void removeOrder(int id) {
        orderRepository.remove(id);
    }

}
