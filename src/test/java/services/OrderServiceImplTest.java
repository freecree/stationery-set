package services;

import exceptions.NotImplementedException;
import exceptions.ProductNotFountException;
import models.Order;
import models.Product;
import models.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.OrderRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

//    @Mock
//    private OrderRepository orderRepository;
//    @InjectMocks
//    private OrderServiceImpl orderService;
//
//    @Mock
//    private Order order1, order2;
////    @Mock
////    private Order order2;
//
//    @Test
//    @DisplayName("Returning orders")
//    void getOrders() {
//        //GIVEN
//        Mockito.doReturn(singletonList(new Order())).when(orderRepository).getAllOrders();
//        //WHEN
//        orderService.getOrders();
//        //THEN
//        Mockito.verify(orderRepository, Mockito.times(1)).getAllOrders();
//
//    }
//
//    @Test
//    @DisplayName("Searching for valid order by product id")
//    void getOrderByProductId() {
//        //GIVEN
//        Product product = new Product();
//        product.setId(1);
//        Order expectedOrder = new Order();
//        expectedOrder.setProduct(product);
//        Mockito.doReturn(Collections.singletonList(expectedOrder)).when(orderRepository).getAllOrders();
//        //WHEN
//        final Order actual = orderService.getOrderByProductId(1);
//        //THEN
//        Assertions.assertEquals(expectedOrder, actual);
//    }
//
//    @Test
//    @DisplayName("Searching for valid order by customer id")
//    void getOrderByCustomerId() {
//        //GIVEN
//        User customer = new User();
//        customer.setId(1);
//        Order expectedOrder = new Order();
//        expectedOrder.setCustomer(customer);
//        Mockito.doReturn(Collections.singletonList(expectedOrder)).when(orderRepository).getAllOrders();
//        //WHEN
//        final Order actual = orderService.getOrderByCustomerId(1);
//        //THEN
//        Assertions.assertEquals(expectedOrder, actual);
//    }
//
//    @Test
//    @DisplayName("testing for saving orders")
//    void saveOrders() {
//        List<Order> mockedOrders = Arrays.asList(order1, order2);
//        orderService.saveOrders(mockedOrders);
//        Mockito.verify(orderRepository, Mockito.times(1)).save(order1);
//        Mockito.verify(orderRepository, Mockito.times(1)).save(order2);
//    }
//
//    @Test()
//    @DisplayName("testing for updating order")
//    public void updateProduct() {
//
////        try {
////            orderService.updateOrder(1);
////        } catch (NotImplementedException e) {
////
////        }
//        orderService.updateOrder(1);
//        Mockito.verify(orderRepository, Mockito.times(1)).update(1);
//
////        Assertions.assertThrows(NotImplementedException.class, () -> {
////            orderService.updateOrder(1);
////            Mockito.verify(orderRepository, Mockito.times(2)).update(1);
////        });
//
//    }
//
//    @Test()
//    @DisplayName("Testing for removing product")
//    public void deleteProduct() {
//        orderService.removeOrder(2);
//        Mockito.verify(orderRepository, Mockito.times(1)).remove(2);
//    }


}