package repository;

import exception.NotImplementedException;
import models.Product;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductRepository {
    public Collection<Product> getAllProducts() {
        return Collections.emptyList();
    }

    public Product save(Product product) {
        throw new NotImplementedException();
    }

    public Product update(Product product) {
        throw new NotImplementedException();
    }

    public void delete(int id) {

    }
}
