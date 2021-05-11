package service;

import exceptions.ProductNotFountException;
import models.Product;
import repository.ProductRepository;

import java.util.Collection;
import java.util.List;

import static java.util.Optional.of;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Override
    public Collection<Product> getProducts(){
        return productRepository.getAllProducts();
    }

}
