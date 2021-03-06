package controllers;

import lombok.RequiredArgsConstructor;
import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.OrderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    public List<Order> getOrders() {
        return orderService.getOrders();
    }
    public Order getOrderByCustomerId(int id) {
        return orderService.getOrderByCustomerId(id);
    }
    public Order getOrderByProductId(int id) {
        return orderService.getOrderByProductId(id);
    }
    public void saveOrders(List<Order> orders) {
        orderService.saveOrders(orders);
    }
    public Order updateOrder(Order order) {
        return orderService.updateOrder(order);
    }
    public void removeOrder(Order order) {
        orderService.removeOrder(order);
    }

}
