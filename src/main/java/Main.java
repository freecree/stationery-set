import config.SpringConfig;
import controllers.OrderController;
import controllers.ProductController;
import models.Product;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductController productController = context.getBean("productController", ProductController.class);
        OrderController orderController = context.getBean("orderController", OrderController.class);
        System.out.println("products: "+productController.getProducts());
        //productController.createProduct(new Product());
        //System.out.println(orderController.getOrderByCustomerId(1));
        System.out.println("orders: "+orderController.getOrders());

        String url = "jdbc:mysql://localhost:3306/stationary-set";
        String username = "root";
        String password = "111111";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

    }
}
