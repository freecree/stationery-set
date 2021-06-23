package repository;

import models.ProductSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSetRepository extends JpaRepository<ProductSet, Integer> {
}
