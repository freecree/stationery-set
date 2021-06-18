package services;

import exceptions.ProductNotFountException;
import lombok.RequiredArgsConstructor;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.util.Optional.of;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductByName(String prodName) {
        return of(prodName)
            .map(s -> getProducts().stream()
                .filter(prod -> prod.getName().equals(s))
                .findAny()
                .orElseThrow(ProductNotFountException::new)
            ).orElseThrow(ProductNotFountException::new);
    }

    @Override
    public Product getProductById(int id) {
        return of(id)
                .map(s -> getProducts().stream()
                        .filter(prod -> prod.getId() == s)
                        .findAny()
                        .orElseThrow(ProductNotFountException::new)
                ).orElseThrow(ProductNotFountException::new);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Collection<Product> getProducts(){
        return productRepository.findAll();
    }

}
