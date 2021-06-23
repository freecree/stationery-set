package services;

import lombok.RequiredArgsConstructor;
import models.ProductSet;
import org.springframework.stereotype.Service;


public interface ProductSetService {
    ProductSet createSet(ProductSet productSet);
    ProductSet getSetById(Integer id);
    void deleteSet(ProductSet productSet);
}
