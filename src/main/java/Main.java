import config.SpringConfig;
import controllers.CategoryController;
import controllers.ProductController;
import controllers.UserController;
import models.Category;
import models.Product;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import services.TestService;

import java.util.List;

//@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductController productController = context.getBean("productController", ProductController.class);
        //ProductController prodController = context.getBean("prodContr", ProductController.class);
        //OrderController orderController = context.getBean("orderController", OrderController.class);
        //System.out.println("products: "+productController.getProducts());
        final ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("Active profile: " + environment.getProperty("spring.profiles.active"));
        //productController.createProduct(new Product());
        //System.out.println(orderController.getOrderByCustomerId(1));
        //System.out.println("orders: "+orderController.getOrders());
        UserController userController = context.getBean("userController", UserController.class);
        CategoryController categoryController = context.getBean("categoryController", CategoryController.class);
        Category category = new Category();
        category.setName("newCategory");
        categoryController.createCategory(category);
        Product product = new Product();
        product.setName("newProduct");
        product.setCategory(category);
        productController.createProduct(product);
        System.out.println("category: ");
        System.out.println(categoryController.getCategoryById(1).getName());
        List<Product> products = productController.getProducts();//categoryController.getCategoryById(1).getProducts();
        System.out.println(products.get(0).getName());
        //System.out.println(categoryController.getCategoryById(1).getProducts());
        //System.out.println(userController.getUsers());
        TestService testService = context.getBean("testService", TestService.class);
        System.out.println(testService.getTestRecords());

    }
}
