package controllers;

import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.OrderService;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

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
    public Order updateOrder(int id) {
        return orderService.updateOrder(id);
    }
    public void removeOrder(int id) {
        orderService.removeOrder(id);
    }

}
