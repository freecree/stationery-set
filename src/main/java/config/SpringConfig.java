package config;

import controllers.OrderController;
import models.Order;
import models.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import repository.OrderRepository;
import repository.UserRepository;
import services.OrderService;
import services.OrderServiceImpl;

import java.util.List;
import java.util.Optional;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"controllers", "services", "models", "repository"})
//@EntityScan(basePackages = "models")
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "repository")
@Import(HibernateConfig.class)
public class SpringConfig {
    @Bean
    public OrderController orderController() {
        return new OrderController(orderService());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl((OrderRepository) orderRepository());
    }

//    @Bean
//    public OrderRepository orderRepository() {
//        return new OrderRepository();
//    }


    @Bean
    public JpaRepositoryFactoryBean<OrderRepository, Order, Integer> orderRepository() {
        JpaRepositoryFactoryBean factory = new JpaRepositoryFactoryBean(OrderRepository.class);
        return factory;
    }


}
