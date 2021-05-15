package service;

import models.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.OrderRepository;

import java.util.List;

import static java.util.Collections.singletonList;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderServiceImpl orderService;

    private Order orderToFind;
//    @Mock
//    private Order order;

    @BeforeEach
    void setUp() {
        orderToFind = new Order();
    }

    @Test
    @DisplayName("Returning orders")
    void getOrders() {
        //GIVEN
        Mockito.doReturn(singletonList(new Order())).when(orderRepository).getAllOrders();
        //WHEN
        orderService.getOrders();
        //THEN
        Mockito.verify(orderRepository, Mockito.times(1)).getAllOrders();

    }

//    @Test
//    @DisplayName("Searching for valid order by customer id")
//    void getOrderByCustomerIdValid() {
//        //GIVEN
//        orderToFind.setId(1);
//        Mockito.doReturn(singletonList(new Order())).when(orderRepository).getAllOrders();
//        //WHEN
//        orderService.getOrders();
//        //THEN
//        Mockito.verify(orderRepository, Mockito.times(1)).getAllOrders();
//
//    }
}