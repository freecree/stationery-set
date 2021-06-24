package services;

import lombok.RequiredArgsConstructor;
import models.Product;
import models.ProductSet;
//import org.json.simple.JSONObject;
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
    public void addProductToSet(Integer setId, Product product, int productAmount) {
//        ProductSet productSet = getSetById(setId);
//        if (productSet.getProducts() == null) {
//            System.out.println("Set is empty");
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("id", product.getId());
//            jsonObject.put("amount", productAmount);
//            productSet.setProducts(jsonObject.toJSONString());
//        }
//        productSetRepository.save(productSet);
    }

}
