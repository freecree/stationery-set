import config.SpringConfig;
import controllers.OrderController;
import controllers.ProductController;
import models.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductController productController = context.getBean("productController", ProductController.class);
        OrderController orderController = context.getBean("orderController", OrderController.class);
        System.out.println("products: "+productController.getProducts());
        //productController.createProduct(new Product());
        //System.out.println(orderController.getOrderByCustomerId(1));
        System.out.println("orders: "+orderController.getOrders());

    }
}
