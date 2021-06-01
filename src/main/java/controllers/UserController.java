package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import repository.UserRepository;

//@Controller
//@EnableJpaRepositories("repository")
public class UserController {

    private UserRepository userRepository;

    //@Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void getUsers() {
        //Iterable<User> users = userRepository.findAll();
        //System.out.println(users);
    }
}
