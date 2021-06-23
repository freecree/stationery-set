package repository;

import exceptions.NotImplementedException;
import models.Product;
import models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
