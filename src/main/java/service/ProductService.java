package service;

import models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
    public Product getProductByName(String prodName);
    public void orderProduct(long id);
}
