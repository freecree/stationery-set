package config;

import controllers.ProductController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import repository.ProductRepository;
import services.ProductService;
import services.ProductServiceImpl;

@Configuration
@PropertySource({"classpath:application.properties"}) //classpath:application.properties
@ComponentScan(basePackages = {"controllers", "services", "models", "repository", "application.views"})
//@EnableAutoConfiguration
@Import(HibernateConfig.class)
public class SpringConfig {
//    @Bean(name = "prodController")
//    ProductController productController() {
//        return new ProductController(productService());
//    }
//    @Bean
//    ProductService productService() {
//        return new ProductServiceImpl(productRepository());
//    }
//    @Bean()
//    ProductRepository productRepository() {
//        return new ProductRepository();
//    }


}
