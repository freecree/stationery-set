package services;

import lombok.RequiredArgsConstructor;
import models.Product;
import models.ProductSet;
import org.springframework.stereotype.Service;


public interface ProductSetService {
    ProductSet createSet(ProductSet productSet);
    ProductSet getSetById(Integer id);
    void deleteSet(ProductSet productSet);
    void addProductToSet(Integer setId, Product product, int productAmount);
}
