package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import repository.UserRepository;

import java.util.List;

@Controller
//@EnableJpaRepositories("repository")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
        //System.out.println(users);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
