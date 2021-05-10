package service;

import exceptions.ProductNotFountException;
import models.Product;
import repository.ProductRepository;

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
                .get()
            ).orElseThrow(ProductNotFountException::new);


    }

    @Override
    public void orderProduct(long id) {

    }

    @Override
    public List<Product> getProducts(){
        return productRepository.getAllProducts();
    }

}
