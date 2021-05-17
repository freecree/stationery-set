package repository;

import exceptions.NotImplementedException;
import models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;

@Repository
public class ProductRepository {
    public Collection<Product> getAllProducts() {
        return Collections.emptyList();
    }

    public Product create(Product product) {
        throw new NotImplementedException();
    }

    public Product update(Product product) {
        throw new NotImplementedException();
    }

    public void delete(int id) {

    }
}
