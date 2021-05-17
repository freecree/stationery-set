package services;

import models.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> getProducts();
    Product getProductByName(String productName);
    Product getProductById(int id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(int id);

}
