package services;

import exceptions.ProductNotFountException;
import models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ProductRepository;

import java.util.Collection;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService; // ProductService(Product Repository)

    @Mock
    private Product product;

    @Before
    public void setUp() {
        product = new Product();
    }

    @Test
    @DisplayName("Searching for valid product by name")
    public void getProductByNameValid() {
        Product product1 = new Product();
        product1.setName("prod1");

        final Collection<Product> products = Collections.singletonList(
                product1);
        Mockito.doReturn(products).when(productRepository).getAllProducts();
        //WHEN
        final Product actual = productService.getProductByName("prod1");
        //THEN
        Mockito.verify(productRepository, Mockito.times(1)).getAllProducts();
        Assert.assertEquals(actual, product1);
    }

    @Test()
    @DisplayName("Searching for invalid product by name")
    public void getProductByNameInvalid() {
        Product product1 = new Product();
        product1.setName("prod2");

        final Collection<Product> products = Collections.singletonList(
                product1);
        Mockito.doReturn(products).when(productRepository).getAllProducts();
        //WHEN
        Assertions.assertThrows(ProductNotFountException.class, () -> {
            final Product actual = productService.getProductByName("prod1");
        });
    }

    @Test
    @DisplayName("Searching for valid product by id")
    public void getProductByIdValid() {
        Product product1 = new Product();
        product1.setId(1);

        final Collection<Product> products = Collections.singletonList(
                product1);
        Mockito.doReturn(products).when(productRepository).getAllProducts();
        //WHEN
        final Product actual = productService.getProductById(1);
        //THEN
        Mockito.verify(productRepository, Mockito.times(1)).getAllProducts();
        Assert.assertEquals(actual, product1);
    }

    @Test()
    @DisplayName("Searching for invalid product by id")
    public void getProductByIdInvalid() {
        Product product1 = new Product();
        product1.setId(2);

        final Collection<Product> products = Collections.singletonList(
                product1);
        Mockito.doReturn(products).when(productRepository).getAllProducts();
        //WHEN
        Assertions.assertThrows(ProductNotFountException.class, () -> {
            final Product actual = productService.getProductById(1);
        });
    }

    @Test()
    @DisplayName("Saving product")
    public void saveProduct() {
        productService.createProduct(product);
        Mockito.verify(productRepository, Mockito.times(1)).create(product);
    }

    @Test()
    @DisplayName("Updating product")
    public void updateProduct() {
        productService.updateProduct(product);
        Mockito.verify(productRepository, Mockito.times(1)).update(product);
    }

    @Test()
    @DisplayName("Deleting product")
    public void deleteProduct() {
        productService.deleteProduct(2);
        Mockito.verify(productRepository, Mockito.times(1)).delete(2);
    }



}