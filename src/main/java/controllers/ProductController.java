package controllers;

import lombok.RequiredArgsConstructor;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import services.ProductService;
import services.ProductServiceImpl;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    public List<Product> getProducts() {
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

    public void deleteProduct(Product product) {
        this.productService.deleteProduct(product);
    }
}
