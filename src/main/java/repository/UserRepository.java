package repository;

import models.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

//@Repository
//@EnableJpaRepositories("repository")
public interface UserRepository extends CrudRepository<User, Integer> {

}