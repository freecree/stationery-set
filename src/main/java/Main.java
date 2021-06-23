import config.SpringConfig;
import controllers.CategoryController;
import controllers.OrderController;
import controllers.ProductController;
import controllers.UserController;
import models.Category;
import models.Product;
import models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //ProductController productController = context.getBean("productController", ProductController.class);
        OrderController orderController = context.getBean("orderController", OrderController.class);

    }
}
