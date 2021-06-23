package services;

import lombok.RequiredArgsConstructor;
import models.ProductSet;
import org.springframework.stereotype.Service;
import repository.ProductSetRepository;

@Service
@RequiredArgsConstructor
public class ProductSetServiceImpl implements ProductSetService {
    final private ProductSetRepository productSetRepository;

    public ProductSet createSet(ProductSet productSet) {
        return productSetRepository.save(productSet);
    }
    public ProductSet getSetById(Integer id) {
        return productSetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldn't find product Set with id " + id));
    }
    public void deleteSet(ProductSet productSet) {
        productSetRepository.delete(productSet);
    }

}
