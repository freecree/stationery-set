package services;

import models.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProductByName(String productName);
    Product getProductById(int id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);

}
