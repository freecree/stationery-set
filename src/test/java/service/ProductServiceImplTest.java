package service;

import models.Product;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

//    @Before
//    void setUp() {
//        //productService = new ProductServiceImpl(productRepository);
//    }

    @Test
    @DisplayName("Test for searching of product")
    public void getProductByName() {
        productService = new ProductServiceImpl(productRepository);
        productService.getProductByName("pen");
    }

    @Test
    public void orderProduct() {
    }

    @Test
    public void getProducts() {
    }
}