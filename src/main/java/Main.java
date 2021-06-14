import config.SpringConfig;
import controllers.OrderController;
import controllers.ProductController;
import controllers.UserController;
import models.Product;
import models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductController productController = context.getBean("productController", ProductController.class);
        OrderController orderController = context.getBean("orderController", OrderController.class);
        System.out.println("products: "+productController.getProducts());
        final ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("Active profile: " + environment.getProperty("spring.profiles.active"));
        //productController.createProduct(new Product());
        //System.out.println(orderController.getOrderByCustomerId(1));
        System.out.println("orders: "+orderController.getOrders());
        UserController userController = context.getBean("userController", UserController.class);
        User user = new User();

        user.setLogin("Barabos");
        //userController.createUser(user);
        //System.out.println(userController.getUsers());

    }
}
