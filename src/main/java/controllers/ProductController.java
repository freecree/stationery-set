package controllers;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.ProductService;
import services.ProductServiceImpl;

import java.util.Collection;

@Controller
public class ProductController {

    private ProductService productService;

    //public ProductController() {}

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Collection<Product> getProducts() {
        return this.productService.getProducts();
    }

    public Product getProductByName(String productName) {
        return this.productService.getProductByName(productName);
    }

    public Product getProductById(int id) {
        return this.productService.getProductById(id);
    }

    public Product createProduct(Product product) {
        return this.productService.createProduct(product);
    }

    public Product updateProduct(Product product) {
        return this.productService.updateProduct(product);
    }

    public void deleteProduct(int id) {
        this.productService.deleteProduct(id);
    }
}
