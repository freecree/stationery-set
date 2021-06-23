package controllers;

import config.SpringConfig;
import models.Product;
import models.PropertyValue;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private static AnnotationConfigApplicationContext context;
    private static ProductController productController;
    final private static  Product product1 = new Product();
    final private static Product product2 = new Product();

    @BeforeAll
    static void setUp() {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        productController = context.getBean("productController", ProductController.class);
        product1.setName("product1");
        product2.setName("product2");
    }

    @Test
    @DisplayName("Testing for getting 2 created products")
    public void getProducts() {
        //GIVEN
        Product expectedProduct1 = productController.createProduct(product1);

        Product expectedProduct2 = productController.createProduct(product2);

        final List<Product> expectedProducts = List.of(expectedProduct1, expectedProduct2);
        //WHEN
        List <Product> actualProducts = productController.getProducts();
        //THEN
        Assertions.assertEquals(expectedProducts, actualProducts);
        productController.deleteProduct(expectedProduct2);
        productController.deleteProduct(expectedProduct1);
        System.out.println("expected1: "+ expectedProduct1);
        System.out.println("expected2: "+ expectedProduct2);


    }

    @Test
    @DisplayName("testing for creating and getting product by id")
    public void getProductById() {
        //GIVEN
        Product expectedProduct = productController.createProduct(product1);
        //WHEN
        Product actualProduct = productController.getProductById(expectedProduct.getId());
        //THEN
        Assertions.assertEquals(expectedProduct, actualProduct);
        productController.deleteProduct(expectedProduct);
    }

    @Test
    @DisplayName("testing for creating and getting product by name")
    public void getProductByName() {
        //GIVEN
        Product expectedProduct = productController.createProduct(product1);
        //WHEN
        Product actualProduct = productController.getProductByName(expectedProduct.getName());
        //THEN
        Assertions.assertEquals(expectedProduct, actualProduct);
        productController.deleteProduct(expectedProduct);
    }

    @Test
    @DisplayName("testing for updating product")
    public void updateProduct() {
        //GIVEN
        Product expectedProduct = productController.createProduct(product1);
        expectedProduct.setDescription("Updated");
        productController.createProduct(expectedProduct);
        //WHEN
        Product actualProduct = productController.getProductById(expectedProduct.getId());

        //THEN
        Assertions.assertEquals(expectedProduct, actualProduct);
        productController.deleteProduct(expectedProduct);
    }
}