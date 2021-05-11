package service;

import models.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    public Collection<Product> getProducts();
    public Product getProductByName(String productName);
    public Product getProductById(int id);
    public Product saveProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int id);

}
